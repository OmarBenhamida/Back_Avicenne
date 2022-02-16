package com.example.avic.domaine.converter;
import com.example.avic.domaine.vo.AffectationVo;
import com.example.avic.model.Affectation;
import java.util.ArrayList;
import java.util.List;
public class AffectationConverter {
public static AffectationVo toVo(Affectation bo) {
if (bo == null)
return null;
AffectationVo vo = new AffectationVo();
vo.setId(bo.getId());
vo.setDateDebut(bo.getDateDebut());
vo.setDateFin(bo.getDateFin());
vo.setPost(PostConverter.toVo(bo.getPost()));
vo.setPersonnel(PersonnelConverter.toVo(bo.getPersonnel()));
return vo;
}
public static Affectation toBo(AffectationVo vo) {
if (vo == null)
return null;
Affectation bo = new Affectation();
bo.setId(vo.getId());
bo.setDateDebut(vo.getDateDebut());
bo.setDateFin(vo.getDateFin());
bo.setPersonnel(PersonnelConverter.toBo(vo.getPersonnel()));
bo.setPost(PostConverter.toBo(vo.getPost()));


return bo;
}
public static List<AffectationVo> toVoList (List<Affectation> boList) {
if (boList == null || boList.isEmpty())
return null;
List<AffectationVo> voList = new ArrayList<>();
for (Affectation affectation : boList) {
voList.add(toVo(affectation));
}
return voList;
}
public static List<Affectation> toBoList (List<AffectationVo> voList) {
if (voList == null || voList.isEmpty())
return null;
List<Affectation> boList = new ArrayList<>();
for (AffectationVo affectationVo : voList) {
boList.add(toBo(affectationVo));
}
return boList;
}
}
