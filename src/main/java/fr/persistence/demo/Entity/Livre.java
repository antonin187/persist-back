package fr.persistence.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date date_de_parution;

    private Integer nombre_de_pages;


    @ManyToOne
    private Auteur auteur;

    @ManyToOne
    private Categorie categorie;

    private String nom;

    private Boolean flag = false;

}
