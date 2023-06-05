package fr.persistence.demo.Controller;

import fr.persistence.demo.Entity.Categorie;
import fr.persistence.demo.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategorieController {
    @Autowired
    CategorieRepository categorieRepository;

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public Iterable<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @RequestMapping(path = "/categories/noflag", method = RequestMethod.GET)
    public Iterable<Categorie> getAllNoFlagsCategories() {
        return categorieRepository.getAllNoFlagsCategories();
    }

    @RequestMapping(path = "/categorie", method = RequestMethod.POST)
    public Categorie addCategorie(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @RequestMapping(path = "/categorie", method = RequestMethod.GET)
    public Categorie findCategorieById(@RequestParam Long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        return categorie.orElse(null);
    }

    @RequestMapping(path = "/categorie", method = RequestMethod.PATCH)
    public Categorie updateCategorieById(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

//    @RequestMapping(path = "/categorie", method = RequestMethod.DELETE)
//    public Boolean deleteCategorieById(@RequestParam Long id){
//        Optional<Categorie> categorieToDelete = categorieRepository.findById(id);
//        if(categorieToDelete.isPresent()){
//            categorieRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }

    @RequestMapping(path = "/categorie/delete", method = RequestMethod.PATCH)
    public Categorie updateFlagCategorieById(@RequestBody Categorie categorie) {
        categorie.setFlag(true);
        return categorieRepository.save(categorie);
    }
}
