package com.ib.cards.battle.battlecardsib.business;

import com.ib.cards.battle.battlecardsib.domain.Attack;

/**
 * Created by Bruno on 02/03/2017.
 */

public class Constants {
    public static String URL_SERVICE = "http://10.100.100.30:3000";


    public static String GUEST = "guest_";
    public static String MASTER = "master_";

    public static String SUCCESS_MESSAGE_200 = "ok.";
    public static String ERROR_MESSAGE_500 = "Internal server error.";
    public static String ERROR_MESSAGE_508 = "Hash already exist.";
    public static String ERROR_MESSAGE_412 = "Game not found.";

    public static String HASH_TEST = "ehnois";
    public static Attack attackMaster = new Attack("Bruno", 50, 100, 20, 2, 1);
    public static Attack attackGuest = new Attack("Iago", 50, 60, 60, 2, 1);
}
