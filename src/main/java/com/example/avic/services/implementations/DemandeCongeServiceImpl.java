package com.example.avic.services.implementations;

import com.example.avic.dao.DemandeCongeRepository;
import com.example.avic.domaine.converter.DemandeCongeConverter;
import com.example.avic.domaine.vo.DemandeCongeVo;
import com.example.avic.services.IDemandeCongeService;
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

import com.example.avic.model.DemandeConge;

@Service("demandeCongeService")
public class DemandeCongeServiceImpl implements IDemandeCongeService {
    @Autowired
    private DemandeCongeRepository demandeCongeRepository;

    @Override
    public DemandeCongeVo getById(Long id) {
        boolean trouve = demandeCongeRepository.existsById(id);
        if (!trouve)
            return null;
        return DemandeCongeConverter.toVo(demandeCongeRepository.getById(id));
    }

    @Override
    public List<DemandeCongeVo> getAll() {
        List<DemandeConge> list = demandeCongeRepository.findAll();
        return DemandeCongeConverter.toVoList(list);
    }

    @Override
    public void save(DemandeCongeVo demandeConge) {
        demandeCongeRepository.save(DemandeCongeConverter.toBo(demandeConge));
    }

    @Override
    public void update(Long id, DemandeCongeVo demandeConge) {
        demandeConge.setId(id);
        demandeCongeRepository.save(DemandeCongeConverter.toBo(demandeConge));
    }

    @Override
    public void delete(Long id) {
        demandeCongeRepository.deleteById(id);
    }
}
