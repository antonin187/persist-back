package fr.persistence.demo.Controller;

import fr.persistence.demo.Entity.Adherent;
import fr.persistence.demo.Repository.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdherentController {

    @Autowired
    AdherentRepository adherentRepository;

    @RequestMapping(path = "/adherents", method = RequestMethod.GET)
    public Iterable<Adherent> getAllAdherents() {
        return adherentRepository.findAll();
    }

    @RequestMapping(path = "/adherent", method = RequestMethod.POST)
    public Adherent addAdherent(@RequestBody Adherent adherent) {
        return adherentRepository.save(adherent);
    }

    @RequestMapping(path = "/adherent", method = RequestMethod.GET)
    public Adherent findAdherentById(@RequestParam Long id) {
        Optional<Adherent> adherent = adherentRepository.findById(id);
        return adherent.orElse(null);
    }

    @RequestMapping(path = "/adherent", method = RequestMethod.PATCH)
    public Adherent updateAdherentById(@RequestBody Adherent adherent) {
        return adherentRepository.save(adherent);
    }

    @RequestMapping(path = "/adherent", method = RequestMethod.DELETE)
    public Boolean deleteAdherentById(@RequestParam Long id){
        Optional<Adherent> adherentToDelete = adherentRepository.findById(id);
        if(adherentToDelete.isPresent()){
            adherentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
