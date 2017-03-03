package com.ib.cards.battle.battlecardsib;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    // Animation
    Animation animFadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Typeface fallenSpartans = Typeface.createFromAsset(getAssets(), "fonts/FallenSpartans-Regular.otf");

        TextView appName = (TextView) findViewById(R.id.tv_app_name);
        appName.setTypeface(fallenSpartans);
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim_fade_in);

        new CountDownTimer(4000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                Intent sendToMain = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(sendToMain);
                overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);
                SplashScreenActivity.this.finish();
            }

        }.start();
    }
}
