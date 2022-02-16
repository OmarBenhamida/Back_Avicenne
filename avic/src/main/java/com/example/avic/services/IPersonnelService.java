package com.example.avic.services;

import com.example.avic.domaine.vo.PersonnelVo;

import java.util.List;

public interface IPersonnelService {
    PersonnelVo getById(Long id);

    List<PersonnelVo> getAll();

    void save(PersonnelVo personnel);

    void update(Long id, PersonnelVo personnel);

    void delete(Long id);

    List<PersonnelVo> findByCin(String Cin);

    List<PersonnelVo> findByEmail(String email);

    List<PersonnelVo> findByEmailEqualsAndAndPassewordEquals(String email, String password);
}
