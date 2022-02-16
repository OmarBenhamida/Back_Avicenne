package com.example.avic.dao;
import com.example.avic.model.DemandeAttestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DemandeAttestationRepository extends JpaRepository<DemandeAttestation,Long> {
}
