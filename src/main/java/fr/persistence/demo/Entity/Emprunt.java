package fr.persistence.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date date_emprunt;
    private Date date_fin_prevue;
    private Date date_retour;

    @ManyToOne
    private Adherent adherent;

    @ManyToMany
    private List<Livre> livre;
}
