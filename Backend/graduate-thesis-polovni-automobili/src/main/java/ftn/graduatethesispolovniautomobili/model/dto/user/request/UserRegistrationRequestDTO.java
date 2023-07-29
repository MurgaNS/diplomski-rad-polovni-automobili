package ftn.graduatethesispolovniautomobili.model.dto.user.request;

import ftn.graduatethesispolovniautomobili.model.enumeration.EUserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDTO {


    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String country;
    private String city;
    private String district;
    private Integer zip;
    private String address;
    private String phoneNumber;
    private String email;
    private EUserRole role;

}
