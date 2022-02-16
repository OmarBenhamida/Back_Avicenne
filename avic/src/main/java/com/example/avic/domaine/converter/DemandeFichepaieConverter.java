package com.example.avic.domaine.converter;
import com.example.avic.domaine.vo.DemandeFichepaieVo;
import com.example.avic.model.DemandeFichepaie;
import java.util.ArrayList;
import java.util.List;
public class DemandeFichepaieConverter {
public static DemandeFichepaieVo toVo(DemandeFichepaie bo) {
if (bo == null)
return null;
DemandeFichepaieVo vo = new DemandeFichepaieVo();
vo.setId(bo.getId());
vo.setDateDemande(bo.getDateDemande());
vo.setMotif(bo.getMotif());
vo.setStatut(bo.getStatut());
vo.setMois(bo.getMois());
vo.setAnnee(bo.getAnnee());
return vo;
}
public static DemandeFichepaie toBo(DemandeFichepaieVo vo) {
if (vo == null)
return null;
DemandeFichepaie bo = new DemandeFichepaie();
bo.setId(vo.getId());
bo.setDateDemande(vo.getDateDemande());
bo.setMotif(vo.getMotif());
bo.setStatut(vo.getStatut());
bo.setMois(vo.getMois());
bo.setAnnee(vo.getAnnee());
return bo;
}
public static List<DemandeFichepaieVo> toVoList (List<DemandeFichepaie> boList) {
if (boList == null || boList.isEmpty())
return null;
List<DemandeFichepaieVo> voList = new ArrayList<>();
for (DemandeFichepaie demandeFichepaie : boList) {
voList.add(toVo(demandeFichepaie));
}
return voList;
}
public static List<DemandeFichepaie> toBoList (List<DemandeFichepaieVo> voList) {
if (voList == null || voList.isEmpty())
return null;
List<DemandeFichepaie> boList = new ArrayList<>();
for (DemandeFichepaieVo demandeFichepaieVo : voList) {
boList.add(toBo(demandeFichepaieVo));
}
return boList;
}
}
