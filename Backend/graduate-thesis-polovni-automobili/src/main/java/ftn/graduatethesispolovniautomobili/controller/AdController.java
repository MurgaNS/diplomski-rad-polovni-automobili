package ftn.graduatethesispolovniautomobili.controller;

import ftn.graduatethesispolovniautomobili.exception.BadRequestException;
import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdChangeStatusDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.response.AdResponseDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import ftn.graduatethesispolovniautomobili.model.mapper.AdMapper;
import ftn.graduatethesispolovniautomobili.service.AdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/ad")
@CrossOrigin
public class AdController {

    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    @PostMapping(value = "/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_REGULAR')")
    public ResponseEntity<AdResponseDTO> create(@Validated @RequestBody AdRequestDTO adRequestDTO,
                                                Authentication authentication) {

        try {

            Ad createdAd = adService.addNewAd(adRequestDTO, authentication);

            AdResponseDTO clientResponseDTO = AdMapper.toAdResponseDTO(createdAd);

            return new ResponseEntity<>(clientResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping(value = "/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AdResponseDTO> getAll() {

        try {

            List<Ad> ad = adService.getAll();

            List<AdResponseDTO> adResponseDTO = AdMapper.toDTOs(ad);

            return new ResponseEntity(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdResponseDTO> getById(@PathVariable Integer id) {

        try {

            Ad ad = adService.getById(id);

            AdResponseDTO adResponseDTO = AdMapper.toAdResponseDTO(ad);

            return new ResponseEntity<>(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping(value = "/active")
    public ResponseEntity<AdResponseDTO> getAllActive() {

        try {

            List<Ad> ad = adService.getAllActive();

            List<AdResponseDTO> adResponseDTO = AdMapper.toDTOs(ad);

            return new ResponseEntity(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping(value = "/inactive")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<AdResponseDTO> getAllInactive() {

        try {

            List<Ad> ad = adService.getAllInactive();

            List<AdResponseDTO> adResponseDTO = AdMapper.toDTOs(ad);

            return new ResponseEntity(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PatchMapping(value = "/{id}/change-status")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_REGULAR')")
    public ResponseEntity<AdResponseDTO> changeStatus(@RequestBody AdChangeStatusDTO adChangeStatusDTO, @PathVariable Integer id) {

        try {

            Ad ad = adService.changeStatus(id, adChangeStatusDTO);

            AdResponseDTO adResponseDTO = AdMapper.toAdResponseDTO(ad);

            return new ResponseEntity(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_REGULAR')")
    public ResponseEntity<AdResponseDTO> updateAd(@RequestBody AdRequestDTO adRequestDTO, @PathVariable Integer id, Authentication authentication) {

        try {

            Ad updatedAd = adService.updateAd(id, adRequestDTO, authentication);

            AdResponseDTO adResponseDTO = AdMapper.toAdResponseDTO(updatedAd);

            return new ResponseEntity(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping(value = "/{id}/follow")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_REGULAR')")
    public ResponseEntity<AdResponseDTO> followAd(@PathVariable Integer id, Authentication authentication) {

        try {

            Ad followedAd = adService.followAd(id, authentication);

            AdResponseDTO adResponseDTO = AdMapper.toAdResponseDTO(followedAd);

            return new ResponseEntity(adResponseDTO, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<AdResponseDTO>> search(@RequestBody(required = false) AdRequestDTO adRequestDTO) {
        try {

            List<Ad> ads = adService.search(adRequestDTO);

            List<AdResponseDTO> adResponseDTOS = AdMapper.toDTOs(ads);

            return new ResponseEntity(adResponseDTOS, HttpStatus.OK);

        } catch (BadRequestException exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }


}
