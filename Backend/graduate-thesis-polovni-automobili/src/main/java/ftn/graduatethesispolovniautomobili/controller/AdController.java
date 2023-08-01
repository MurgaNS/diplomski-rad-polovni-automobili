package ftn.graduatethesispolovniautomobili.controller;

import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdChangeStatusDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.response.AdResponseDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import ftn.graduatethesispolovniautomobili.model.mapper.AdMapper;
import ftn.graduatethesispolovniautomobili.service.AdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/ad")
public class AdController {

    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<AdResponseDTO> addNewClient(@Validated @RequestBody AdRequestDTO adRequestDTO,
                                                      Authentication authentication) {

        Ad createdAd = adService.addNewAd(adRequestDTO, authentication);

        AdResponseDTO clientResponseDTO = AdMapper.toAdResponseDTO(createdAd);

        return new ResponseEntity<>(clientResponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<AdResponseDTO> getAll(){

        List<Ad> ad = adService.getAll();

        List<AdResponseDTO> adResponseDTO = AdMapper.toDTOs(ad);

        return new ResponseEntity(adResponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AdResponseDTO> getById(@PathVariable Integer id){

        Ad ad = adService.getById(id);

        AdResponseDTO adResponseDTO = AdMapper.toAdResponseDTO(ad);

        return new ResponseEntity<>(adResponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/active")
    public ResponseEntity<AdResponseDTO> getAllActive(){

        List<Ad> ad =adService.getAllActive();

        List<AdResponseDTO> adResponseDTO = AdMapper.toDTOs(ad);

        return new ResponseEntity(adResponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/inactive")
    public ResponseEntity<AdResponseDTO> getAllInactive(){

        List<Ad> ad =adService.getAllInactive();

        List<AdResponseDTO> adResponseDTO = AdMapper.toDTOs(ad);

        return new ResponseEntity(adResponseDTO, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}/change-status")
    public ResponseEntity<AdResponseDTO> changeStatus(@RequestBody AdChangeStatusDTO adChangeStatusDTO, @PathVariable Integer id){

        Ad ad = adService.changeStatus(id,adChangeStatusDTO);

        AdResponseDTO adResponseDTO = AdMapper.toAdResponseDTO(ad);

        return new ResponseEntity(adResponseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AdResponseDTO> updateAd(@RequestBody AdRequestDTO adRequestDTO,@PathVariable Integer id, Authentication authentication){

        Ad updatedAd = adService.updateAd(id,adRequestDTO,authentication);

        AdResponseDTO adResponseDTO = AdMapper.toAdResponseDTO(updatedAd);

        return new ResponseEntity(adResponseDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/follow")
    public ResponseEntity<AdResponseDTO> followAd(@PathVariable Integer id, Authentication authentication){

        Ad followedAd = adService.followAd(id, authentication);

        AdResponseDTO adResponseDTO = AdMapper.toAdResponseDTO(followedAd);

        return new ResponseEntity(adResponseDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<AdResponseDTO>> search(@RequestBody(required = false) AdRequestDTO adRequestDTO) {

        List<Ad> ads = adService.search(adRequestDTO);
        List<AdResponseDTO> adResponseDTOS = AdMapper.toDTOs(ads);

        return new ResponseEntity(adResponseDTOS, HttpStatus.OK);

    }


}
