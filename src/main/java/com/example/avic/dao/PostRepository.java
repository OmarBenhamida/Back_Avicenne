package com.example.avic.dao;
import com.example.avic.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAll();
    List<Post> findByLibelle(String libelle);


}
