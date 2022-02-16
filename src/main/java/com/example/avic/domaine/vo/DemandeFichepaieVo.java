package com.example.avic.domaine.vo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemandeFichepaieVo extends  DemandeVo {
private int mois;
private int annee;
public DemandeFichepaieVo(String dateDemande,String motif,String statut,int mois,int annee){
super(dateDemande,motif,statut);
this.mois=mois;
this.annee=annee;
}
}
