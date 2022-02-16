package com.example.avic.domaine.converter;

import com.example.avic.domaine.vo.PersonnelVo;
import com.example.avic.model.Personnel;

import java.util.ArrayList;
import java.util.List;

public class PersonnelConverter {
    public static PersonnelVo toVo(Personnel bo) {
        if (bo == null)
            return null;
        PersonnelVo vo = new PersonnelVo();
        vo.setId(bo.getId());
        vo.setEmail(bo.getEmail());
        vo.setPasseword(bo.getPasseword());
        vo.setMarticule(bo.getMarticule());
        vo.setNom(bo.getNom());
        vo.setPrenom(bo.getPrenom());
        vo.setCin(bo.getCin());
        vo.setAdresse(bo.getAdresse());
        vo.setDateNaissance(bo.getDateNaissance());
        vo.setLieuNaissance(bo.getLieuNaissance());
        vo.setSexe(bo.getSexe());
        vo.setDateEmbauche(bo.getDateEmbauche());
        vo.setNbrEnfant(bo.getNbrEnfant());
        vo.setSecuriteSocial(bo.getSecuriteSocial());
        vo.setTel(bo.getTel());
        vo.setIntituleDiplome(bo.getIntituleDiplome());
        vo.setSituationFamiliale(bo.getSituationFamiliale());
        vo.setImg(bo.getImg());
        return vo;
    }

    public static Personnel toBo(PersonnelVo vo) {
        if (vo == null)
            return null;
        Personnel bo = new Personnel();
        bo.setId(vo.getId());
        bo.setEmail(vo.getEmail());
        bo.setPasseword(vo.getPasseword());
        bo.setMarticule(vo.getMarticule());
        bo.setNom(vo.getNom());
        bo.setPrenom(vo.getPrenom());
        bo.setCin(vo.getCin());
        bo.setAdresse(vo.getAdresse());
        bo.setDateNaissance(vo.getDateNaissance());
        bo.setLieuNaissance(vo.getLieuNaissance());
        bo.setSexe(vo.getSexe());
        bo.setDateEmbauche(vo.getDateEmbauche());
        bo.setNbrEnfant(vo.getNbrEnfant());
        bo.setSecuriteSocial(vo.getSecuriteSocial());
        bo.setTel(vo.getTel());
        bo.setIntituleDiplome(vo.getIntituleDiplome());
        bo.setSituationFamiliale(vo.getSituationFamiliale());
        bo.setImg(vo.getImg());
        return bo;
    }

    public static List<PersonnelVo> toVoList(List<Personnel> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<PersonnelVo> voList = new ArrayList<>();
        for (Personnel personnel : boList) {
            voList.add(toVo(personnel));
        }
        return voList;
    }

    public static List<Personnel> toBoList(List<PersonnelVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<Personnel> boList = new ArrayList<>();
        for (PersonnelVo personnelVo : voList) {
            boList.add(toBo(personnelVo));
        }
        return boList;
    }
}
