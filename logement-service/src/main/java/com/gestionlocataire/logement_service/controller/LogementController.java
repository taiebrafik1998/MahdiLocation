package com.gestiondelocataire.logement_service.controller;


import com.gestiondelocataire.logement_service.model.Logement;
import com.gestiondelocataire.logement_service.repository.LogementRepository;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logements")
public class LogementController {

    private final LogementRepository logementRepository;

    public LogementController(LogementRepository logementRepository) {
        this.logementRepository = logementRepository;
    }

    // 1. GET : récupérer tous les logements
    @GetMapping
    public List<Logement> getAllLogements() {
        return logementRepository.findAll();
    }

    // 2. POST : créer un logement
    @PostMapping
    public Logement createLogement(@Valid @RequestBody Logement logement) {
        return logementRepository.save(logement);
    }

    // 3. GET : récupérer un logement par ID
    @GetMapping("/{id}")
    public Logement getLogementById(@PathVariable Long id) {
        return logementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Logement non trouvé avec ID = " + id));
    }

    // 4. PUT : mettre à jour un logement
    @PutMapping("/{id}")
    public Logement updateLogement(
            @PathVariable Long id,
            @Valid @RequestBody Logement updatedLogement) {

        return logementRepository.findById(id)
                .map(logement -> {
                    logement.setAdresse(updatedLogement.getAdresse());
                    logement.setSurface(updatedLogement.getSurface());
                    logement.setLoyerBase(updatedLogement.getLoyerBase());
                    logement.setType(updatedLogement.getType());
                    logement.setStatut(updatedLogement.getStatut());
                    logement.setDateDisponibilite(updatedLogement.getDateDisponibilite());
                    return logementRepository.save(logement);
                })
                .orElseThrow(() -> new RuntimeException("Logement non trouvé avec ID = " + id));
    }

    // 5. DELETE : supprimer un logement
    @DeleteMapping("/{id}")
    public void deleteLogement(@PathVariable Long id) {
        logementRepository.deleteById(id);
    }
}
