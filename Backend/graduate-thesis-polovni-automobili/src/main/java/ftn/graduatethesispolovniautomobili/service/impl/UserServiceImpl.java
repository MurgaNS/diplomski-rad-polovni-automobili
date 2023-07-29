package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import ftn.graduatethesispolovniautomobili.model.mapper.UserMapper;
import ftn.graduatethesispolovniautomobili.repository.UserRepository;
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

    private final EmailService emailService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
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
    public User findCurrentLoggedUser(Authentication authentication) {

        UserDetails user = (UserDetails) authentication.getPrincipal();

        return findByEmail(user.getUsername());
    }

    public UserDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO) {

        User newUser = UserMapper.mapRegistrationRegularUser(userRegistrationRequestDTO);
        newUser.setPassword(passwordEncoder.encode(userRegistrationRequestDTO.getPassword()));

        newUser.setVerification(false);

        save(newUser);

        emailService.sendVerificationEmail(userRegistrationRequestDTO);

        return UserMapper.mapUserDTO(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
