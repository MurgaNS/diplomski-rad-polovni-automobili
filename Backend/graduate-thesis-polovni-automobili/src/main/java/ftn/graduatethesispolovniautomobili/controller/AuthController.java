package ftn.graduatethesispolovniautomobili.controller;

import ftn.graduatethesispolovniautomobili.model.dto.auth.request.LoginRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.auth.response.UserTokenState;
import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.security.TokenUtils;
import ftn.graduatethesispolovniautomobili.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;
    private final UserServiceImpl userService;

    public AuthController(TokenUtils tokenUtils, UserServiceImpl userService, AuthenticationManager authenticationManager) {
        this.tokenUtils = tokenUtils;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken
            (@Validated @RequestBody LoginRequestDTO userLoginRequestDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLoginRequestDTO.getUsername(), userLoginRequestDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername(), user.getAuthorities().toArray()[0].toString());
        long expiresIn = tokenUtils.getExpiredIn();

        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody @Validated UserRegistrationRequestDTO userRegistrationRequestDTO) {

        UserDTO createdUser = userService.registerUser(userRegistrationRequestDTO);

        if (createdUser == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }
}
