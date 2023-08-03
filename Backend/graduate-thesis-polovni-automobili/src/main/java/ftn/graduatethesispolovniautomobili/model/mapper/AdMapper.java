package ftn.graduatethesispolovniautomobili.model.mapper;

import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.response.AdResponseDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.response.AdResponseForReportDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;

import java.util.List;

public class AdMapper {

    public static AdResponseDTO toAdResponseDTO(Ad ad) {

        AdResponseDTO adResponseDTO = new AdResponseDTO();
        adResponseDTO.setId(ad.getId());
        adResponseDTO.setPrice(ad.getPrice());
        adResponseDTO.setDescription(ad.getDescription());
        adResponseDTO.setCarResponseDTO(CarMapper.toDTO(ad.getCar()));
        adResponseDTO.setUser(UserMapper.mapUserDTO(ad.getUser()));

        return adResponseDTO;

    }

    public static Ad mapForUpdate(Ad ad, AdRequestDTO adRequestDTO) {

        ad.setPrice(adRequestDTO.getPrice());
        ad.setDescription(adRequestDTO.getDescription());
        ad.setCar(CarMapper.mapForUpdate(ad.getCar(), adRequestDTO.getCarRequestDTO()));

        return ad;

    }

    public static Ad mapToAd(AdRequestDTO adRequestDTO) {

        Ad ad = new Ad();
        ad.setDescription(adRequestDTO.getDescription());
        ad.setPrice(adRequestDTO.getPrice());
        ad.setCar(CarMapper.mapToCar(adRequestDTO.getCarRequestDTO()));

        return ad;
    }

    public static List<AdResponseDTO> toDTOs(List<Ad> ads) {

        return ads.stream().map(AdMapper::toAdResponseDTO).toList();

    }

    public static AdResponseForReportDTO toReportDTO(Ad ad){

        AdResponseForReportDTO adResponseForReportDTO = new AdResponseForReportDTO();

        adResponseForReportDTO.setId(ad.getId());
        adResponseForReportDTO.setDescription(ad.getDescription());
        adResponseForReportDTO.setPrice(ad.getPrice());

        return adResponseForReportDTO;
    }
}
