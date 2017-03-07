package com.ib.cards.battle.battlecardsib.business;

import com.ib.cards.battle.battlecardsib.domain.Attack;

/**
 * Created by Bruno on 02/03/2017.
 */

public class Constants {
    public static String URL_SERVICE = "http://10.100.100.30:3000";


    public static String GUEST = "guest_";
    public static String MASTER = "master_";
    public static String RIVAL = "";

    public static String SUCCESS_MESSAGE_200 = "ok.";
    public static String ERROR_MESSAGE_500 = "Internal server error.";
    public static String ERROR_MESSAGE_508 = "Hash already exist.";
    public static String ERROR_MESSAGE_412 = "Game not found.";

    //Type of attack
    public static int ATTACK_NORMAL = 1;
    public static int ATTACK_MAGIC = 2;

    //Definitions
    public static int LEVEL_MIN = 1;
    public static int LEVEL_MAX = 3;
    public static class CATEGORY_CARD{
        public static String HUMAN = "Human", ELF = "Elf", DWARF = "Dwarf", TROLL = "Troll", GARGULA = "Gargula", VAMPIRE = "Vampire", ORC = "Orc", WEREWOLF = "WEREWOLF", MAGE = "Mage";
    };

    //Tese: Remover quando a sala for criada dinamicamente
    public static String HASH_TEST = "ehnois";
}
