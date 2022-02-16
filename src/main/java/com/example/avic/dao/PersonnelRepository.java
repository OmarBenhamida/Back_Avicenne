package com.example.avic.dao;
import com.example.avic.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel,Long> {

    List<Personnel> findAll();
    List<Personnel> findByEmail(String email);
    List<Personnel> findByEmailEqualsAndAndPassewordEquals(String email, String password);
    List<Personnel> findByCin(String Cin);


}
