package com.ib.cards.battle.battlecardsib.business;

import com.ib.cards.battle.battlecardsib.socket.ServerInstanceBusiness;

import org.json.JSONObject;

/**
 * Created by Bruno on 03/03/2017.
 */

public class PlayerBusiness {

    private static PlayerBusiness playerBusiness = null;
    public String response_server = null;
    private ServerInstanceBusiness serverInstance = ServerInstanceBusiness.getInstance();

    private PlayerBusiness() {
    }

    public static PlayerBusiness getInstance() {
        if (playerBusiness == null) {
            playerBusiness = new PlayerBusiness();
        }
        return playerBusiness;
    }

    public String create_game(String hash) {
        serverInstance.SOCKET.emit("create_game", hash);
        while (response_server == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        String aux = response_server;
        response_server = null;
        return aux;
    }

    public String join_game(String hash) {
        serverInstance.SOCKET.emit("join_game", hash);
        while (response_server == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        String aux = response_server;
        response_server = null;
        return aux;
    }

    /**
     * @param rival is composed of identifier (master or guest) more code (hash).
     * @param move
     * @return
     */
    public String do_play(String rival, JSONObject move) {
        serverInstance.SOCKET.emit("do_play", rival, move);
        while (response_server == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        String aux = response_server;
        response_server = null;
        return aux;
    }

    public String updateGame(String hash) {
        return null;
    }
}
