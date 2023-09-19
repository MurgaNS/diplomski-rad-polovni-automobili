package ftn.graduatethesispolovniautomobili.controller;

import ftn.graduatethesispolovniautomobili.exception.BadRequestException;
import ftn.graduatethesispolovniautomobili.exception.PasswordMatchException;
import ftn.graduatethesispolovniautomobili.model.dto.auth.request.ChangePasswordRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.auth.request.LoginRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.auth.request.SignupVerificationDTO;
import ftn.graduatethesispolovniautomobili.model.dto.auth.response.UserTokenState;
import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import ftn.graduatethesispolovniautomobili.security.TokenUtils;
import ftn.graduatethesispolovniautomobili.service.AuthService;
import ftn.graduatethesispolovniautomobili.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;
    private final UserServiceImpl userService;

    private final AuthService authService;

    public AuthController(TokenUtils tokenUtils, UserServiceImpl userService, AuthenticationManager authenticationManager, AuthService authService) {
        this.tokenUtils = tokenUtils;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken
            (@Validated @RequestBody LoginRequestDTO employeeLoginRequestDTO) {

        try {

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    employeeLoginRequestDTO.getEmail(), employeeLoginRequestDTO.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            User user = userService.findByEmail(userDetails.getUsername());
            if (!user.isVerification()) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            String jwt = tokenUtils.generateToken(userDetails.getUsername(), userDetails.getAuthorities().toArray()[0].toString());
            long expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody @Validated UserRegistrationRequestDTO userRegistrationRequestDTO) {

        try {

            UserDTO createdUser = userService.registerUser(userRegistrationRequestDTO);
            if (createdUser == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(createdUser, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping(value = "/change-password")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_REGULAR')")
    public ResponseEntity<String> changePassword(@RequestBody @Validated ChangePasswordRequestDTO changePasswordDTO, Authentication authentication) {

        try {

            authService.changePassword(changePasswordDTO, authentication);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (BadRequestException | PasswordMatchException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping(value = "/verify-account")
    public ResponseEntity<String> signupVerification(@RequestBody @Validated SignupVerificationDTO signupVerificationDTO) {

        try {

            authService.signupVerification(signupVerificationDTO);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (BadRequestException | PasswordMatchException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }


}
