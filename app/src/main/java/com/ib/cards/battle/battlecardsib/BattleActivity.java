package com.ib.cards.battle.battlecardsib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.ib.cards.battle.battlecardsib.business.CardBusiness;
import com.ib.cards.battle.battlecardsib.business.Constants;
import com.ib.cards.battle.battlecardsib.domain.Card;
import com.ib.cards.battle.battlecardsib.socket.ServerInstanceBusiness;

import java.util.ArrayList;

import io.socket.emitter.Emitter;

import static com.ib.cards.battle.battlecardsib.business.Constants.FROM_JOIN;
import static com.ib.cards.battle.battlecardsib.business.Constants.HASH_KEY;
import static com.ib.cards.battle.battlecardsib.business.Constants.OFFLINE_STATUS;
import static com.ib.cards.battle.battlecardsib.business.Constants.ONLINE_STATUS;
import static com.ib.cards.battle.battlecardsib.business.Constants.READY_STATUS;

public class BattleActivity extends AppCompatActivity {
    BattleCardsPageAdapter adapterViewPager;
    private Button mButtonReady;

    private TextView mMyUserName;
    private TextView mMyUserStatus;
    private TextView mOpponentUserName;
    private TextView mOpponentUserStatus;
    private TextView mRoomName;

    private boolean isReady;
    private boolean isOpponentReady;
    private AlertDialog mAlertDialog;
    private boolean isFromJoin;

    private LinearLayout mLlOpponentView;

    private String mRoomHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mRoomHash = bundle.getString(HASH_KEY);
            isFromJoin = (boolean) bundle.get(FROM_JOIN);

        } else {
            mRoomHash = "No room name";
        }
        Log.d("xyz", "Iniciando onCreate do BattleActivity");
        initComponents();

    }

    /**
     * init view components
     */
    private void initComponents() {


        // Init Text viewers
        this.mMyUserName = (TextView) findViewById(R.id.tv_my_user_name);
        this.mMyUserStatus = (TextView) findViewById(R.id.tv_my_user_status);

        this.mRoomName = (TextView) findViewById(R.id.tv_room_name);
        mRoomName.setText(mRoomHash);

        this.mOpponentUserName = (TextView) findViewById(R.id.tv_opponent_user_name);
        this.mOpponentUserStatus = (TextView) findViewById(R.id.tv_opponent_user_status);

        this.mLlOpponentView = (LinearLayout) findViewById(R.id.ll_opponent_view);
        if(!isFromJoin){
            showHideNewUser(false);
        }

        this.mButtonReady = (Button) findViewById(R.id.btn_ready);
        this.mButtonReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("xyz", "Acionei o botão, o status está: " + isReady);
                if (!isReady) {
                    mButtonReady.setBackgroundResource(R.drawable.shape_button_inactive);
                    mButtonReady.setClickable(false);
                    isReady = true;
                    mMyUserStatus.setText(getString(R.string.ready));
                    ServerInstanceBusiness.getInstance().SOCKET.emit("send_status", Constants.RIVAL, READY_STATUS);
                    if (isOpponentReady) {
                        Log.d("xyz", "Estou iniciando o viewpager");
                        initViewPager();
                    }
                }
            }
        });
        if (isFromJoin) {
            mButtonReady.setVisibility(View.VISIBLE);
        }
        ServerInstanceBusiness.getInstance().SOCKET.on("receive_status", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                final String status = (String) args[0];

                switch (status) {

                    case READY_STATUS:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Log.d("xyz", "Recebi um status do socket: " + status);
                                isOpponentReady = true;
                                mOpponentUserStatus.setText(getString(R.string.ready));
                                if (isReady) {
                                    Log.d("xyz", "Iniciando viewpager a partir do runOnUiThread");
                                    initViewPager();
                                }

                            }

                        });

                        break;
                    case ONLINE_STATUS:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Log.d("xyz", "Recebi um status do socket: " + status);
                                showHideNewUser(true);
                                mButtonReady.setVisibility(View.VISIBLE);
                                mOpponentUserStatus.setText(getString(R.string.default_status));
                            }
                        });

                        break;
                    case OFFLINE_STATUS:
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mButtonReady.setVisibility(View.GONE);
                                mOpponentUserStatus.setText(getString(R.string.offline));
                                showHideNewUser(false);
                            }
                        });


                        break;

                    default:

                        break;
                }

            }
        });


    }

    private void initViewPager() {
        // Init viewpager
        final HorizontalInfiniteCycleViewPager infiniteCycleViewPager =
                (HorizontalInfiniteCycleViewPager) findViewById(R.id.viewpager);
        adapterViewPager = new BattleCardsPageAdapter(BattleActivity.this, generateCards());
        infiniteCycleViewPager.setAdapter(adapterViewPager);
    }

    /**
     * Generate cards.
     *
     * @return
     */
    public ArrayList<Card> generateCards() {
        CardBusiness cardBusiness = new CardBusiness();

        return cardBusiness.getCards();
    }

    @Override
    public void onBackPressed() {
        openDialogToLeftRoom();
    }

    /**
     * Open a dialog to show an alert code entries
     */
    private void openDialogToLeftRoom() {

        if (mAlertDialog == null) {
            LayoutInflater li = getLayoutInflater();

            View view = li.inflate(R.layout.layout_left_game, null);
            Button okBtn = (Button) view.findViewById(R.id.btn_ok);

            view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    Intent sendToMain = new Intent(BattleActivity.this, MainActivity.class);
                    sendToMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    ServerInstanceBusiness.getInstance().SOCKET.emit("send_status", Constants.RIVAL, OFFLINE_STATUS);

                    startActivity(sendToMain);
                    ServerInstanceBusiness.getInstance().SOCKET.off("receive_status");

                }
            });

            okBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAlertDialog.dismiss();
                    mAlertDialog = null;

                }
            });

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(view);

            if (!isFinishing()) {
                mAlertDialog = builder.create();
                mAlertDialog.setCancelable(false);
                mAlertDialog.show();
            }
        }
    }

    private void showHideNewUser(final boolean showNewUser){
        if(showNewUser){
            mLlOpponentView.setVisibility(View.VISIBLE);
        }else{
            mLlOpponentView.setVisibility(View.GONE);
        }

    }

}
