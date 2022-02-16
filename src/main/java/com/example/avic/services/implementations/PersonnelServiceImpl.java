package com.example.avic.services.implementations;

import com.example.avic.dao.PersonnelRepository;
import com.example.avic.domaine.converter.PersonnelConverter;
import com.example.avic.domaine.vo.PersonnelVo;
import com.example.avic.services.IPersonnelService;
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

import com.example.avic.model.Personnel;

@Service("personnelService")
public class PersonnelServiceImpl implements IPersonnelService {
    @Autowired
    private PersonnelRepository personnelRepository;

    @Override
    public PersonnelVo getById(Long id) {
        boolean trouve = personnelRepository.existsById(id);
        if (!trouve)
            return null;
        return PersonnelConverter.toVo(personnelRepository.getById(id));
    }

    @Override
    public List<PersonnelVo> getAll() {
        List<Personnel> list = personnelRepository.findAll();
        for(Personnel p : list){
            p.setImg(ImageUtility.decompressImage(p.getImg()));
        }
        return PersonnelConverter.toVoList(list);
    }

    @Override
    public void save(PersonnelVo personnel) {

        personnelRepository.save(PersonnelConverter.toBo(personnel));
    }

    @Override
    public void update(Long id, PersonnelVo personnel) {
        personnel.setId(id);
        personnelRepository.save(PersonnelConverter.toBo(personnel));
    }

    @Override
    public void delete(Long id) {
        personnelRepository.deleteById(id);
    }

    @Override
    public List<PersonnelVo> findByCin(String Cin) {
        List<Personnel> list = personnelRepository.findByCin(Cin);
        return PersonnelConverter.toVoList(list);
    }

    @Override
    public List<PersonnelVo> findByEmail(String email) {
        List<Personnel> list = personnelRepository.findByEmail(email);
        return PersonnelConverter.toVoList(list);
    }

    @Override
    public List<PersonnelVo> findByEmailEqualsAndAndPassewordEquals(String email, String password) {
        List<Personnel> list = personnelRepository.findByEmailEqualsAndAndPassewordEquals(email,password);
        return PersonnelConverter.toVoList(list);
    }
}
