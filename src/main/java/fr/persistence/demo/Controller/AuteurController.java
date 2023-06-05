package fr.persistence.demo.Controller;

import fr.persistence.demo.Entity.Auteur;
import fr.persistence.demo.Repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuteurController {
    @Autowired
    AuteurRepository auteurRepository;

    @RequestMapping(path = "/auteurs", method = RequestMethod.GET)
    public Iterable<Auteur> getAllAuteur() {
        return auteurRepository.findAll();
    }

    @RequestMapping(path = "/auteur", method = RequestMethod.POST)
    public Auteur addAuteur(@RequestBody Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    @RequestMapping(path = "/auteur", method = RequestMethod.GET)
    public Auteur findAuteurById(@RequestParam Long id) {
        Optional<Auteur> auteur = auteurRepository.findById(id);
        return auteur.orElse(null);
    }

    @RequestMapping(path = "/auteur", method = RequestMethod.PATCH)
    public Auteur updateAuteurById(@RequestBody Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    @RequestMapping(path = "/auteur", method = RequestMethod.DELETE)
    public Boolean deleteAuteurById(@RequestParam Long id){
        Optional<Auteur> auteurToDelete = auteurRepository.findById(id);
        if(auteurToDelete.isPresent()){
            auteurRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
