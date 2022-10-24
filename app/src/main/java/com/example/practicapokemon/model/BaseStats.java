package com.example.practicapokemon.model;

public class BaseStats {
    int hp;
    int attack;
    int defense;
    int spAttack;
    int spDefense;
    int speed;

    public BaseStats(int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
        setHp(hp);
        setAttack(attack);
        setDefense(defense);
        setSpAttack(spAttack);
        setSpDefense(spDefense);
        setSpeed(speed);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
