package com.example.avic.domaine.vo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemandeVo {
private Long id;
private String dateDemande;
private String motif;
private String statut;
private PersonnelVo personnel;
public DemandeVo(String dateDemande,String motif,String statut){
this.dateDemande=dateDemande;
this.motif=motif;
this.statut=statut;
}
}
