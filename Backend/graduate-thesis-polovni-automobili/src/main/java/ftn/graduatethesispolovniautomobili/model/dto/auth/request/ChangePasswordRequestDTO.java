package ftn.graduatethesispolovniautomobili.model.dto.auth.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ChangePasswordRequestDTO {

    @NotNull(message = "Current password is mandatory")
    private String currentPassword;
    @NotNull(message = "New password is mandatory")
    private String newPassword;
    @NotNull(message = "Confirm password is mandatory")
    private String confirmNewPassword;
}
