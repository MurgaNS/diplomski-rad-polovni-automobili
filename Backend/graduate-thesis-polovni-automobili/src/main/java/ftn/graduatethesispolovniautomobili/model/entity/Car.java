package ftn.graduatethesispolovniautomobili.model.entity;

import ftn.graduatethesispolovniautomobili.model.enumeration.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private ECarCategory carCategory;

    @Column
    @Enumerated(EnumType.STRING)
    private ECarDrive carDrive;

    @Column
    @Enumerated(EnumType.STRING)
    private ECarGearbox carGearbox;

    @Column
    @Enumerated(EnumType.STRING)
    private ESteeringWheelSide steeringWheelSide;

    @Column
    @Enumerated(EnumType.STRING)
    private EClimate climate;

    @Column
    @Enumerated(EnumType.STRING)
    private EInteriorMaterial interiorMaterial;

    @Column
    @Enumerated(EnumType.STRING)
    private ECarDamage damage;

    @Column
    @Enumerated(EnumType.STRING)
    private EExchange exchange;

    @ElementCollection(targetClass = ECarSafety.class)
    @JoinTable(name = "car_safety", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "safety", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<ECarSafety> carSafety;

    @ElementCollection(targetClass = EVehicleCondition.class)
    @JoinTable(name = "car_vehicle_condition", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "vehicle_condition", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<EVehicleCondition> vehicleCondition;


    @ElementCollection(targetClass = EAdditionalEquipment.class)
    @JoinTable(name = "car_additional_equipment", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "additional_equipment", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<EAdditionalEquipment> additionalEquipment;

    @Column
    @Enumerated(EnumType.STRING)
    private EFuelType fuelType;

    @Column
    @Enumerated(EnumType.STRING)
    private EEngineEmmisionClass engineEmmisionClass;

    @Column
    private String brand;
    private String model;
    private Integer doorNumber;
    private Integer seatsNumber;
    private String color;
    private String interiorColor;
    private Date registeredUntil;
    private String chassisNumber;
    private String engineType;
    private Integer engineCubicle;
    private Integer power;
    private Integer mileage;


    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "photos", joinColumns = @JoinColumn(name = "ad_id"))
    @Column(name = "filename", nullable = false)
    private List<String> photos = new ArrayList<>();


    @OneToOne(mappedBy = "car")
    private Ad ad;

}
