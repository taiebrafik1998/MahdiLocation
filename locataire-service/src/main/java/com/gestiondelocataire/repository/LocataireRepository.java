package com.gestiondelocataire.locataire_service.repository;

import com.gestiondelocataire.locataire_service.model.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocataireRepository extends JpaRepository<Locataire, Long> {
    // Pas besoin de méthode ici pour les opérations de base (CRUD)
}
