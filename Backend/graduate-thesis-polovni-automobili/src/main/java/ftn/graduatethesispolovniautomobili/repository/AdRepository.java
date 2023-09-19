package ftn.graduatethesispolovniautomobili.repository;

import ftn.graduatethesispolovniautomobili.model.dto.ad.request.AdSearchRequestDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {

    List<Ad> findAll();

    Optional<Ad> findById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM ad where ad.status = 'ACTIVE'")
    List<Ad> getAllActive();

    @Query(nativeQuery = true, value = "SELECT * FROM ad where ad.status = 'INACTIVE'")
    List<Ad> getAllInactive();

    @Query(nativeQuery = true, value = "SELECT * FROM ad where ad.user_id = ? ")
    List<Ad> getUserAds(Integer user_id);

    @Query(value = "SELECT ad FROM Ad ad " +
            "WHERE ad.status = 'ACTIVE' " +
            "AND (:#{#searchParameters.priceFrom} IS NULL OR ad.price >= :#{#searchParameters.priceFrom}) " +
            "AND (:#{#searchParameters.priceTo} IS NULL OR ad.price <= :#{#searchParameters.priceTo}) " +
            "AND (:#{#searchParameters.carRequestDTO.carCategory} IS NULL OR  ad.car.carCategory = :#{#searchParameters.carRequestDTO.carCategory}) " +
            "AND (:#{#searchParameters.carRequestDTO.carDrive} IS NULL OR ad.car.carDrive = :#{#searchParameters.carRequestDTO.carDrive}) " +
            "AND (:#{#searchParameters.carRequestDTO.carGearbox} IS NULL OR ad.car.carGearbox = :#{#searchParameters.carRequestDTO.carGearbox}) "+
            "AND (:#{#searchParameters.carRequestDTO.steeringWheelSide} IS NULL OR ad.car.steeringWheelSide = :#{#searchParameters.carRequestDTO.steeringWheelSide}) " +
            "AND (:#{#searchParameters.carRequestDTO.climate} IS NULL OR ad.car.climate = :#{#searchParameters.carRequestDTO.climate}) " +
            "AND (:#{#searchParameters.carRequestDTO.interiorMaterial} IS NULL OR ad.car.interiorMaterial = :#{#searchParameters.carRequestDTO.interiorMaterial}) " +
            "AND (:#{#searchParameters.carRequestDTO.damage} IS NULL OR ad.car.damage = :#{#searchParameters.carRequestDTO.damage}) " +
            "AND (:#{#searchParameters.carRequestDTO.exchange} IS NULL OR ad.car.exchange = :#{#searchParameters.carRequestDTO.exchange}) " +
            "AND (:#{#searchParameters.carRequestDTO.brand} IS NULL OR ad.car.brand = :#{#searchParameters.carRequestDTO.brand}) " +
            "AND (:#{#searchParameters.carRequestDTO.model} IS NULL OR ad.car.model = :#{#searchParameters.carRequestDTO.model}) " +
            "AND (:#{#searchParameters.carRequestDTO.doorNumber} IS NULL OR ad.car.doorNumber = :#{#searchParameters.carRequestDTO.doorNumber}) " +
            "AND (:#{#searchParameters.carRequestDTO.color} IS NULL OR ad.car.color = :#{#searchParameters.carRequestDTO.color}) " +
            "AND (:#{#searchParameters.carRequestDTO.interiorColor} IS NULL OR ad.car.interiorColor = :#{#searchParameters.carRequestDTO.interiorColor}) " +
            "AND (:#{#searchParameters.carRequestDTO.registeredUntil} IS NULL OR ad.car.registeredUntil = :#{#searchParameters.carRequestDTO.registeredUntil}) " +
            "AND (:#{#searchParameters.carRequestDTO.seatsNumber} IS NULL OR ad.car.seatsNumber = :#{#searchParameters.carRequestDTO.seatsNumber}) " +
            "AND (:#{#searchParameters.carRequestDTO.fuelType} IS NULL OR ad.car.fuelType = :#{#searchParameters.carRequestDTO.fuelType}) " +
            "AND (:#{#searchParameters.carRequestDTO.engineEmmisionClass} IS NULL OR ad.car.engineEmmisionClass = :#{#searchParameters.carRequestDTO.engineEmmisionClass}) " +
            "AND (:#{#searchParameters.carRequestDTO.engineCubicleFrom} IS NULL OR ad.car.engineCubicle >= :#{#searchParameters.carRequestDTO.engineCubicleFrom}) " +
            "AND (:#{#searchParameters.carRequestDTO.engineCubicleTo} IS NULL OR ad.car.engineCubicle <= :#{#searchParameters.carRequestDTO.engineCubicleTo}) " +
            "AND (:#{#searchParameters.carRequestDTO.powerFrom} IS NULL OR ad.car.power >= :#{#searchParameters.carRequestDTO.powerFrom}) " +
            "AND (:#{#searchParameters.carRequestDTO.powerTo} IS NULL OR ad.car.power <= :#{#searchParameters.carRequestDTO.powerTo}) " +
            "AND (:#{#searchParameters.carRequestDTO.mileageFrom} IS NULL OR ad.car.mileage >= :#{#searchParameters.carRequestDTO.mileageFrom}) "+
            "AND (:#{#searchParameters.carRequestDTO.mileageTo} IS NULL OR ad.car.mileage <= :#{#searchParameters.carRequestDTO.mileageTo}) ")
    List<Ad> search(@Param("searchParameters") AdSearchRequestDTO searchParameters);

    @Query(value = "SELECT * " +
            "FROM users_followed_ads LEFT JOIN ad ON ad.id = users_followed_ads.followed_ads_id " +
            "LEFT JOIN car ON ad.car_id = car.id " +
            "WHERE users_followed_ads.users_id = ?;", nativeQuery = true)
    List<Ad> getFollowedAds(Integer user_id);

    @Query(value = "SELECT email FROM users_followed_ads LEFT JOIN users " +
            "ON users_followed_ads.users_id = users.id " +
            "WHERE users_followed_ads.followed_ads_id = ? ", nativeQuery = true)
    List<String> getUsersEmailByFollowedAd(Integer followed_ads_id);


}
