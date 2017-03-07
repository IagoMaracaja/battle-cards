package com.ib.cards.battle.battlecardsib.domain;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Bruno on 03/03/2017.
 */

public class Attack {

    /**
     * Name of card
     */
    private String name;
    private int hp;
    private int power;
    private int magic;
    private int energy;
    private int level;
    private int category;
    private int typeAttack;

    public Attack(){}

    public Attack(String name, int hp, int power, int magic, int energy, int level, int category, int typeAttack) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.magic = magic;
        this.energy = energy;
        this.level = level;
        this.category = category;
        this.typeAttack = typeAttack;
    }

    public JSONObject parseToJson(Attack attack){
        JSONObject obj = new JSONObject();
        try {
            obj.put("name", attack.getName());
            obj.put("hp", attack.getHp());
            obj.put("power", attack.getPower());
            obj.put("magic", attack.getMagic());
            obj.put("energy", attack.getEnergy());
            obj.put("level", attack.getLevel());
            obj.put("category", attack.getCategory());
            obj.put("typeAttack", attack.getTypeAttack());
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }

    public Attack parseToAttack(JSONObject jsonObj){
        Attack attack = new Attack();
        try {
            attack.setName(jsonObj.getString("name"));
            attack.setHp(jsonObj.getInt("hp"));
            attack.setPower(jsonObj.getInt("power"));
            attack.setMagic(jsonObj.getInt("magic"));
            attack.setEnergy(jsonObj.getInt("energy"));
            attack.setLevel(jsonObj.getInt("level"));
            attack.setCategory(jsonObj.getInt("category"));
            attack.setTypeAttack(jsonObj.getInt("typeAttack"));
            return attack;
        } catch (JSONException e) {
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getTypeAttack() {
        return typeAttack;
    }

    public void setTypeAttack(int typeAttack) {
        this.typeAttack = typeAttack;
    }
}
