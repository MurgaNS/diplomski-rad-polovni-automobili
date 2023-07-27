package ftn.graduatethesispolovniautomobili.service;

import ftn.graduatethesispolovniautomobili.model.dto.report.request.ReportRequestDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Report;

import java.util.List;

public interface ReportService {

    List<Report> getAll();

   Report addNewReport(Integer id, ReportRequestDTO reportRequestDTO);

   Report save(Report report);
}
