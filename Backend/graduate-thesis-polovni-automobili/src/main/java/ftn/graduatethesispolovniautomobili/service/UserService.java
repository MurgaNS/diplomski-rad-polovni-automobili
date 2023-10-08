package ftn.graduatethesispolovniautomobili.service;

import ftn.graduatethesispolovniautomobili.model.dto.auth.request.ChangePasswordRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.auth.request.SignupVerificationDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import org.springframework.security.core.Authentication;

public interface UserService {
    UserDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO);

    User findCurrentLoggedUser(Authentication authentication);

    User save(User user);

    User findByEmail(String email);

    void changePassword(ChangePasswordRequestDTO changePasswordRequestDTO, Authentication authentication);

    void signupVerification(SignupVerificationDTO signupVerificationDTO);


}
