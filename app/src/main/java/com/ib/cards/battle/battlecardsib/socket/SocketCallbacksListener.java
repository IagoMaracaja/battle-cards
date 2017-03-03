package com.ib.cards.battle.battlecardsib.socket;

import android.util.Log;

import com.ib.cards.battle.battlecardsib.business.Constants;
import com.ib.cards.battle.battlecardsib.business.PlayerBusiness;
import com.ib.cards.battle.battlecardsib.domain.Attack;

import org.json.JSONObject;

import io.socket.emitter.Emitter;

/**
 * Created by Bruno on 02/03/2017.
 */

public class SocketCallbacksListener {


    public Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.d("meulog", "Conectou-se");
        }
    };
    public Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.d("meulog", args[0]+"");
        }
    };
    public Emitter.Listener onReconnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
        }
    };


    public Emitter.Listener onGameCreated = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            PlayerBusiness.getInstance().response_server = args[0]+"";
        }
    };

    public Emitter.Listener onPlayJoin = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            PlayerBusiness.getInstance().response_server = args[0]+"";
        }
    };

    public Emitter.Listener onPlayedFinish = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            PlayerBusiness.getInstance().response_server = args[0]+"";
            Log.d("Log", "Jogada feita");
        }
    };

    public Emitter.Listener onUpdateGame = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Attack attack = new Attack().parseToAttack((JSONObject) args[0]);
            Log.d("AQUI", attack.getName());
        }
    };
}
