package ftn.graduatethesispolovniautomobili.controller;

import ftn.graduatethesispolovniautomobili.model.dto.report.request.ReportRequestDTO;
import ftn.graduatethesispolovniautomobili.model.dto.report.response.ReportResponseDTO;
import ftn.graduatethesispolovniautomobili.model.entity.Report;
import ftn.graduatethesispolovniautomobili.model.mapper.ReportMapper;
import ftn.graduatethesispolovniautomobili.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/all")
    public ResponseEntity<ReportResponseDTO> getAll(){

        List<Report> reports = reportService.getAll();

        List<ReportResponseDTO> reportResponseDTO = ReportMapper.toDTOs(reports);

        return new ResponseEntity(reportResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ReportResponseDTO> createReport(@PathVariable Integer id, @RequestBody ReportRequestDTO reportRequestDTO){

        Report createdReport = reportService.addNewReport(id, reportRequestDTO);

        ReportResponseDTO reportResponseDTO = ReportMapper.toReportResponseDTO(createdReport);

        return new ResponseEntity(reportResponseDTO, HttpStatus.OK);
    }
}
