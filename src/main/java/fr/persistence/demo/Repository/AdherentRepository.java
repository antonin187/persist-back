package fr.persistence.demo.Repository;

import fr.persistence.demo.Entity.Adherent;
import org.springframework.data.repository.CrudRepository;

public interface AdherentRepository extends CrudRepository<Adherent, Long> {
}
