package ftn.graduatethesispolovniautomobili.model.mapper;

import ftn.graduatethesispolovniautomobili.model.dto.user.request.UserRegistrationRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import ftn.graduatethesispolovniautomobili.model.enumeration.EUserRole;

public class UserMapper {


    public static UserDTO mapUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setCity(user.getCity());
        userDTO.setAddress(user.getAddress());
        userDTO.setCountry(user.getCountry());
        userDTO.setDistrict(user.getDistrict());
        userDTO.setRole(user.getRole());
        userDTO.setZip(user.getZip());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

    public static User mapRegistrationRegularUser(UserRegistrationRequestDTO userDTO) {
        User user = new User();
        user.setCity(userDTO.getCity());
        user.setAddress(userDTO.getAddress());
        user.setCountry(userDTO.getCountry());
        user.setDistrict(userDTO.getDistrict());
        user.setRole(EUserRole.REGULAR);
        user.setZip(userDTO.getZip());
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());

        return user;
    }
}
