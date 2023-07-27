package ftn.graduatethesispolovniautomobili.model.entity;


import ftn.graduatethesispolovniautomobili.model.enumeration.EUserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String country;
    private String city;
    private String district;
    private Integer zip;
    private String address;
    private String phoneNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private EUserRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Ad> ads = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Ad> followedAds = new HashSet<>();


}
