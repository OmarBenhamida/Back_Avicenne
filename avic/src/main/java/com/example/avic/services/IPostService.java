package com.example.avic.services;

import com.example.avic.domaine.vo.PostVo;

import java.util.List;

public interface IPostService {
    PostVo getById(Long id);

    List<PostVo> getAll();

    void save(PostVo post);

    void update(Long id, PostVo post);

    void delete(Long id);

    List<PostVo> findByLibelle(String libelle);
}
