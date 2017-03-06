package com.ib.cards.battle.battlecardsib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.ib.cards.battle.battlecardsib.business.CardBusiness;
import com.ib.cards.battle.battlecardsib.domain.Card;

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
        CardBusiness cardBusiness = new CardBusiness();

        return cardBusiness.getCards();
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
