package com.ib.cards.battle.battlecardsib.socket;

import io.socket.client.Socket;

/**
 * Created by Bruno on 02/03/2017.
 */

public class ServerInstanceBusiness {
    public Socket SOCKET = ServerSocket.getServerSocketInstance();
    private SocketCallbacksListener socketCallbacks = new SocketCallbacksListener();
    private static ServerInstanceBusiness serverInstanceBusiness = null;

    /**
     * Constructor method
     */
    private ServerInstanceBusiness(){

        SOCKET.on(Socket.EVENT_CONNECT, socketCallbacks.onConnect);
        SOCKET.on(Socket.EVENT_CONNECT_ERROR, socketCallbacks.onConnectError);
        SOCKET.on(Socket.EVENT_RECONNECT, socketCallbacks.onReconnect);

        SOCKET.on("game_created", socketCallbacks.onGameCreated);
        SOCKET.on("player_join", socketCallbacks.onPlayJoin);
        SOCKET.on("played_finish", socketCallbacks.onPlayedFinish);
        SOCKET.on("update_game", socketCallbacks.onUpdateGame);

        SOCKET.connect();
    }

    public static ServerInstanceBusiness getInstance() {
        if(serverInstanceBusiness==null){
            serverInstanceBusiness = new ServerInstanceBusiness();
        }
        return serverInstanceBusiness;
    }
}
