package ftn.graduatethesispolovniautomobili.controller;

import ftn.graduatethesispolovniautomobili.exception.BadRequestException;
import ftn.graduatethesispolovniautomobili.model.dto.ad.response.AdResponseDTO;
import ftn.graduatethesispolovniautomobili.model.dto.user.response.UserDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import ftn.graduatethesispolovniautomobili.model.mapper.AdMapper;
import ftn.graduatethesispolovniautomobili.model.mapper.UserMapper;
import ftn.graduatethesispolovniautomobili.service.AdService;
import ftn.graduatethesispolovniautomobili.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final AdService adService;

    private final UserService userService;

    public UserController(AdService adService, UserService userService) {
        this.adService = adService;
        this.userService = userService;
    }

    @GetMapping(value = "/myAds")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_REGULAR')")
    private ResponseEntity<AdResponseDTO> getUserAds(Authentication authentication) {

        try {

            List<Ad> ad = adService.getUserAds(authentication);

            List<AdResponseDTO> adResponseDTO = AdMapper.toDTOs(ad);

            return new ResponseEntity(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping(value = "/followedAds")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_REGULAR')")
    private ResponseEntity<AdResponseDTO> getFollowedAds(Authentication authentication) {

        try {

            List<Ad> ad = adService.getFollowedAds(authentication);

            List<AdResponseDTO> adResponseDTO = AdMapper.toDTOs(ad);

            return new ResponseEntity(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping(value = "/myProfile")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_REGULAR')")
    private ResponseEntity<UserDTO> getProfileInfo(Authentication authentication) {

        try {

            User user = userService.findCurrentLoggedUser(authentication);

            UserDTO userDTO = UserMapper.mapUserDTO(user);

            return new ResponseEntity(userDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

}
