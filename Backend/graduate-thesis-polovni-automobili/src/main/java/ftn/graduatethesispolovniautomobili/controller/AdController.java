package ftn.graduatethesispolovniautomobili.controller;

import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.response.AdResponseDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import ftn.graduatethesispolovniautomobili.model.mapper.AdMapper;
import ftn.graduatethesispolovniautomobili.service.AdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
