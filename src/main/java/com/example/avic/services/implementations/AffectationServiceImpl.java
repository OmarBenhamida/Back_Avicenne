package com.example.avic.services.implementations;

import com.example.avic.dao.AffectationRepository;
import com.example.avic.dao.PersonnelRepository;
import com.example.avic.dao.PostRepository;
import com.example.avic.domaine.converter.*;
import com.example.avic.domaine.vo.AbsenceVo;
import com.example.avic.domaine.vo.AffectationVo;
import com.example.avic.model.Absence;
import com.example.avic.services.IAffectationService;
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

import com.example.avic.model.Affectation;

@Service("affectationService")
public class AffectationServiceImpl implements IAffectationService {
    @Autowired
    private AffectationRepository affectationRepository;

    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public AffectationVo getById(Long id) {
        boolean trouve = affectationRepository.existsById(id);
        if (!trouve)
            return null;
        return AffectationConverter.toVo(affectationRepository.getById(id));
    }

    @Override
    public List<AffectationVo> getAll() {
        List<Affectation> list = affectationRepository.findAll();
        return AffectationConverter.toVoList(list);
    }

    @Override
    public void save(AffectationVo affectation) {


        affectation.setPersonnel(PersonnelConverter.toVo(personnelRepository.getById(affectation.getIdpersonnel())));

        affectation.setPost(PostConverter.toVo(postRepository.getById(affectation.getIdpost())));

        System.out.println(affectation);



        affectationRepository.save(AffectationConverter.toBo(affectation));
    }



    @Override
    public void update(Long id, AffectationVo affectation) {
        affectation.setId(id);
        affectationRepository.save(AffectationConverter.toBo(affectation));
    }

    @Override
    public void delete(Long id) {
        affectationRepository.deleteById(id);
    }
}
