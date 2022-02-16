package com.example.avic.dao;

import com.example.avic.model.Absence;
import com.example.avic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

    User findByEmail(String email);
    User findByEmailEqualsAndAndPassewordEquals(String email, String password);
}
