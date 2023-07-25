package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdRequestDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import ftn.graduatethesispolovniautomobili.model.entity.Car;
import ftn.graduatethesispolovniautomobili.model.entity.Engine;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import ftn.graduatethesispolovniautomobili.model.enumeration.EAdStatus;
import ftn.graduatethesispolovniautomobili.model.mapper.AdMapper;
import ftn.graduatethesispolovniautomobili.repository.AdRepository;
import ftn.graduatethesispolovniautomobili.service.AdService;
import ftn.graduatethesispolovniautomobili.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;

    private final UserService userService;

    public AdServiceImpl(AdRepository adRepository, UserService userService) {
        this.adRepository = adRepository;
        this.userService = userService;
    }

    @Override
    public Ad addNewAd(AdRequestDTO adRequestDTO, Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());

        Ad newAd = AdMapper.mapToAd(adRequestDTO);
        newAd.setStatus(EAdStatus.INACTIVE);

        Car car = new Car();
        Engine engine = new Engine();
        engine.setEngineCubicle(adRequestDTO.getCarRequestDTO().getEngineForCarDTO().getEngineCubicle());
        engine.setFuelType(adRequestDTO.getCarRequestDTO().getEngineForCarDTO().getFuelType());

        car.setCarCategory(adRequestDTO.getCarRequestDTO().getCarCategory());
        car.setEngine(engine);

        newAd.setCar(car);
        newAd.setUser(user);
        save(newAd);

        return newAd;

    }

    @Override
    public Ad save(Ad ad) {
        return adRepository.save(ad);
    }
}
