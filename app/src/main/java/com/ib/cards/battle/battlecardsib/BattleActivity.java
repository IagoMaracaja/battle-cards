package com.ib.cards.battle.battlecardsib;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

public class BattleActivity extends AppCompatActivity {
    BattleCardsPageAdapter adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        final HorizontalInfiniteCycleViewPager infiniteCycleViewPager =
                (HorizontalInfiniteCycleViewPager) findViewById(R.id.viewpager);

        adapterViewPager = new BattleCardsPageAdapter(this);
        infiniteCycleViewPager.setAdapter(adapterViewPager);
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
