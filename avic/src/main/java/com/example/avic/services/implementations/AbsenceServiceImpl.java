package com.example.avic.services.implementations;

import com.example.avic.dao.AbsenceRepository;
import com.example.avic.dao.PersonnelRepository;
import com.example.avic.domaine.converter.AbsenceConverter;
import com.example.avic.domaine.converter.PersonnelConverter;
import com.example.avic.domaine.converter.RetardConverter;
import com.example.avic.domaine.vo.AbsenceVo;
import com.example.avic.services.IAbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.example.avic.model.Absence;

@Service("absenceService")

public class AbsenceServiceImpl implements IAbsenceService {
    @Autowired
    private AbsenceRepository absenceRepository;
    @Autowired
    private PersonnelRepository personnelRepository;

    @Override
    public AbsenceVo getById(Long id) {
        boolean trouve = absenceRepository.existsById(id);
        if (!trouve)
            return null;
        return AbsenceConverter.toVo(absenceRepository.getById(id));
    }

    @Override
    public List<AbsenceVo> getAll() {
        List<Absence> list = absenceRepository.findAll();
        return AbsenceConverter.toVoList(list);
    }

    @Override
    public void save(AbsenceVo absence) {
        absence.setPersonnel(PersonnelConverter.toVo(personnelRepository.getById(absence.getIdpersonnel())));
        System.out.println("dazd" + absenceRepository.save(AbsenceConverter.toBo(absence)));
    }


    @Override
    public void update(Long id, AbsenceVo absence) {
        absence.setId(id);
        absenceRepository.save(AbsenceConverter.toBo(absence));
    }

    @Override
    public void delete(Long id) {
        absenceRepository.deleteById(id);
    }
}
