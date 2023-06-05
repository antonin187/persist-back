package fr.persistence.demo.Repository;

import fr.persistence.demo.Entity.Auteur;
import org.springframework.data.repository.CrudRepository;

public interface AuteurRepository extends CrudRepository<Auteur, Long> {
}
