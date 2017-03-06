package com.ib.cards.battle.battlecardsib.domain;

import com.ib.cards.battle.battlecardsib.business.Constants;

import java.io.Serializable;

/**
 * Created by iago on 02/03/17.
 */

public class Card implements Serializable{

    private String category;
    private String name;
    private String description;
    private int energy;
    private int hp;
    private int magic;
    private int power;
    private int image;
    private int level;

    public Card(){}

    public Card(String category, String name, String description, int energy, int hp, int magic, int power, int image, int level) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.energy = energy;
        this.hp = hp;
        this.magic = magic;
        this.power = power;
        this.image = image;
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
