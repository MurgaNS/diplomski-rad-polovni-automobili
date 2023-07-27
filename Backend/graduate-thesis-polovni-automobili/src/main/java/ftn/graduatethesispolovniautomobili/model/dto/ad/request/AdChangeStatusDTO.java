package ftn.graduatethesispolovniautomobili.model.dto.ad.request;

import ftn.graduatethesispolovniautomobili.model.enumeration.EAdStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdChangeStatusDTO {

    private EAdStatus status;
    private String rejectedReason;
}
