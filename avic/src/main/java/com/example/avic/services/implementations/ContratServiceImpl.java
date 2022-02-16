package com.example.avic.services.implementations;

import com.example.avic.dao.CongeRepository;
import com.example.avic.dao.ContratRepository;
import com.example.avic.dao.PersonnelRepository;
import com.example.avic.domaine.converter.CongeConverter;
import com.example.avic.domaine.converter.ContratConverter;
import com.example.avic.domaine.converter.PersonnelConverter;
import com.example.avic.domaine.converter.RetardConverter;
import com.example.avic.domaine.vo.ContratVo;
import com.example.avic.domaine.vo.RetardVo;
import com.example.avic.model.Conge;
import com.example.avic.services.IContratService;
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

import com.example.avic.model.Contrat;

@Service("contratService")
public class ContratServiceImpl implements IContratService {
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private PersonnelRepository personnelRepository;

    @Override
    public ContratVo getById(Long id) {
        boolean trouve = contratRepository.existsById(id);
        if (!trouve)
            return null;
        return ContratConverter.toVo(contratRepository.getById(id));
    }

    @Override
    public List<ContratVo> getAll() {
        List<Contrat> list = contratRepository.findAll();
        return ContratConverter.toVoList(list);
    }

    @Override
    public void save(ContratVo contrat) {
        contrat.setPersonnel(PersonnelConverter.toVo(personnelRepository.getById(contrat.getIdpersonnel())));
        System.out.println("dazd"+contratRepository.save(ContratConverter.toBo(contrat)));
    }

    @Override
    public void update(Long id, ContratVo contrat) {
        contrat.setId(id);
        contratRepository.save(ContratConverter.toBo(contrat));
    }

    @Override
    public void delete(Long id) {
        contratRepository.deleteById(id);
    }
}
