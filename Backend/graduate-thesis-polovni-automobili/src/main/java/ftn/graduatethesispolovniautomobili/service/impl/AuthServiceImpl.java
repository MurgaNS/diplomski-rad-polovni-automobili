package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.exception.BadRequestException;
import ftn.graduatethesispolovniautomobili.exception.PasswordMatchException;
import ftn.graduatethesispolovniautomobili.model.dto.auth.request.ChangePasswordRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.auth.request.SignupVerificationDTO;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import ftn.graduatethesispolovniautomobili.security.TokenUtils;
import ftn.graduatethesispolovniautomobili.service.AuthService;
import ftn.graduatethesispolovniautomobili.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final TokenUtils tokenUtils;


    public AuthServiceImpl(UserService userService, PasswordEncoder passwordEncoder, TokenUtils tokenUtils) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.tokenUtils = tokenUtils;
    }

    @Override
    public void changePassword(ChangePasswordRequestDTO changePasswordRequestDTO, Authentication authentication) {

        User currentLoggedUser = userService.findCurrentLoggedUser(authentication);

        if (currentLoggedUser == null) {
            throw new BadRequestException("Please provide a valid user");
        }

        if (passwordEncoder.matches(changePasswordRequestDTO.getCurrentPassword(), currentLoggedUser.getPassword()) &&
                changePasswordRequestDTO.getNewPassword().equals(changePasswordRequestDTO.getConfirmNewPassword())) {
            currentLoggedUser.setPassword(passwordEncoder.encode(changePasswordRequestDTO.getNewPassword()));
            userService.save(currentLoggedUser);

        } else {
            throw new PasswordMatchException("Passwords must match");
        }
    }

    @Override
    public void signupVerification(SignupVerificationDTO signupVerificationDTO) {

        User user = userService.findByEmail(tokenUtils.getEmailFromToken(signupVerificationDTO.getToken()));

        if (tokenUtils.isTokenExpired(signupVerificationDTO.getToken()) || user == null) {
            throw new BadRequestException("Token is invalid");
        }
        user.setVerification(true);
        userService.save(user);
    }
}


