package ftn.graduatethesispolovniautomobili.service;

import ftn.graduatethesispolovniautomobili.model.dto.auth.request.ChangePasswordRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.auth.request.SignupVerificationDTO;
import org.springframework.security.core.Authentication;

public interface AuthService {

    void changePassword(ChangePasswordRequestDTO changePasswordRequestDTO, Authentication authentication);

    void signupVerification(SignupVerificationDTO signupVerificationDTO);


}
