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
@Table(name = "conge")
public class Conge {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "conge_dateDebut")
    private String dateDebut;
    @Column(name = "conge_dateFin")
    private String dateFin;
    @Column(name = "conge_motif")
    private String motif;
    @Column(name = "conge_etat")
    private String etat;


    @ManyToOne
    private Personnel personnel;


}
