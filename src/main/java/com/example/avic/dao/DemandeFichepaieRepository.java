package com.example.avic.dao;
import com.example.avic.model.DemandeFichepaie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DemandeFichepaieRepository extends JpaRepository<DemandeFichepaie,Long> {
}
