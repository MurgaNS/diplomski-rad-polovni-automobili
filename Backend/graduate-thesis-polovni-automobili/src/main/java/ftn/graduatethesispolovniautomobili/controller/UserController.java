package ftn.graduatethesispolovniautomobili.controller;

import ftn.graduatethesispolovniautomobili.exception.BadRequestException;
import ftn.graduatethesispolovniautomobili.model.dto.ad.response.AdResponseDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import ftn.graduatethesispolovniautomobili.model.mapper.AdMapper;
import ftn.graduatethesispolovniautomobili.service.AdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final AdService adService;

    public UserController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping(value = "/myAds")
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
    private ResponseEntity<AdResponseDTO> getFollowedAds(Authentication authentication) {

        try {

            List<Ad> ad = adService.getFollowedAds(authentication);

            List<AdResponseDTO> adResponseDTO = AdMapper.toDTOs(ad);

            return new ResponseEntity(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }
}
