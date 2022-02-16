package com.example.avic.domaine.vo;

import com.example.avic.model.Personnel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AbsenceVo {
    private Long id;
    private String dateAbsence;
    private Boolean type;
    private String justification;
    private PersonnelVo personnel;
    private Long idpersonnel;



    public AbsenceVo(String dateAbsence, Boolean type, String justification, PersonnelVo personnel, Long idpersonnel) {
        this.dateAbsence = dateAbsence;
        this.type = type;
        this.justification = justification;
        this.personnel = personnel;
        this.idpersonnel = idpersonnel;
    }

}
