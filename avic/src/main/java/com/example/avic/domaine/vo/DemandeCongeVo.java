package com.example.avic.domaine.vo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DemandeCongeVo extends  DemandeVo {
private String datedebut;
private String datefin;
public DemandeCongeVo(String dateDemande,String motif,String statut,String datedebut,String datefin){
super(dateDemande,motif,statut);
this.datedebut=datedebut;
this.datefin=datefin;
}
}
