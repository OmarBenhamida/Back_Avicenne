package com.example.avic.model;

import lombok.*;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "absence")

public class Absence {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "absence_dateAbsence")
    private String dateAbsence;
    @Column(name = "absence_type")
    private Boolean type;
    @Column(name = "absence_justification")
    private String justification;
    @ManyToOne
    private Personnel personnel;


}
