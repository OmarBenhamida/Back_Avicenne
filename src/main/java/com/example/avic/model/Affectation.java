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
@Table(name = "affectation")
public class Affectation {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "affectation_dateDebut")
    private String dateDebut;
    @Column(name = "affectation_dateFin")
    private String dateFin;
    @OneToOne
 //   @JoinColumn(name = "post_fk")
    private Post post;
    @OneToOne
   // @JoinColumn(name = "personnel_fk")
    private Personnel personnel;
}
