package fr.persistence.demo.Controller;

import fr.persistence.demo.Entity.Livre;
import fr.persistence.demo.Repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LivreController {

    @Autowired
    LivreRepository livreRepository;


    @RequestMapping(path = "/livres/noflag", method = RequestMethod.GET)
    public Iterable<Livre> getAllLivresNoFlag() {
        return livreRepository.getAllNoFlagsBooks();
    }

    @RequestMapping(path = "/livres/flag", method = RequestMethod.GET)
    public Iterable<Livre> getAllLivresFlag() {
        return livreRepository.getAllFlagsBooks();
    }

    @RequestMapping(path = "/livre", method = RequestMethod.POST)
    public Livre addLivre(@RequestBody Livre livre) {
        return livreRepository.save(livre);
    }

    @RequestMapping(path = "/livre", method = RequestMethod.GET)
    public Livre findLivreById(@RequestParam Long id) {
        Optional<Livre> adherent = livreRepository.findById(id);
        return adherent.orElse(null);
    }

    @RequestMapping(path = "/livre", method = RequestMethod.PATCH)
    public Livre updateLivreById(@RequestBody Livre livre) {
        return livreRepository.save(livre);
    }

    @RequestMapping(path = "/livre", method = RequestMethod.DELETE)
    public Boolean deleteLivreById(@RequestParam Long id){
        Optional<Livre> livreToDelete = livreRepository.findById(id);
        if(livreToDelete.isPresent()){
            livreRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
