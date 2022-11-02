package com.example.practicapokemon.model;

import java.util.List;

public class Type implements Comparable<Type>{
    int id;
    String name;
    private static List<Type> types;

    public Type(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setList(List<Type> l){
        types = l;
    }

    public static Type getType(int typeId) {
        return types.get(typeId-1);
    }

    @Override
    public int compareTo(Type type) {
        return this.getId()-type.getId();
    }

    @Override
    public String toString() {
        return name;
    }
}
