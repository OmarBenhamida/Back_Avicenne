package com.example.avic.services.implementations;

import com.example.avic.dao.DemandeAttestationRepository;
import com.example.avic.domaine.converter.DemandeAttestationConverter;
import com.example.avic.domaine.vo.DemandeAttestationVo;
import com.example.avic.services.IDemandeAttestationService;
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

import com.example.avic.model.DemandeAttestation;

@Service("demandeAttestationService")
public class DemandeAttestationServiceImpl implements IDemandeAttestationService {
    @Autowired
    private DemandeAttestationRepository demandeAttestationRepository;

    @Override
    public DemandeAttestationVo getById(Long id) {
        boolean trouve = demandeAttestationRepository.existsById(id);
        if (!trouve)
            return null;
        return DemandeAttestationConverter.toVo(demandeAttestationRepository.getById(id));
    }

    @Override
    public List<DemandeAttestationVo> getAll() {
        List<DemandeAttestation> list = demandeAttestationRepository.findAll();
        return DemandeAttestationConverter.toVoList(list);
    }

    @Override
    public void save(DemandeAttestationVo demandeAttestation) {
        demandeAttestationRepository.save(DemandeAttestationConverter.toBo(demandeAttestation));
    }

    @Override
    public void update(Long id, DemandeAttestationVo demandeAttestation) {
        demandeAttestation.setId(id);
        demandeAttestationRepository.save(DemandeAttestationConverter.toBo(demandeAttestation));
    }

    @Override
    public void delete(Long id) {
        demandeAttestationRepository.deleteById(id);
    }
}
