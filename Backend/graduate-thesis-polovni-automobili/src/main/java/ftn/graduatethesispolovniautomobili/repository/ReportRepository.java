package ftn.graduatethesispolovniautomobili.repository;

import ftn.graduatethesispolovniautomobili.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Query(value = "SELECT * FROM ad LEFT JOIN report ON report.ad_id = ad.id WHERE ad.status = 'ACTIVE' and report.is_accepted = false  ", nativeQuery = true)
    List<Report> findAllReportedActiveAds();
}
