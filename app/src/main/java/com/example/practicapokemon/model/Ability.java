package com.example.practicapokemon.model;

public class Ability {
    String nom;
    boolean isHidden;

    public Ability(String nom, boolean isHidden) {
        setNom(nom);
        setHidden(isHidden);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }
}
