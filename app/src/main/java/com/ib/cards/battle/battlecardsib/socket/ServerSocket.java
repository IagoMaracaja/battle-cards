package com.ib.cards.battle.battlecardsib.socket;

import android.util.Log;

import com.ib.cards.battle.battlecardsib.business.Constants;

import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by Bruno on 02/03/2017.
 */

public class ServerSocket {

    private static Socket socket = null;

    /**
     * Constructor method
     */
    private  ServerSocket(){
        try{
            socket = IO.socket(Constants.URL_SERVICE);

        }catch (Exception e){
            Log.d("SocketError:", e.getMessage());
            return;
        }
    }

    public static Socket getServerSocketInstance(){
        if(socket==null){
            new ServerSocket();
        }
        return socket;
    }
}
