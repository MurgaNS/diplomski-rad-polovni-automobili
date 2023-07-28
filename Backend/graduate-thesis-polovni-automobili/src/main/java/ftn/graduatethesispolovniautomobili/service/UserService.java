package ftn.graduatethesispolovniautomobili.service;

import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import org.springframework.security.core.Authentication;

public interface UserService {
    UserDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO);

    User findByUsername(String username);

    User findCurrentLoggedUser(Authentication authentication);

    User save(User user);

}
