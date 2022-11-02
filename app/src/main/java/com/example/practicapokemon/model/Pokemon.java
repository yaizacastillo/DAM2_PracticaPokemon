package com.example.practicapokemon.model;

import java.util.List;

public class Pokemon {
    private int id;
    private String nom;
    private List<Type> types;
    private boolean isFav;
    private String desc;
    private float height;
    private float weight;
    private List<Ability> abilities;
    private BaseStats baseStats;
    private String imageURL;
    private List<Pokemon> evolutions;
    private static List<Pokemon> pokemonList;

    public Pokemon(int id, String nom, List<Type> types, boolean isFav, String desc, float height, float weight, List<Ability> abilities, BaseStats baseStats, String imageURL, List<Pokemon> evolutions) {
        setId(id);
        setNom(nom);
        setTipus(types);
        setFav(isFav);
        setDesc(desc);
        setHeight(height);
        setWeight(weight);
        setAbilities(abilities);
        setBaseStats(baseStats);
        setImageURL(imageURL);
        setEvolutions(evolutions);
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public List<Type> getTipus() {
        return types;
    }

    public void setTipus(List<Type> types) {
        this.types = types;
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

    public List<Pokemon> getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(List<Pokemon> evolutions) {
        this.evolutions = evolutions;
    }

    public static List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public static void setPokemonList(List<Pokemon> pokemonList) {
        Pokemon.pokemonList = pokemonList;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", types=" + types +
                '}';
    }
}
