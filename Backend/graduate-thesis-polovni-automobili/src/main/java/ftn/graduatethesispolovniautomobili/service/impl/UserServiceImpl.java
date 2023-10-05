package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.exception.BadRequestException;
import ftn.graduatethesispolovniautomobili.exception.PasswordMatchException;
import ftn.graduatethesispolovniautomobili.model.dto.auth.request.ChangePasswordRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.auth.request.SignupVerificationDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import ftn.graduatethesispolovniautomobili.model.mapper.UserMapper;
import ftn.graduatethesispolovniautomobili.repository.UserRepository;
import ftn.graduatethesispolovniautomobili.security.TokenUtils;
import ftn.graduatethesispolovniautomobili.service.EmailService;
import ftn.graduatethesispolovniautomobili.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final TokenUtils tokenUtils;

    private final EmailService emailService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, EmailService emailService, TokenUtils tokenUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.tokenUtils = tokenUtils;
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {

        Optional<User> user = userRepository.findFirstByEmail(email);

        return user.orElse(null);
    }

    @Override
    public void changePassword(ChangePasswordRequestDTO changePasswordRequestDTO, Authentication authentication) {

        User currentLoggedUser = findCurrentLoggedUser(authentication);

        if (currentLoggedUser == null) {
            throw new BadRequestException("Please provide a valid user");
        }

        if (passwordEncoder.matches(changePasswordRequestDTO.getCurrentPassword(), currentLoggedUser.getPassword()) &&
                changePasswordRequestDTO.getNewPassword().equals(changePasswordRequestDTO.getConfirmNewPassword())) {
            currentLoggedUser.setPassword(passwordEncoder.encode(changePasswordRequestDTO.getNewPassword()));
            save(currentLoggedUser);

        } else {
            throw new PasswordMatchException("Passwords must match");
        }
    }

    @Override
    public void signupVerification(SignupVerificationDTO signupVerificationDTO) {

        User user = findByEmail(tokenUtils.getEmailFromToken(signupVerificationDTO.getToken()));

        if (tokenUtils.isTokenExpired(signupVerificationDTO.getToken()) || user == null) {
            throw new BadRequestException("Token is invalid");
        }
        user.setVerification(true);
        save(user);
    }

    @Override
    public User findCurrentLoggedUser(Authentication authentication) {

        UserDetails user = (UserDetails) authentication.getPrincipal();

        return findByEmail(user.getUsername());
    }

    @Override
    public UserDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO) {

        User newUser = UserMapper.mapRegistrationRegularUser(userRegistrationRequestDTO);
        newUser.setPassword(passwordEncoder.encode(userRegistrationRequestDTO.getPassword()));

        newUser.setVerification(false);

        save(newUser);

        emailService.sendVerificationEmail(userRegistrationRequestDTO);

        return UserMapper.mapUserDTO(newUser);
    }


}
