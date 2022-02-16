package com.example.avic.dao;
import com.example.avic.model.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CongeRepository extends JpaRepository<Conge,Long> {
}
