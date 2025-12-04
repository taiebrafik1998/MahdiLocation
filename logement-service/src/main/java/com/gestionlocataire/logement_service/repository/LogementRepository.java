package com.gestiondelocataire.logement_service.repository;

import com.gestiondelocataire.logement_service.model.Logement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogementRepository extends JpaRepository<Logement, Long> {
    // Toutes les méthodes CRUD sont disponibles automatiquement :
    // findAll(), findById(), save(), deleteById()...
}
