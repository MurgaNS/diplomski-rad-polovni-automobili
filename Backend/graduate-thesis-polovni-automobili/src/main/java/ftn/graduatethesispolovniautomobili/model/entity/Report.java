package ftn.graduatethesispolovniautomobili.model.entity;

import ftn.graduatethesispolovniautomobili.model.enumeration.EReportReason;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private EReportReason reportReason;

    @Column
    private boolean isAccepted;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ad_id", nullable = false)
    private Ad ad;


}
