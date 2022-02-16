package com.example.avic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "retard")
public class Retard {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "retard_dateRetard")
    private String dateRetard;
    @Column(name = "retard_type")
    private Boolean type;
    @Column(name = "retard_justification")
    private String justification;
    @Column(name = "retard_nbrHeure")
    private int nbrHeure;
    @ManyToOne()
    private Personnel personnel;


}
