package ftn.graduatethesispolovniautomobili.model.dto.report.response;


import ftn.graduatethesispolovniautomobili.model.dto.ad.response.AdResponseForReportDTO;
import ftn.graduatethesispolovniautomobili.model.enumeration.EReportReason;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportResponseDTO {

    private EReportReason reportReason;

    private AdResponseForReportDTO adResponseForReportDTO;
}
