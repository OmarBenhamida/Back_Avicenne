package com.example.avic.domaine.vo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
public class DemandeAttestationVo extends  DemandeVo {
public DemandeAttestationVo(String dateDemande,String motif,String statut){
super(dateDemande,motif,statut);
}
}
