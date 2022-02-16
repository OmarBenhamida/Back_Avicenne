package com.example.avic.domaine.converter;
import com.example.avic.domaine.vo.DemandeVo;
import com.example.avic.model.Demande;
import java.util.ArrayList;
import java.util.List;
public class DemandeConverter {
public static DemandeVo toVo(Demande bo) {
if (bo == null)
return null;
DemandeVo vo = new DemandeVo();
vo.setId(bo.getId());
vo.setDateDemande(bo.getDateDemande());
vo.setMotif(bo.getMotif());
vo.setStatut(bo.getStatut());
vo.setPersonnel(PersonnelConverter.toVo(bo.getPersonnel()));
return vo;
}
public static Demande toBo(DemandeVo vo) {
if (vo == null)
return null;
Demande bo = new Demande();
bo.setId(vo.getId());
bo.setDateDemande(vo.getDateDemande());
bo.setMotif(vo.getMotif());
bo.setStatut(vo.getStatut());
return bo;
}
public static List<DemandeVo> toVoList (List<Demande> boList) {
if (boList == null || boList.isEmpty())
return null;
List<DemandeVo> voList = new ArrayList<>();
for (Demande demande : boList) {
voList.add(toVo(demande));
}
return voList;
}
public static List<Demande> toBoList (List<DemandeVo> voList) {
if (voList == null || voList.isEmpty())
return null;
List<Demande> boList = new ArrayList<>();
for (DemandeVo demandeVo : voList) {
boList.add(toBo(demandeVo));
}
return boList;
}
}
