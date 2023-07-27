package ftn.graduatethesispolovniautomobili.repository;

import ftn.graduatethesispolovniautomobili.model.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {

    List<Ad> findAll();

    Optional<Ad> findById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM ad where ad.status = 'ACTIVE'")
    List<Ad> getAllActive();

    @Query(nativeQuery = true, value = "SELECT * FROM ad where ad.status = 'INACTIVE'")
    List<Ad> getAllInactive();
}
