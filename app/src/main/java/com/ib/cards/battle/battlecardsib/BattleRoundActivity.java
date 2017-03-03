package com.ib.cards.battle.battlecardsib;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class BattleRoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_round);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View opponentView = inflater.inflate(R.layout.card_item2, null);
        View myView = inflater.inflate(R.layout.card_item2, null);
        LinearLayout layoutOpponent = (LinearLayout) findViewById(R.id.ll_card_opponent);
        LinearLayout layoutMyCard = (LinearLayout) findViewById(R.id.ll_my_card);
        layoutOpponent.addView(opponentView, 0);
        layoutMyCard.addView(myView, 0);

    }
}
