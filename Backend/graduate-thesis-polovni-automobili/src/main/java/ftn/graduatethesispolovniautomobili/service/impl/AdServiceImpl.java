package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.exception.AdExistsException;
import ftn.graduatethesispolovniautomobili.exception.BadRequestException;
import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdChangeStatusDTO;
import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdRequestDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import ftn.graduatethesispolovniautomobili.model.entity.Car;
import ftn.graduatethesispolovniautomobili.model.entity.User;
import ftn.graduatethesispolovniautomobili.model.enumeration.EAdStatus;
import ftn.graduatethesispolovniautomobili.model.mapper.AdMapper;
import ftn.graduatethesispolovniautomobili.model.mapper.CarMapper;
import ftn.graduatethesispolovniautomobili.repository.AdRepository;
import ftn.graduatethesispolovniautomobili.service.AdService;
import ftn.graduatethesispolovniautomobili.service.EmailService;
import ftn.graduatethesispolovniautomobili.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class AdServiceImpl implements AdService {

    private final AdRepository adRepository;

    private final UserService userService;

    private final EmailService emailService;

    public AdServiceImpl(AdRepository adRepository, UserService userService, EmailService emailService) {
        this.adRepository = adRepository;
        this.userService = userService;
        this.emailService = emailService;
    }

    @Override
    public Ad addNewAd(AdRequestDTO adRequestDTO, Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());

        Ad newAd = AdMapper.mapToAd(adRequestDTO);
        newAd.setStatus(EAdStatus.INACTIVE);

        Car car = CarMapper.mapToCar(adRequestDTO.getCarRequestDTO());

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
    public List<Ad> search(AdRequestDTO adRequestDTO) {

       /* if (adRequestDTO == null) {
            throw new BadRequestException("Please provide a valid search parameters!");
        }*/

        return adRepository.search(adRequestDTO);
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

        if (!Objects.equals(adForUpdate.getPrice(), adRequestDTO.getPrice())) {
            for(String i : getUsersEmailByFollowedAd(adForUpdate.getId())) {
                emailService.sendEmail(i,"Price changed", "The price of the ad you are following has changed");
            }
        }

        save(AdMapper.mapForUpdate(adForUpdate, adRequestDTO));
        return adForUpdate;

    }

    @Override
    public Ad followAd(Integer id, Authentication authentication) {

        Ad adForFollow = getById(id);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());

        Set<Ad> ads = user.getFollowedAds();
        ads.add(adForFollow);

        user.setFollowedAds(ads);

        userService.save(user);
        return adForFollow;
    }

    @Override
    public List<Ad> getUserAds(Authentication authentication) {

        return adRepository.getUserAds(userService.findCurrentLoggedUser(authentication).getId());
    }

    @Override
    public List<Ad> getFollowedAds(Authentication authentication) {

        return  adRepository.getFollowedAds(userService.findCurrentLoggedUser(authentication).getId());
    }

    @Override
    public List<String> getUsersEmailByFollowedAd(Integer id) {
        return adRepository.getUsersEmailByFollowedAd(id);
    }
}
