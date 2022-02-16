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
@Table(name = "contrat")
public class Contrat {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "contrat_dateDebut")
    private String dateDebut;
    @Column(name = "contrat_dateFin")
    private String dateFin;
    @Column(name = "contrat_typeContrat")
    private String typeContrat;
    @Column(name = "contrat_dateSignature")
    private String dateSignature;
    @ManyToOne
    private Personnel personnel;

}
