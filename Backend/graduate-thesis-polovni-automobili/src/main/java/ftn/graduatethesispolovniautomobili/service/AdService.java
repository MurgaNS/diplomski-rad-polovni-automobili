package ftn.graduatethesispolovniautomobili.service;

import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdRequestDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import org.springframework.security.core.Authentication;

public interface AdService
{
    Ad addNewAd(AdRequestDTO adRequestDTO, Authentication authentication);

    Ad save(Ad ad);

}
