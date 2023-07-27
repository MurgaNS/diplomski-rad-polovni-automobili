package ftn.graduatethesispolovniautomobili.model.entity;

import ftn.graduatethesispolovniautomobili.model.enumeration.EAdStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private EAdStatus status;

    @Column
    private Double price;
    private String description;
    private String rejectedReason;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @OneToMany(mappedBy = "ad", fetch = FetchType.EAGER)
    private Set<Report> reports = new HashSet<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;


}
