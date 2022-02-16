package com.example.avic.services.implementations;

import com.example.avic.dao.PersonnelRepository;
import com.example.avic.dao.RetardRepository;
import com.example.avic.domaine.converter.AbsenceConverter;
import com.example.avic.domaine.converter.PersonnelConverter;
import com.example.avic.domaine.converter.RetardConverter;
import com.example.avic.domaine.vo.RetardVo;
import com.example.avic.model.Absence;
import com.example.avic.model.Conge;
import com.example.avic.services.IRetardService;
import com.example.avic.utils.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.example.avic.model.Retard;

@Service("retardService")
public class RetardServiceImpl implements IRetardService {
    @Autowired
    private RetardRepository retardRepository;
    @Autowired
    private PersonnelRepository personnelRepository;
    @Override
    public RetardVo getById(Long id) {
        boolean trouve = retardRepository.existsById(id);
        if (!trouve)
            return null;
        return RetardConverter.toVo(retardRepository.getById(id));
    }

    @Override
    public List<RetardVo> getAll() {
        List<Retard> list = retardRepository.findAll();
        for(Retard c : list){
            c.getPersonnel().setImg(ImageUtility.decompressImage( c.getPersonnel().getImg()));
        }
        return RetardConverter.toVoList(list);
    }

    @Override
    public void save(RetardVo retard) {
        retard.setPersonnel(PersonnelConverter.toVo(personnelRepository.getById(retard.getIdpersonnel())));
        System.out.println("dazd"+retardRepository.save(RetardConverter.toBo(retard)));
    }




    @Override
    public void update(Long id, RetardVo retard) {
        retard.setId(id);
        retardRepository.save(RetardConverter.toBo(retard));
    }

    @Override
    public void delete(Long id) {
        retardRepository.deleteById(id);
    }
}
