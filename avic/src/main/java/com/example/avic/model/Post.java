package com.example.avic.model;

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
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "post_libelle")
    private String libelle;
    private String service;
    @Column(name="post_salairehoraire")
    private double salairehoraire;

}
