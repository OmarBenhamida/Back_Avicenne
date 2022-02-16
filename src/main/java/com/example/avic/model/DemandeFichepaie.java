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
@DiscriminatorValue("DemandeFichepaie")
public class DemandeFichepaie extends Demande{
@Column(name="demandeFichepaie_mois")
private int mois;
@Column(name="demandeFichepaie_annee")
private int annee;

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
