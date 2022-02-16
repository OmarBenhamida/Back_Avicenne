package com.example.avic.domaine.converter;

import com.example.avic.domaine.vo.RetardVo;
import com.example.avic.model.Retard;

import java.util.ArrayList;
import java.util.List;

public class RetardConverter {
    public static RetardVo toVo(Retard bo) {
        if (bo == null)
            return null;
        RetardVo vo = new RetardVo();
        vo.setId(bo.getId());
        vo.setDateRetard(bo.getDateRetard());
        vo.setType(bo.getType());
        vo.setJustification(bo.getJustification());
        vo.setNbrHeure(bo.getNbrHeure());
        vo.setPersonnel(PersonnelConverter.toVo(bo.getPersonnel()));
        return vo;
    }

    public static Retard toBo(RetardVo vo) {
        if (vo == null)
            return null;
        Retard bo = new Retard();
        bo.setId(vo.getId());
        bo.setDateRetard(vo.getDateRetard());
        bo.setType(vo.getType());
        bo.setJustification(vo.getJustification());
        bo.setNbrHeure(vo.getNbrHeure());
        bo.setPersonnel(PersonnelConverter.toBo(vo.getPersonnel()));
        return bo;
    }

    public static List<RetardVo> toVoList(List<Retard> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<RetardVo> voList = new ArrayList<>();
        for (Retard retard : boList) {
            voList.add(toVo(retard));
        }
        return voList;
    }

    public static List<Retard> toBoList(List<RetardVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Retard> boList = new ArrayList<>();
        for (RetardVo retardVo : voList) {
            boList.add(toBo(retardVo));
        }
        return boList;
    }
}
