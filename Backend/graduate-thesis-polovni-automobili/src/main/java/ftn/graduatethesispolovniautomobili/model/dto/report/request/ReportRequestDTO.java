package ftn.graduatethesispolovniautomobili.model.dto.report.request;

import ftn.graduatethesispolovniautomobili.model.enumeration.EReportReason;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportRequestDTO {

    private EReportReason reportReason;

}
