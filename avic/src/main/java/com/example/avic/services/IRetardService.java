package com.example.avic.services;

import com.example.avic.domaine.vo.RetardVo;

import java.util.List;

public interface IRetardService {
    RetardVo getById(Long id);

    List<RetardVo> getAll();
    void save(RetardVo retard);
    void update(Long id, RetardVo retard);
    void delete(Long id);
}
