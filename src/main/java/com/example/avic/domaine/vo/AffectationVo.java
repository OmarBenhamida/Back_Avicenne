package com.example.avic.domaine.vo;

import com.example.avic.model.Personnel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AffectationVo {
    private Long id;
    private String dateDebut;
    private String dateFin;
    private PostVo post;
    private PersonnelVo personnel;
    private Long idpersonnel;
    private Long idpost;





    public AffectationVo(String dateDebut, String dateFin, PersonnelVo personnel, Long idpersonnel, PostVo post, Long idpost) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.personnel = personnel;
        this.idpersonnel = idpersonnel;
        this.post = post;
        this.idpost = idpost;
    }

}
