package ftn.graduatethesispolovniautomobili.model.mapper;

import ftn.graduatethesispolovniautomobili.model.dto.report.request.ReportRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.report.response.ReportResponseDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Report;

import java.util.List;

public class ReportMapper {

    public static ReportResponseDTO toReportResponseDTO (Report report){

        ReportResponseDTO reportResponseDTO = new ReportResponseDTO();

        reportResponseDTO.setAdResponseDTO(AdMapper.toReportDTO(report.getAd()));
        reportResponseDTO.setReportReason(report.getReportReason());

        return reportResponseDTO;

    }

    public static List<ReportResponseDTO> toDTOs(List<Report> reports) {

        return reports.stream().map(ReportMapper::toReportResponseDTO).toList();

    }

    public static Report mapToReport(ReportRequestDTO reportRequestDTO){

        Report report = new Report();

        report.setReportReason(reportRequestDTO.getReportReason());

        return report;
    }
}
