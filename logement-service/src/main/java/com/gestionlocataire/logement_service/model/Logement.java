package com.gestiondelocataire.logement_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Logement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le type de logement est obligatoire")
    @Enumerated(EnumType.STRING)
    private TypeLogement type;

    @NotBlank(message = "L'adresse est obligatoire")
    private String adresse;

    @Positive(message = "La surface doit être positive")
    private double surface;

    @Positive(message = "Le loyer doit être positif")
    private double loyerBase;

    @Enumerated(EnumType.STRING)
    private StatutLogement statut = StatutLogement.DISPONIBLE;

    private String dateDisponibilite;

    public Logement() {}

    // GETTERS / SETTERS
    public Long getId() { return id; }

    public TypeLogement getType() { return type; }
    public void setType(TypeLogement type) { this.type = type; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public double getSurface() { return surface; }
    public void setSurface(double surface) { this.surface = surface; }

    public double getLoyerBase() { return loyerBase; }
    public void setLoyerBase(double loyerBase) { this.loyerBase = loyerBase; }

    public StatutLogement getStatut() { return statut; }
    public void setStatut(StatutLogement statut) { this.statut = statut; }

    public String getDateDisponibilite() { return dateDisponibilite; }
    public void setDateDisponibilite(String dateDisponibilite) { this.dateDisponibilite = dateDisponibilite; }
}
