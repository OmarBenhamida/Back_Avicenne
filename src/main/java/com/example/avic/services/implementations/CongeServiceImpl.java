package com.example.avic.services.implementations;

import com.example.avic.dao.CongeRepository;
import com.example.avic.dao.PersonnelRepository;
import com.example.avic.domaine.converter.CongeConverter;
import com.example.avic.domaine.converter.PersonnelConverter;
import com.example.avic.domaine.converter.RetardConverter;
import com.example.avic.domaine.vo.CongeVo;
import com.example.avic.model.Personnel;
import com.example.avic.model.Retard;
import com.example.avic.services.ICongeService;
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

import com.example.avic.model.Conge;

@Service("congeService")
public class CongeServiceImpl implements ICongeService {
    @Autowired
    private CongeRepository congeRepository;
    @Autowired
    private PersonnelRepository personnelRepository;

    @Override
    public CongeVo getById(Long id) {
        boolean trouve = congeRepository.existsById(id);
        if (!trouve)
            return null;
        return CongeConverter.toVo(congeRepository.getById(id));
    }

    @Override
    public List<CongeVo> getAll() {
        List<Conge> list = congeRepository.findAll();
        for(Conge  c : list){
            c.getPersonnel().setImg(ImageUtility.decompressImage( c.getPersonnel().getImg()));
        }
        return CongeConverter.toVoList(list);
    }

    @Override
    public void save(CongeVo conge) {
        conge.setPersonnel(PersonnelConverter.toVo(personnelRepository.getById(conge.getIdpersonnel())));
        System.out.println(conge);
        congeRepository.save(CongeConverter.toBo(conge));
    }



    @Override
    public void update(Long id, CongeVo conge) {
        conge.setId(id);
        congeRepository.save(CongeConverter.toBo(conge));
    }

    @Override
    public void delete(Long id) {
        congeRepository.deleteById(id);
    }
}
