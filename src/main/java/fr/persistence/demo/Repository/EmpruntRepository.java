package fr.persistence.demo.Repository;

import fr.persistence.demo.Entity.Categorie;
import fr.persistence.demo.Entity.Emprunt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

import java.util.List;

public interface EmpruntRepository extends CrudRepository<Emprunt, Long> {

    @Query("SELECT emprunt FROM Emprunt emprunt WHERE emprunt.date_emprunt = :#{#start} AND emprunt.date_fin_prevue = :#{#end}")
    List<Emprunt> findAllBetweenDates(@Param("start") Date start, @Param("end") Date end);

//    @Query("SELECT COUNT(*) FROM emprunt_livre RIGHT JOIN livre ON emprunt_livre.livre_id = livre.id  WHERE livre_id = ?1")
//    Integer getNumberEmpruntByLivreId(Long ID);
}
