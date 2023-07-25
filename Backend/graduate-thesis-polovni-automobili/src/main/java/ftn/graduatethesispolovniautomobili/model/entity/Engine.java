package ftn.graduatethesispolovniautomobili.model.entity;

import ftn.graduatethesispolovniautomobili.model.enumeration.EEngineEmmisionClass;
import ftn.graduatethesispolovniautomobili.model.enumeration.EFuelType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private EFuelType fuelType;

    @Column
    @Enumerated(EnumType.STRING)
    private EEngineEmmisionClass engineEmmisionClass;

    @Column
    private String engineType;
    private Integer engineCubicle;
    private Integer power;
    private Integer mileage;

    //    @ManyToOne
//    @JoinColumn(name = "car_id", nullable = false)
//    private Car car;

    @OneToOne(mappedBy = "engine")
    private Car car;

}
