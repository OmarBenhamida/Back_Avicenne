package com.example.avic.domaine.converter;
import com.example.avic.domaine.vo.DemandeAttestationVo;
import com.example.avic.model.DemandeAttestation;
import java.util.ArrayList;
import java.util.List;
public class DemandeAttestationConverter {
public static DemandeAttestationVo toVo(DemandeAttestation bo) {
if (bo == null)
return null;
DemandeAttestationVo vo = new DemandeAttestationVo();
vo.setId(bo.getId());
vo.setDateDemande(bo.getDateDemande());
vo.setMotif(bo.getMotif());
vo.setStatut(bo.getStatut());
return vo;
}
public static DemandeAttestation toBo(DemandeAttestationVo vo) {
if (vo == null)
return null;
DemandeAttestation bo = new DemandeAttestation();
bo.setId(vo.getId());
bo.setDateDemande(vo.getDateDemande());
bo.setMotif(vo.getMotif());
bo.setStatut(vo.getStatut());
return bo;
}
public static List<DemandeAttestationVo> toVoList (List<DemandeAttestation> boList) {
if (boList == null || boList.isEmpty())
return null;
List<DemandeAttestationVo> voList = new ArrayList<>();
for (DemandeAttestation demandeAttestation : boList) {
voList.add(toVo(demandeAttestation));
}
return voList;
}
public static List<DemandeAttestation> toBoList (List<DemandeAttestationVo> voList) {
if (voList == null || voList.isEmpty())
return null;
List<DemandeAttestation> boList = new ArrayList<>();
for (DemandeAttestationVo demandeAttestationVo : voList) {
boList.add(toBo(demandeAttestationVo));
}
return boList;
}
}
