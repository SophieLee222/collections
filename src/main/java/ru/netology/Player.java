package ru.netology;

import java.util.Objects;

public class Player {
    protected int id;
    protected String name;
    protected int strength;

    public Player() {
    }

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Override equals to compare Player objects based on id, name, and strength
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // Check if the objects are the same instance
        if (o == null || getClass() != o.getClass()) return false;  // Check class type

        Player player = (Player) o;
        return id == player.id && strength == player.strength && Objects.equals(name, player.name);
    }

    // Override hashCode to generate a hash based on id, name, and strength
    @Override
    public int hashCode() {
        return Objects.hash(id, name, strength);
    }
}
