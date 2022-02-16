package com.example.avic.services;

import com.example.avic.domaine.vo.AffectationVo;

import java.util.List;

public interface IAffectationService {
    AffectationVo getById(Long id);

    List<AffectationVo> getAll();

    void save(AffectationVo affectation);

    void update(Long id, AffectationVo affectation);

    void delete(Long id);
}
