package com.example.avic.domaine.converter;
import com.example.avic.domaine.vo.DemandeCongeVo;
import com.example.avic.model.DemandeConge;
import java.util.ArrayList;
import java.util.List;
public class DemandeCongeConverter {
public static DemandeCongeVo toVo(DemandeConge bo) {
if (bo == null)
return null;
DemandeCongeVo vo = new DemandeCongeVo();
vo.setId(bo.getId());
vo.setDateDemande(bo.getDateDemande());
vo.setMotif(bo.getMotif());
vo.setStatut(bo.getStatut());
vo.setDatedebut(bo.getDatedebut());
vo.setDatefin(bo.getDatefin());
return vo;
}
public static DemandeConge toBo(DemandeCongeVo vo) {
if (vo == null)
return null;
DemandeConge bo = new DemandeConge();
bo.setId(vo.getId());
bo.setDateDemande(vo.getDateDemande());
bo.setMotif(vo.getMotif());
bo.setStatut(vo.getStatut());
bo.setDatedebut(vo.getDatedebut());
bo.setDatefin(vo.getDatefin());
return bo;
}
public static List<DemandeCongeVo> toVoList (List<DemandeConge> boList) {
if (boList == null || boList.isEmpty())
return null;
List<DemandeCongeVo> voList = new ArrayList<>();
for (DemandeConge demandeConge : boList) {
voList.add(toVo(demandeConge));
}
return voList;
}
public static List<DemandeConge> toBoList (List<DemandeCongeVo> voList) {
if (voList == null || voList.isEmpty())
return null;
List<DemandeConge> boList = new ArrayList<>();
for (DemandeCongeVo demandeCongeVo : voList) {
boList.add(toBo(demandeCongeVo));
}
return boList;
}
}
