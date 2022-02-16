package com.example.avic.domaine.vo;
import com.example.avic.dao.PersonnelRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CongeVo {

private Long id;
private String dateDebut;
private String dateFin;
private String motif;
private String etat;
private Long idpersonnel;
private PersonnelVo personnel;
public CongeVo(String dateDebut,String dateFin,String motif,String etat){
this.dateDebut=dateDebut;
this.dateFin=dateFin;
this.motif=motif;
this.etat=etat;
}

    public CongeVo(String dateDebut, String dateFin, String motif, String etat, Long idpersonnel, PersonnelVo personnel) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
        this.etat = etat;
        this.idpersonnel = idpersonnel;
        this.personnel = personnel;
    }

}
