package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.exception.AdExistsException;
import ftn.graduatethesispolovniautomobili.exception.BadRequestException;
import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdChangeStatusDTO;
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

import java.util.*;

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
        engine.setEngineType(adRequestDTO.getCarRequestDTO().getEngineForCarDTO().getEngineType());
        engine.setEngineEmmisionClass(adRequestDTO.getCarRequestDTO().getEngineForCarDTO().getEngineEmmisionClass());
        engine.setMileage(adRequestDTO.getCarRequestDTO().getEngineForCarDTO().getMileage());
        engine.setPower(adRequestDTO.getCarRequestDTO().getEngineForCarDTO().getPower());

        car.setCarCategory(adRequestDTO.getCarRequestDTO().getCarCategory());
        car.setCarDrive(adRequestDTO.getCarRequestDTO().getCarDrive());
        car.setCarGearbox(adRequestDTO.getCarRequestDTO().getCarGearbox());
        car.setCarSafety(adRequestDTO.getCarRequestDTO().getCarSafety());
        car.setBrand(adRequestDTO.getCarRequestDTO().getBrand());
        car.setClimate(adRequestDTO.getCarRequestDTO().getClimate());
        car.setAdditionalEquipment(adRequestDTO.getCarRequestDTO().getAdditionalEquipment());
        car.setChassisNumber(adRequestDTO.getCarRequestDTO().getChassisNumber());
        car.setColor(adRequestDTO.getCarRequestDTO().getColor());
        car.setDamage(adRequestDTO.getCarRequestDTO().getDamage());
        car.setDoorNumber(adRequestDTO.getCarRequestDTO().getDoorNumber());
        car.setExchange(adRequestDTO.getCarRequestDTO().getExchange());
        car.setInteriorColor(adRequestDTO.getCarRequestDTO().getInteriorColor());
        car.setInteriorMaterial(adRequestDTO.getCarRequestDTO().getInteriorMaterial());
        car.setModel(adRequestDTO.getCarRequestDTO().getModel());
        car.setPhoto(adRequestDTO.getCarRequestDTO().getPhoto());
        car.setRegisteredUntil(adRequestDTO.getCarRequestDTO().getRegisteredUntil());
        car.setSeatsNumber(adRequestDTO.getCarRequestDTO().getSeatsNumber());
        car.setSteeringWheelSide(adRequestDTO.getCarRequestDTO().getSteeringWheelSide());
        car.setVehicleCondition(adRequestDTO.getCarRequestDTO().getVehicleCondition());
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

    @Override
    public List<Ad> getAll() {
        return adRepository.findAll();
    }

    @Override
    public List<Ad> getAllActive() {
        return adRepository.getAllActive();
    }

    @Override
    public List<Ad> getAllInactive() {
        return adRepository.getAllInactive();
    }

    @Override
    public Ad changeStatus(Integer id, AdChangeStatusDTO adChangeStatusDTO) {

        Ad ad = getById(id);
        ad.setStatus(adChangeStatusDTO.getStatus());
        ad.setRejectedReason(adChangeStatusDTO.getRejectedReason());

        if (adChangeStatusDTO.getStatus() == EAdStatus.REJECTED && (adChangeStatusDTO.getRejectedReason() == "" || adChangeStatusDTO.getRejectedReason() == null)) {
            return null;

        } else if (adChangeStatusDTO.getStatus() == EAdStatus.ACTIVE ||
                adChangeStatusDTO.getStatus() == EAdStatus.INACTIVE ||
                adChangeStatusDTO.getStatus() == EAdStatus.DELETED) {

            adChangeStatusDTO.setRejectedReason(null);
            return ad;
        }

        save(ad);
        return ad;
    }

    @Override
    public Ad getById(Integer id) {
        Optional<Ad> ad = adRepository.findById(id);
        if (ad.isEmpty()) {
            throw new AdExistsException("Ad doesnt exist.");
        }
        return ad.get();
    }

    @Override
    public Ad updateAd(Integer id, AdRequestDTO adRequestDTO, Authentication authentication) {

        Ad adForUpdate = getById(id);

        if (adForUpdate == null) {
            throw new BadRequestException("Please provide a valid AD");
        }

        if (!Objects.equals(adForUpdate.getUser().getId(), userService.findCurrentLoggedUser(authentication).getId())) {
            throw new BadRequestException("You are not an ad creator");
        }

        save(AdMapper.mapForUpdate(adForUpdate, adRequestDTO));
        return adForUpdate;

    }

    @Override
    public Ad followAd(Integer id, Authentication authentication) {

        Ad adForFollow = getById(id);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());

        Set<Ad> ads = user.getFollowedAds();
        ads.add(adForFollow);

        user.setFollowedAds(ads);

        userService.save(user);
        return adForFollow;
    }
}
