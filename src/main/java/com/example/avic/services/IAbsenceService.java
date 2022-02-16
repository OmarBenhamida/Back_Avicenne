package com.example.avic.services;

import com.example.avic.domaine.vo.AbsenceVo;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IAbsenceService {
    AbsenceVo getById(Long id);

    List<AbsenceVo> getAll();

    void save(AbsenceVo absence);

    void update(Long id, AbsenceVo absence);

    void delete(Long id);
}
