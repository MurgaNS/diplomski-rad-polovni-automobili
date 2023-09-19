package ftn.graduatethesispolovniautomobili.service;

import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdChangeStatusDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdSearchRequestDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface AdService
{
    Ad addNewAd(AdRequestDTO adRequestDTO, Authentication authentication);

    Ad save(Ad ad);

    List<Ad> getAll();

    List<Ad> getAllActive();

    List<Ad> getAllInactive();

    List<Ad> search(AdSearchRequestDTO adSearchRequestDTO);

    List<Ad> getUserAds(Authentication authentication);

    List<Ad> getFollowedAds(Authentication authentication);

    List<String> getUsersEmailByFollowedAd(Integer id);

    Ad changeStatus(Integer id,AdChangeStatusDTO adChangeStatusDTO);

    Ad getById(Integer id);

    Ad updateAd(Integer id, AdRequestDTO adRequestDTO, Authentication authentication);

    Ad followAd(Integer id, Authentication authentication);


}
