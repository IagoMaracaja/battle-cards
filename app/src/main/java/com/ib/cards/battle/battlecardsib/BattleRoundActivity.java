package com.ib.cards.battle.battlecardsib;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ib.cards.battle.battlecardsib.domain.Card;
import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class BattleRoundActivity extends AppCompatActivity {


    private static final int FULL = 100;
    private ProgressBar mHPProgressOp;
    private ProgressBar mHPProgressMe;
    private ProgressBar mEnergyProgressOp;
    private ProgressBar mEnergyProgressMe;

    private TextView mOpPlayerName;
    private TextView mMyPlayerName;

    /*
        My Attributes
     */
    private TextView mTvTotalHpMe;
    private TextView mTvActualHpMe;
    private TextView mTvActualEnergyMe;
    private TextView mTvTotalEnergyMe;
    /*
        Opponents Attributes
     */
    private TextView mTvTotalHpOp;
    private TextView mTvActualHpOp;
    private TextView mTvActualEnergyOp;
    private TextView mTvTotalEnergyOp;


    private int mMyTotalHP;
    private int mOpTotalHP;

    private boolean alreadyUseCureSpell;
    private boolean alreadyUseEnergySpell;


    private Card mOpCard;
    private Card mMyCard;
    private int mOpTotalEnergy;
    private int mMyTotalEnergy;
    private AlertDialog mAlertDialog;
    private Dialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_round2);

        instantiate();


    }

    /**
     * init components views.
     */
    private void instantiate() {
        mHPProgressOp = (ProgressBar) findViewById(R.id.progressBarHPOpponent);
        mHPProgressMe = (ProgressBar) findViewById(R.id.progressBarHPMe);
        mEnergyProgressOp = (ProgressBar) findViewById(R.id.progressBarEnergyOpponent);
        mEnergyProgressMe = (ProgressBar) findViewById(R.id.progressBarEnergyMe);

        mOpPlayerName = (TextView) findViewById(R.id.tv_op_player_name);
        mMyPlayerName = (TextView) findViewById(R.id.tv_my_player_name);

        mTvTotalHpMe = (TextView) findViewById(R.id.tv_total_hp_my);
        mTvActualHpMe = (TextView) findViewById(R.id.tv_actual_hp_my);
        mTvTotalEnergyMe = (TextView) findViewById(R.id.tv_total_energy_my);
        mTvActualEnergyMe = (TextView) findViewById(R.id.tv_actual_energy_my);

        mTvTotalHpOp = (TextView) findViewById(R.id.tv_total_hp_op);
        mTvActualHpOp = (TextView) findViewById(R.id.tv_actual_hp_op);
        mTvActualEnergyOp = (TextView) findViewById(R.id.tv_actual_energy_op);
        mTvTotalEnergyOp = (TextView) findViewById(R.id.tv_total_energy_op);

        mHPProgressOp.setProgress(FULL);
        mHPProgressMe.setProgress(FULL);
        mEnergyProgressOp.setProgress(FULL);
        mEnergyProgressMe.setProgress(FULL);

        Bundle b = getIntent().getExtras();
        mMyCard = (Card) b.get("card");
        mOpCard = (Card) b.get("card");

        this.mMyTotalHP = mMyCard.getHp();
        mTvTotalHpMe.setText(Integer.toString(mMyTotalHP));
        mTvActualHpMe.setText(Integer.toString(mMyTotalHP));

        this.mOpTotalHP = mOpCard.getHp();
        mTvTotalHpOp.setText(Integer.toString(mOpTotalHP));
        mTvActualHpOp.setText(Integer.toString(mOpTotalHP));

        this.mMyTotalEnergy = mOpCard.getEnergy();
        mTvTotalEnergyMe.setText(Integer.toString(mMyTotalEnergy));
        mTvActualEnergyMe.setText(Integer.toString(mMyTotalEnergy));

        this.mOpTotalEnergy = mOpCard.getEnergy();
        mTvTotalEnergyOp.setText(Integer.toString(mOpTotalEnergy));
        mTvActualEnergyOp.setText(Integer.toString(mOpTotalEnergy));

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View opponentCardView = inflater.inflate(R.layout.card_item2_mini, null);
        View myCardView = inflater.inflate(R.layout.card_item2_mini, null);

        opponentCardView = Util.adaptCardToView(opponentCardView, mOpCard);
        myCardView = Util.adaptCardToView(myCardView, mMyCard);

        LinearLayout layoutOpponent = (LinearLayout) findViewById(R.id.ll_card_opponent);
        LinearLayout layoutMyCard = (LinearLayout) findViewById(R.id.ll_my_card);

        layoutOpponent.addView(opponentCardView, 0);
        layoutMyCard.addView(myCardView, 0);

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circleMenu);
        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenuButton menuButton) {
                switch (menuButton.getId()) {
                    case R.id.attack:
                        doAttack();
                        break;
                    case R.id.magic:
                        doMagicAttack();
                        break;
                    case R.id.fab_cure:
                        if (!alreadyUseCureSpell) {
                            doCure();
                            alreadyUseCureSpell = true;
                        }
                        break;
                    case R.id.fab_energy:
                        if (!alreadyUseEnergySpell) {
                            doEnergy();
                            alreadyUseEnergySpell = true;
                        }
                        break;
                    default:
                        break;
                }
            }

        });


    }


    private void doAttack() {
        int power = this.mMyCard.getPower();
        int opHP = this.mOpCard.getHp();
        int hpResult = opHP - power;
        int energyResult = this.mMyCard.getEnergy() - 1;
        mOpCard.setHp(hpResult);
        mMyCard.setEnergy(energyResult);

        updateHPProgress(hpResult, false);
        updateEnergyProgress(energyResult, true);

        if (hpResult <= 0) {
            victory();
        }
    }

    private void doMagicAttack() {
        int power = this.mMyCard.getMagic();
        int opHP = this.mOpCard.getHp();
        int hpResult = opHP - power;
        int energyResult = this.mMyCard.getEnergy() - 3; // apenas test
        mOpCard.setHp(hpResult);
        mMyCard.setEnergy(energyResult);

        updateHPProgress(hpResult, false);
        updateEnergyProgress(energyResult, true);

        if (hpResult <= 0) {
            victory();
        }
    }

    private void updateHPProgress(int hpProgressValue, boolean isMyHP) {
        int progressHP = 0;

        if (isMyHP) {
            if (hpProgressValue > mMyTotalHP) {
                progressHP = FULL;
            } else if (hpProgressValue > 0) {
                progressHP = (hpProgressValue * 100) / mMyTotalHP;
                this.mTvActualHpMe.setText(Integer.toString(hpProgressValue));
            } else {
                progressHP = 0;
                this.mTvActualHpMe.setText("0");
            }
            this.mHPProgressMe.setProgress(progressHP);
        } else {
            if (hpProgressValue > mOpTotalHP) {
                progressHP = FULL;
            } else if (hpProgressValue > 0) {
                progressHP = (hpProgressValue * 100) / mOpTotalHP;
                this.mTvActualHpOp.setText(Integer.toString(hpProgressValue));
            } else {
                progressHP = 0;
                this.mTvActualHpOp.setText("0");
            }

            this.mHPProgressOp.setProgress(progressHP);
        }
    }

    private void updateEnergyProgress(int energyProgressValue, boolean isMyHP) {
        int progressEnergy = 0;

        if (isMyHP) {
            if (energyProgressValue > mMyTotalEnergy) {
                progressEnergy = FULL;
            } else if (energyProgressValue > 0) {
                progressEnergy = (energyProgressValue * 100) / mMyTotalEnergy;
                this.mTvActualEnergyMe.setText(Integer.toString(energyProgressValue));
            } else {
                progressEnergy = 0;
                this.mTvActualEnergyMe.setText("0");
            }
            this.mEnergyProgressMe.setProgress(progressEnergy);
        } else {
            if (energyProgressValue > mOpTotalEnergy) {
                progressEnergy = FULL;
            } else if (energyProgressValue > 0) {
                progressEnergy = (energyProgressValue * 100) / mOpTotalEnergy;
                this.mTvActualEnergyOp.setText(Integer.toString(energyProgressValue));
            } else {
                progressEnergy = 0;
                this.mTvActualEnergyOp.setText("0");
            }

            this.mEnergyProgressOp.setProgress(progressEnergy);
        }
    }

    @Override
    public void onBackPressed() {
        openDialogToLeftRoom();
        //super.onBackPressed();
    }

    /**
     * Open a dialog to show an alert code entries
     */
    private void openDialogToLeftRoom() {

        if (mAlertDialog == null) {
            LayoutInflater li = getLayoutInflater();

            View view = li.inflate(R.layout.layout_left_game, null);
            Button okBtn = (Button) view.findViewById(R.id.btn_ok);

            final LinearLayout layoutError = (LinearLayout) view.findViewById(R.id.ll_error_join);
            final TextView errorMessage = (TextView) view.findViewById(R.id.error_message);

            view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    defeat();

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

    private void doCure() {
        int actualHp = Integer.parseInt(mTvActualHpMe.getText().toString());
        actualHp += 3;
        mTvActualHpMe.setText(Integer.toString(actualHp));
        if (actualHp > mMyTotalHP) {
            actualHp = mMyTotalHP;
        }
        mMyCard.setHp(actualHp);
        updateHPProgress(actualHp, true);

        int actualEnergy = Integer.parseInt(mTvActualEnergyMe.getText().toString());
        actualEnergy -= 3;
        if (actualEnergy <= 0) {
            actualEnergy = 0;
        }
        mTvActualEnergyMe.setText(Integer.toString(actualEnergy));
        mMyCard.setEnergy(actualEnergy);
        updateEnergyProgress(actualEnergy, true);

    }

    private void doEnergy() {
        int actualHp = Integer.parseInt(mTvActualHpMe.getText().toString());
        actualHp -= 3;
        if (actualHp <= 0) {
            actualHp = 0;
        }
        mTvActualHpMe.setText(Integer.toString(actualHp));
        mMyCard.setHp(actualHp);
        updateHPProgress(actualHp, true);

        int actualEnergy = Integer.parseInt(mTvActualEnergyMe.getText().toString());
        actualEnergy += 3;
        if (actualEnergy > mMyTotalEnergy) {
            actualEnergy = mMyTotalEnergy;
        }
        mTvActualEnergyMe.setText(Integer.toString(actualEnergy));
        updateEnergyProgress(actualEnergy, true);
    }

    private void victory() {
        openDialogBattleResults(null, true);
    }

    private void defeat() {
        super.onBackPressed();
    }

    /**
     * open dialog
     */
    public void openDialogBattleResults(final String message, boolean isVictory) {

        mProgressDialog = new Dialog(this, R.style.cust_dialog);
        mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mProgressDialog.setContentView(R.layout.layout_victory);

        ShimmerTextView tx = (ShimmerTextView) mProgressDialog.findViewById(R.id.message_results);
        if (message != null) {
            tx.setText(message);
        }

        Button btnOk = (Button) mProgressDialog.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BattleRoundActivity.super.onBackPressed();
            }
        });

        Shimmer shimmer = new Shimmer();
        shimmer.start(tx);

        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

    }

    private void closeDialogBattleResults() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
            mProgressDialog = null;
        }
    }

    private void receiveMagicAttack(int magicPower, int energy){
        int myHp = this.mMyCard.getHp();
        int hpResult = myHp - magicPower;

        mOpCard.setHp(hpResult);
        mMyCard.setEnergy(energy);

        updateHPProgress(hpResult, true);
        updateEnergyProgress(energy, false);

        if (hpResult <= 0) {
            defeat();
        }
    }

    private void receiveNormalAttack(int power, int energy){
        int myHp = this.mMyCard.getHp();
        int hpResult = myHp - power;

        mOpCard.setHp(hpResult);
        mMyCard.setEnergy(energy);

        updateHPProgress(hpResult, true);
        updateEnergyProgress(energy, false);

        if (hpResult <= 0) {
            defeat();
        }
    }

}
