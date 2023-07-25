package ftn.graduatethesispolovniautomobili.repository;

import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {
}
