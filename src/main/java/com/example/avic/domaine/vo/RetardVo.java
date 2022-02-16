package com.example.avic.domaine.vo;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor

public class RetardVo {

    private Long id;
    private String dateRetard;
    private Boolean type;
    private String justification;
    private int nbrHeure;
    private PersonnelVo personnel;
    private Long idpersonnel;



    public RetardVo(Long id, String dateRetard, Boolean type, String justification, int nbrHeure, PersonnelVo personnel, Long idpersonnel) {
        this.id = id;
        this.dateRetard = dateRetard;
        this.type = type;
        this.justification = justification;
        this.nbrHeure = nbrHeure;
        this.personnel = personnel;
        this.idpersonnel = idpersonnel;
    }
}
