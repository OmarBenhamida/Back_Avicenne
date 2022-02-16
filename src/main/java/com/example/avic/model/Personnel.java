package com.example.avic.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Personnel")
public class Personnel extends User {
    @Column(name = "personnel_marticule")
    private String marticule;
    @Column(name = "personnel_nom")
    private String nom;
    @Column(name = "personnel_prenom")
    private String prenom;
    @Column(name = "personnel_cin")
    private String cin;
    @Column(name = "personnel_adresse")
    private String adresse;
    @Column(name = "personnel_dateNaissance")
    private String dateNaissance;
    @Column(name = "personnel_lieuNaissance")
    private String lieuNaissance;
    @Column(name = "personnel_sexe")
    private String sexe;
    @Column(name = "personnel_dateEmbauche")
    private String dateEmbauche;
    @Column(name = "personnel_nbrEnfant")
    private int nbrEnfant;
    @Column(name = "personnel_securiteSocial")
    private String securiteSocial;
    @Column(name = "personnel_tel")
    private String tel;
    @Column(name = "personnel_intituleDiplome")
    private String intituleDiplome;
    @Column(name = "personnel_situationFamiliale")
    private String situationFamiliale;
    @Lob
    @Column(name = "picture", length = 100000)
    byte[] img;
}
