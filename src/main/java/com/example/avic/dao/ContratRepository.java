package com.example.avic.dao;
import com.example.avic.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
