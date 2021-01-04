package com.english.model;

public class Role extends Model {

    String name;

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("%s [id: %d, name: %s]", getClass().getSimpleName(), getId(), getName());
    }
}
