package com.example.practicapokemon.model;

import java.util.List;

public class Pokemon {
    private int id;
    private String nom;
    private List<Tipus> tipus;
    private boolean isFav;
    private String desc;
    private float height;
    private float weight;
    private List<Ability> abilities;
    private BaseStats baseStats;
    private static List<Pokemon> pokemonList;

    public Pokemon(int id, String nom, List<Tipus> tipus, boolean isFav, String desc, float height, float weight, List<Ability> abilities, BaseStats baseStats) {
        setId(id);
        setNom(nom);
        setTipus(tipus);
        setFav(isFav);
        setDesc(desc);
        setHeight(height);
        setWeight(weight);
        setAbilities(abilities);
        setBaseStats(baseStats);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Tipus> getTipus() {
        return tipus;
    }

    public void setTipus(List<Tipus> tipus) {
        this.tipus = tipus;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public BaseStats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(BaseStats baseStats) {
        this.baseStats = baseStats;
    }

    public static List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public static void setPokemonList(List<Pokemon> pokemonList) {
        Pokemon.pokemonList = pokemonList;
    }
}
