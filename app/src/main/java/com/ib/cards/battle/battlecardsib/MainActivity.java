package com.ib.cards.battle.battlecardsib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mCreateNewGame = (LinearLayout) findViewById(R.id.ll_create);
        mCreateNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToBattleActivity = new Intent(MainActivity.this, BattleActivity.class);
                startActivity(sendToBattleActivity);
            }
        });
    }
}
