package fr.persistence.demo.Repository;

import fr.persistence.demo.Entity.Categorie;
import fr.persistence.demo.Entity.Livre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivreRepository extends CrudRepository<Livre, Long> {
    @Query("SELECT livre FROM Livre livre WHERE livre.flag = false")
    List<Livre> getAllNoFlagsBooks();

    @Query("SELECT livre FROM Livre livre WHERE livre.flag = true")
    List<Livre> getAllFlagsBooks();

}


