package com.ib.cards.battle.battlecardsib.business;

/**
 * Created by Bruno on 02/03/2017.
 */

public class Constants {
    public static final String SUCCESS_MESSAGE_200 = "ok.";
    public static final String ERROR_MESSAGE_500 = "Internal server error.";
    public static final String ERROR_MESSAGE_508 = "Hash already exist.";
    public static final String ERROR_MESSAGE_412 = "Game not found.";
    public static final String HASH_KEY = "hash";
    public static final String FROM_JOIN = "isFromJoin";
    public static String URL_SERVICE = "http://10.100.100.30:3000";
    public static String GUEST = "guest_";
    public static String MASTER = "master_";
    public static String RIVAL = "";
    //Type of attack
    public static int ATTACK_NORMAL = 1;
    public static int ATTACK_MAGIC = 2;

    //Definitions
    public static int LEVEL_MIN = 1;
    public static int LEVEL_MAX = 3;
    //Tese: Remover quando a sala for criada dinamicamente
    public static String HASH_TEST = "ehnois";

    // Status
    public static final String READY_STATUS = "Ready";
    public static final String OFFLINE_STATUS = "Offline";
    public static final String ONLINE_STATUS = "Online";

    public static class CATEGORY_CARD {
        public static String HUMAN = "Human", ELF = "Elf", DWARF = "Dwarf", TROLL = "Troll", GARGULA = "Gargula", VAMPIRE = "Vampire", ORC = "Orc", WEREWOLF = "WEREWOLF", MAGE = "Mage";
    }
}
