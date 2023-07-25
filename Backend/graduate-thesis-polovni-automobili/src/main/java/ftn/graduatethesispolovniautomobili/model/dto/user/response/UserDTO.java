package ftn.graduatethesispolovniautomobili.model.dto.user.response;

import ftn.graduatethesispolovniautomobili.model.enumeration.EUserRole;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String country;
    private String city;
    private String district;
    private Integer zip;
    private String address;
    private String phoneNumber;
    private EUserRole role;



}
