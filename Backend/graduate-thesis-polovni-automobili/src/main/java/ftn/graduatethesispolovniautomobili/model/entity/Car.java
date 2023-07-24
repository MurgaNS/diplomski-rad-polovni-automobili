package ftn.graduatethesispolovniautomobili.model.entity;

import ftn.graduatethesispolovniautomobili.model.enumeration.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @Column
    @Enumerated(EnumType.STRING)
    private ECarSafety carSafety;

    @Column
    @Enumerated(EnumType.STRING)
    private EVehicleCondition vehicleCondition;

    @Column
    @Enumerated(EnumType.STRING)
    private EAdditionalEquipment additionalEquipment;

    @Column
    private String photo;
    private String brand;
    private String model;
    private Integer doorNumber;
    private Integer seatsNumber;
    private String color;
    private String interiorColor;
    private Date registeredUntil;
    private String chassisNumber;

    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY)
    private Set<Engine> engines = new HashSet<>();

    @OneToOne(mappedBy = "car")
    private Ad ad;

}
