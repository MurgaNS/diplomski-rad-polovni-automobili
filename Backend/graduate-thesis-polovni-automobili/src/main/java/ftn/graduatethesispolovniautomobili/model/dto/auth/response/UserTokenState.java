package ftn.graduatethesispolovniautomobili.model.dto.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserTokenState {
    private String accessToken;
    private Long expiresIn;
}