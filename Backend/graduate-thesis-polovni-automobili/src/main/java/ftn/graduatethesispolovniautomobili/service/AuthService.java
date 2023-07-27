package ftn.graduatethesispolovniautomobili.service;

import ftn.graduatethesispolovniautomobili.model.dto.auth.request.ChangePasswordRequestDTO;
import org.springframework.security.core.Authentication;

public interface AuthService {

    void changePassword(ChangePasswordRequestDTO changePasswordRequestDTO, Authentication authentication);


}
