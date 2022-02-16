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
@DiscriminatorValue("DemandeAttestation")
public class DemandeAttestation extends Demande{
}
