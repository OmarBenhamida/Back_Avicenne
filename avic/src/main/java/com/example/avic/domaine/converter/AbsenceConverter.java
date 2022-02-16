package com.example.avic.domaine.converter;

import com.example.avic.domaine.vo.AbsenceVo;
import com.example.avic.model.Absence;

import java.util.ArrayList;
import java.util.List;

public class AbsenceConverter {
    public static AbsenceVo toVo(Absence bo) {
        if (bo == null)
            return null;
        AbsenceVo vo = new AbsenceVo();
        vo.setId(bo.getId());
        vo.setDateAbsence(bo.getDateAbsence());
        vo.setType(bo.getType());
        vo.setJustification(bo.getJustification());
        vo.setPersonnel(PersonnelConverter.toVo(bo.getPersonnel()));
        return vo;
    }

    public static Absence toBo(AbsenceVo vo) {
        if (vo == null)
            return null;
        Absence bo = new Absence();
        bo.setId(vo.getId());
        bo.setDateAbsence(vo.getDateAbsence());
        bo.setType(vo.getType());
        bo.setJustification(vo.getJustification());
        bo.setPersonnel(PersonnelConverter.toBo(vo.getPersonnel()));

        return bo;
    }

    public static List<AbsenceVo> toVoList(List<Absence> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<AbsenceVo> voList = new ArrayList<>();
        for (Absence absence : boList) {
            voList.add(toVo(absence));
        }
        return voList;
    }

    public static List<Absence> toBoList(List<AbsenceVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Absence> boList = new ArrayList<>();
        for (AbsenceVo absenceVo : voList) {
            boList.add(toBo(absenceVo));
        }
        return boList;
    }
}
