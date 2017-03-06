package com.ib.cards.battle.battlecardsib;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ib.cards.battle.battlecardsib.business.Constants;
import com.ib.cards.battle.battlecardsib.business.PlayerBusiness;
import com.ib.cards.battle.battlecardsib.domain.Attack;
import com.ib.cards.battle.battlecardsib.socket.ServerInstanceBusiness;

public class MainActivity extends AppCompatActivity {

    protected Button mCreateNewGame;
    protected Button mJoinGame;
    private AlertDialog mAlertDialog;
    private Dialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.instantiate();
    }

    /**
     * Open a dialog to show an alert code entries
     */
    private void openJoinDialog() {

        if (mAlertDialog == null) {
            LayoutInflater li = getLayoutInflater();

            View view = li.inflate(R.layout.layout_join_game, null);
            final EditText code = (EditText) view.findViewById(R.id.et_code);
            Button join = (Button) view.findViewById(R.id.btn_join);

            final LinearLayout layoutError = (LinearLayout) view.findViewById(R.id.ll_error_join);
            final TextView errorMessage = (TextView) view.findViewById(R.id.error_message);

            view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    mAlertDialog.dismiss();
                    mAlertDialog = null;
                }
            });

            join.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ServerInstanceBusiness serverInstanceBusiness = ServerInstanceBusiness.getInstance();
                    PlayerBusiness playerBusiness = PlayerBusiness.getInstance();
                    playerBusiness.join_game(Constants.HASH_TEST);
                    playerBusiness.do_play(Constants.MASTER+Constants.HASH_TEST, new Attack().parseToJson(Constants.attackGuest));

                    if (checkCode(code.getText().toString())) {
                        Toast.makeText(MainActivity.this, "Você entrará no jogo..so que agora nao :D",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        layoutError.setVisibility(View.VISIBLE);
                        errorMessage.setText(getString(R.string.code_blank_error));
                    }
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


    /**
     * check code constraints
     *
     * @param code
     * @return
     */
    public boolean checkCode(final String code) {
        if (code.equals("")) {
            return false;
        }
        return true;
    }


    /**
     * init components of view
     */
    private void instantiate() {
        Typeface fallenSpartans = Typeface.createFromAsset(getAssets(), "fonts/FallenSpartans-Regular.otf");

        TextView appName = (TextView) findViewById(R.id.tv_app_name);
        appName.setTypeface(fallenSpartans);

        mCreateNewGame = (Button) findViewById(R.id.ll_create);
        mCreateNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogAlpha(null);
                PlayerBusiness playerBusiness = PlayerBusiness.getInstance();
                playerBusiness.create_game(Constants.HASH_TEST);
                Intent sendToBattleActivity = new Intent(MainActivity.this, BattleActivity.class);
                startActivity(sendToBattleActivity);
                /*new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        Intent sendToBattleActivity = new Intent(MainActivity.this, BattleActivity.class);
                        startActivity(sendToBattleActivity);

                    }
                }.start();*/

            }
        });
        mJoinGame = (Button) findViewById(R.id.ll_join);
        mJoinGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJoinDialog();
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * open dialog
     */
    public void openDialogAlpha(final String message) {

        mProgressDialog = new Dialog(this, R.style.cust_dialog);
        mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mProgressDialog.setContentView(R.layout.layout_progress);

        if (message != null) {
            TextView tx = (TextView) mProgressDialog.findViewById(R.id.tv_progress_message);
            tx.setText(message);
        }

        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

    }

    private void closeDialogAlpha() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
            mProgressDialog = null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // Codigo temporario para fechar o progress dialog
        closeDialogAlpha();
    }
}
