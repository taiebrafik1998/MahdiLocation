package com.gestiondelocataire.locataire_service.controller;

import com.gestiondelocataire.locataire_service.model.Locataire;
import com.gestiondelocataire.locataire_service.repository.LocataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locataires") // tous les end points commenceront par "/locataires"
public class LocataireController {

    private final LocataireRepository locataireRepository;

    @Autowired // pour faire simple elle dit inject automatiquement une dependance ici 
                // LocataireRepository sera injecter automatiquement
    public LocataireController(LocataireRepository locataireRepository) {
        this.locataireRepository = locataireRepository;
    }

    // 1. Récupérer tous les locataires
    @GetMapping
    public List<Locataire> getAllLocataires() {
        return locataireRepository.findAll();
    }

    // 2. Ajouter un nouveau locataire
    @PostMapping
    public Locataire createLocataire(@RequestBody Locataire locataire) {
        return locataireRepository.save(locataire);
    }

    // 3. Supprimer un locataire par ID
    @DeleteMapping("/{id}")
    public void deleteLocataire(@PathVariable Long id) {
        locataireRepository.deleteById(id);
    }
    // 4. Mettre à jour un locataire
    @PutMapping("/{id}")
    public Locataire updateLocataire(@PathVariable Long id, @RequestBody Locataire updatedLocataire) {
    return locataireRepository.findById(id)
    .map(locataire -> {
            locataire.setNom(updatedLocataire.getNom());
            locataire.setPrenom(updatedLocataire.getPrenom());
            locataire.setEmail(updatedLocataire.getEmail());
            locataire.setTelephone(updatedLocataire.getTelephone());
            return locataireRepository.save(locataire);
    }).orElseThrow(() -> new RuntimeException("locataire non trouvé avec ID = " + id));
}
}
