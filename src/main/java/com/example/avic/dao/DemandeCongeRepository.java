package com.example.avic.dao;
import com.example.avic.model.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DemandeCongeRepository extends JpaRepository<DemandeConge,Long> {
}
