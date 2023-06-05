package fr.persistence.demo.Controller;

import fr.persistence.demo.Entity.Emprunt;
import fr.persistence.demo.Repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmpruntController {
    @Autowired
    EmpruntRepository empruntRepository;

    @RequestMapping(path = "/emprunts", method = RequestMethod.GET)
    public Iterable<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    @RequestMapping(path = "/emprunt", method = RequestMethod.POST)
    public Emprunt addEmprunt(@RequestBody Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    @RequestMapping(path = "/emprunt", method = RequestMethod.GET)
    public Emprunt findEmpruntById(@RequestParam Long id) {
        Optional<Emprunt> emprunt = empruntRepository.findById(id);
        return emprunt.orElse(null);
    }

    @RequestMapping(path = "/emprunt", method = RequestMethod.PATCH)
    public Emprunt updateEmpruntById(@RequestBody Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    @RequestMapping(path = "/emprunt", method = RequestMethod.DELETE)
    public Boolean deleteEmpruntById(@RequestParam Long id){
        Optional<Emprunt> empruntToDelete = empruntRepository.findById(id);
        if(empruntToDelete.isPresent()){
            empruntRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @RequestMapping(path = "/emprunts/betweenDates", method = RequestMethod.GET)
    public Iterable<Emprunt> getAllEmpruntsBetweenDates(@RequestBody Date start, @RequestBody Date end) {
        return empruntRepository.findAllBetweenDates(start, end);
    }
}
