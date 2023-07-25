package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import ftn.graduatethesispolovniautomobili.model.mapper.UserMapper;
import ftn.graduatethesispolovniautomobili.repository.UserRepository;
import ftn.graduatethesispolovniautomobili.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public UserDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO) {

        User newUser = UserMapper.mapRegistrationRegularUser(userRegistrationRequestDTO);
        newUser.setPassword(passwordEncoder.encode(userRegistrationRequestDTO.getPassword()));
        save(newUser);

//        emailService.sendVerificationEmail(userDTO);

        return UserMapper.mapUserDTO(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
