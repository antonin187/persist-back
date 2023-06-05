package fr.persistence.demo.Repository;

import fr.persistence.demo.Entity.Categorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {


    @Query("SELECT categorie FROM Categorie categorie WHERE categorie.flag = false")
    List<Categorie> getAllNoFlagsCategories();
}
