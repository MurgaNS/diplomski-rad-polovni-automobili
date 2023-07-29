package ftn.graduatethesispolovniautomobili.model.dto.auth.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SignupVerificationDTO {

    @NotNull(message = "Token is mandatory")
    private String token;
}