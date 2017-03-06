package com.ib.cards.battle.battlecardsib;

import java.io.Serializable;

/**
 * Created by iago on 02/03/17.
 */

public class Card implements Serializable{

    private int hp;
    private int energy;
    private String category;
    private String magic;
    private int magicPower;
    private int level;
    private int image;
    private String description;
    private String name;
    private int power;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }
}
