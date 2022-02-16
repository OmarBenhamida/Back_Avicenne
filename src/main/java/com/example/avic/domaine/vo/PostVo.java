package com.example.avic.domaine.vo;
import com.example.avic.model.Service;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostVo {
private Long id;
private String libelle;
private String service;
private double salairehoraire;


    public PostVo(String libelle, String service){
this.libelle=libelle;
this.service=service;
}
}
