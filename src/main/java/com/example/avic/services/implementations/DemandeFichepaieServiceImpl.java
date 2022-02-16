package com.example.avic.services.implementations;

import com.example.avic.dao.DemandeFichepaieRepository;
import com.example.avic.domaine.converter.DemandeFichepaieConverter;
import com.example.avic.domaine.vo.DemandeFichepaieVo;
import com.example.avic.services.IDemandeFichepaieService;
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

import com.example.avic.model.DemandeFichepaie;

@Service("demandeFichepaieService")
public class DemandeFichepaieServiceImpl implements IDemandeFichepaieService {
    @Autowired
    private DemandeFichepaieRepository demandeFichepaieRepository;

    @Override
    public DemandeFichepaieVo getById(Long id) {
        boolean trouve = demandeFichepaieRepository.existsById(id);
        if (!trouve)
            return null;
        return DemandeFichepaieConverter.toVo(demandeFichepaieRepository.getById(id));
    }

    @Override
    public List<DemandeFichepaieVo> getAll() {
        List<DemandeFichepaie> list = demandeFichepaieRepository.findAll();
        return DemandeFichepaieConverter.toVoList(list);
    }

    @Override
    public void save(DemandeFichepaieVo demandeFichepaie) {
        demandeFichepaieRepository.save(DemandeFichepaieConverter.toBo(demandeFichepaie));
    }

    @Override
    public void update(Long id, DemandeFichepaieVo demandeFichepaie) {
        demandeFichepaie.setId(id);
        demandeFichepaieRepository.save(DemandeFichepaieConverter.toBo(demandeFichepaie));
    }

    @Override
    public void delete(Long id) {
        demandeFichepaieRepository.deleteById(id);
    }
}
