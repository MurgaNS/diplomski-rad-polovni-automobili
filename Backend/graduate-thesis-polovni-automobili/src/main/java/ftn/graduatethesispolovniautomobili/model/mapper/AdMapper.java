package ftn.graduatethesispolovniautomobili.model.mapper;

import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.response.AdResponseDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;

public class AdMapper {

    public static AdResponseDTO toAdResponseDTO(Ad ad) {
        AdResponseDTO adResponseDTO = new AdResponseDTO();
        adResponseDTO.setPrice(ad.getPrice());
        adResponseDTO.setDescription(ad.getDescription());
        adResponseDTO.setCarResponseDTO(CarMapper.toDTO(ad.getCar()));
        adResponseDTO.setUser(UserMapper.mapUserDTO(ad.getUser()));

        return adResponseDTO;

    }

    public static Ad mapToAd(AdRequestDTO adRequestDTO){
        Ad ad = new Ad();
        ad.setDescription(adRequestDTO.getDescription());
        ad.setPrice(adRequestDTO.getPrice());
        ad.setCar(CarMapper.mapToCar(adRequestDTO.getCarRequestDTO()));

        return ad;
    }
}
