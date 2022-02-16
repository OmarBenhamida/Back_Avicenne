package com.example.avic.domaine.converter;

import com.example.avic.domaine.vo.CongeVo;
import com.example.avic.model.Conge;

import java.util.ArrayList;
import java.util.List;

public class CongeConverter {
    public static CongeVo toVo(Conge bo) {
        if (bo == null)
            return null;
        CongeVo vo = new CongeVo();
        vo.setId(bo.getId());
        vo.setDateDebut(bo.getDateDebut());
        vo.setDateFin(bo.getDateFin());
        vo.setMotif(bo.getMotif());
        vo.setEtat(bo.getEtat());
        vo.setPersonnel(PersonnelConverter.toVo(bo.getPersonnel()));
        return vo;
    }

    public static Conge toBo(CongeVo vo) {
        if (vo == null)
            return null;
        Conge bo = new Conge();
        bo.setId(vo.getId());
        bo.setDateDebut(vo.getDateDebut());
        bo.setDateFin(vo.getDateFin());
        bo.setMotif(vo.getMotif());
        bo.setEtat(vo.getEtat());
        bo.setPersonnel(PersonnelConverter.toBo(vo.getPersonnel()));
        return bo;
    }

    public static List<CongeVo> toVoList(List<Conge> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<CongeVo> voList = new ArrayList<>();
        for (Conge conge : boList) {
            voList.add(toVo(conge));
        }
        return voList;
    }

    public static List<Conge> toBoList(List<CongeVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Conge> boList = new ArrayList<>();
        for (CongeVo congeVo : voList) {
            boList.add(toBo(congeVo));
        }
        return boList;
    }
}
