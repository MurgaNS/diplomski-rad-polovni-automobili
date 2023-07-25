package ftn.graduatethesispolovniautomobili.service;

import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.entity.User;

public interface UserService {
    UserDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO);

    User findByUsername(String username);
}
