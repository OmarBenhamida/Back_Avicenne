package com.example.avic.domaine.vo;

import lombok.*;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonnelVo extends UserVo {
    private String marticule;
    private String nom;
    private String prenom;
    private String cin;
    private String adresse;
    private String dateNaissance;
    private String lieuNaissance;
    private String sexe;
    private String dateEmbauche;
    private int nbrEnfant;
    private String securiteSocial;
    private String tel;
    private String intituleDiplome;
    private String situationFamiliale;
    @Lob
    byte[] img;

    public PersonnelVo(String email, String passeword, String marticule, String nom, String prenom, String cin, String adresse, String dateNaissance, String lieuNaissance, String sexe, String dateEmbauche, int nbrEnfant, String securiteSocial, String tel, String intituleDiplome, String situationFamiliale) {
        super(email, passeword);
        this.marticule = marticule;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.sexe = sexe;
        this.dateEmbauche = dateEmbauche;
        this.nbrEnfant = nbrEnfant;
        this.securiteSocial = securiteSocial;
        this.tel = tel;
        this.intituleDiplome = intituleDiplome;
        this.situationFamiliale = situationFamiliale;
    }

    public String getMarticule() {
        return marticule;
    }

    public void setMarticule(String marticule) {
        this.marticule = marticule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    public String getSecuriteSocial() {
        return securiteSocial;
    }

    public void setSecuriteSocial(String securiteSocial) {
        this.securiteSocial = securiteSocial;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIntituleDiplome() {
        return intituleDiplome;
    }

    public void setIntituleDiplome(String intituleDiplome) {
        this.intituleDiplome = intituleDiplome;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }


}
