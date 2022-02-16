package com.example.avic.domaine.vo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratVo {

    private Long id;
    private String dateDebut;
    private String dateFin;
    private String typeContrat;
    private String dateSignature;
    private PersonnelVo personnel;
    private Long idpersonnel;

    public ContratVo(String dateDebut, String dateFin, String typeContrat, String dateSignature, PersonnelVo personnel, Long idpersonnel) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.typeContrat = typeContrat;
        this.dateSignature = dateSignature;
        this.personnel = personnel;
        this.idpersonnel = idpersonnel;
    }


}
