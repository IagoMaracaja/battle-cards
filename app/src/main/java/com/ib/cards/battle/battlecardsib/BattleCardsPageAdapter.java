package com.ib.cards.battle.battlecardsib;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;

/**
 * Created by iago on 24/02/17.
 */

public class BattleCardsPageAdapter extends PagerAdapter {

    private static final int NUM_ITEMS = 9;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public BattleCardsPageAdapter(final Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);

    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }


    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view;

            view = mLayoutInflater.inflate(R.layout.card_item2, container, false);

            /*final VerticalInfiniteCycleViewPager verticalInfiniteCycleViewPager =
                    (VerticalInfiniteCycleViewPager) view.findViewById(R.id.viewpager);
            verticalInfiniteCycleViewPager.setAdapter(
                    new VerticalPagerAdapter(mContext)
            );
            verticalInfiniteCycleViewPager.setCurrentItem(position);*/


        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }

}

