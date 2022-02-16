package com.example.avic.dao;
import com.example.avic.model.Retard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RetardRepository extends JpaRepository<Retard,Long> {
}
