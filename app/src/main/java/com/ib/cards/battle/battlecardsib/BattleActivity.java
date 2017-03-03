package com.ib.cards.battle.battlecardsib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {
    BattleCardsPageAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        final HorizontalInfiniteCycleViewPager infiniteCycleViewPager =
                (HorizontalInfiniteCycleViewPager) findViewById(R.id.viewpager);

        adapterViewPager = new BattleCardsPageAdapter(this, generateMockItens());
        infiniteCycleViewPager.setAdapter(adapterViewPager);


    }


    public ArrayList<Card> generateMockItens(){
        ArrayList<Card> cards = new ArrayList<>();

        for (int i = 0; i < 9; i++){
            Card card = new Card();
            card.setCategory("");
            card.setDescription("");
            card.setEnergy(i+i);
            card.setHp(i+1);
            card.setLevel(i);
            card.setMagic("");
            card.setName("Card 0" +i);
            card.setPower(i*2);
            card.setImage(R.drawable.warrior);
            cards.add(card);
        }

        return cards;
    }


    /*public void initViewPager(){
        final HorizontalInfiniteCycleViewPager infiniteCycleViewPager =
                (HorizontalInfiniteCycleViewPager) findViewById(R.id.viewpager);
        infiniteCycleViewPager.setAdapter(...);
        infiniteCycleViewPager.setScrollDuration(500);
        infiniteCycleViewPager.setInterpolator();
        infiniteCycleViewPager.setMediumScaled(true);
        infiniteCycleViewPager.setMaxPageScale(0.8F);
        infiniteCycleViewPager.setMinPageScale(0.5F);
        infiniteCycleViewPager.setCenterPageScaleOffset(30.0F);
        infiniteCycleViewPager.setMinPageScaleOffset(5.0F);
        infiniteCycleViewPager.setOnInfiniteCyclePageTransformListener(...);
    }*/
}
