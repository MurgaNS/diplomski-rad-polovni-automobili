package ftn.graduatethesispolovniautomobili.service.impl;

import ftn.graduatethesispolovniautomobili.model.dto.report.request.ReportRequestDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Report;
import ftn.graduatethesispolovniautomobili.model.mapper.ReportMapper;
import ftn.graduatethesispolovniautomobili.repository.ReportRepository;
import ftn.graduatethesispolovniautomobili.service.AdService;
import ftn.graduatethesispolovniautomobili.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final AdService adService;

    public ReportServiceImpl(ReportRepository reportRepository, AdService adService) {
        this.reportRepository = reportRepository;
        this.adService = adService;
    }

    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report addNewReport(Integer id, ReportRequestDTO reportRequestDTO) {

        Report newReport = ReportMapper.mapToReport(reportRequestDTO);

        newReport.setReportReason(reportRequestDTO.getReportReason());
        newReport.setAd(adService.getById(id));
        newReport.setAccepted(false);

        save(newReport);

        return newReport;

    }
}
