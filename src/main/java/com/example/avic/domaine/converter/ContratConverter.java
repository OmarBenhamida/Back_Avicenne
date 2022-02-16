package com.example.avic.domaine.converter;

import com.example.avic.domaine.vo.ContratVo;
import com.example.avic.model.Contrat;

import java.util.ArrayList;
import java.util.List;

public class ContratConverter {
    public static ContratVo toVo(Contrat bo) {
        if (bo == null)
            return null;
        ContratVo vo = new ContratVo();
        vo.setId(bo.getId());
        vo.setDateDebut(bo.getDateDebut());
        vo.setDateFin(bo.getDateFin());
        vo.setTypeContrat(bo.getTypeContrat());
        vo.setDateSignature(bo.getDateSignature());
        vo.setPersonnel(PersonnelConverter.toVo(bo.getPersonnel()));
        return vo;
    }

    public static Contrat toBo(ContratVo vo) {
        if (vo == null)
            return null;
        Contrat bo = new Contrat();
        bo.setId(vo.getId());
        bo.setDateDebut(vo.getDateDebut());
        bo.setDateFin(vo.getDateFin());
        bo.setTypeContrat(vo.getTypeContrat());
        bo.setDateSignature(vo.getDateSignature());
        bo.setPersonnel(PersonnelConverter.toBo(vo.getPersonnel()));

        return bo;
    }

    public static List<ContratVo> toVoList(List<Contrat> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<ContratVo> voList = new ArrayList<>();
        for (Contrat contrat : boList) {
            voList.add(toVo(contrat));
        }
        return voList;
    }

    public static List<Contrat> toBoList(List<ContratVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Contrat> boList = new ArrayList<>();
        for (ContratVo contratVo : voList) {
            boList.add(toBo(contratVo));
        }
        return boList;
    }
}
