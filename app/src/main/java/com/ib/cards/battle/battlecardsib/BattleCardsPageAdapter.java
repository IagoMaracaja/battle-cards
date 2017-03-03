package com.ib.cards.battle.battlecardsib;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gigamole.infinitecycleviewpager.VerticalInfiniteCycleViewPager;

import java.util.ArrayList;

/**
 * Created by iago on 24/02/17.
 */

public class BattleCardsPageAdapter extends PagerAdapter {

    private static final int NUM_ITEMS = 9;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Card> mCards;

    public BattleCardsPageAdapter(final Context context, final ArrayList<Card> cards) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mCards = cards;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return mCards.size();
    }


    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view;

            view = mLayoutInflater.inflate(R.layout.card_item2, container, false);
            Card card = mCards.get(position);

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

    public View adaptCardToView(View view, Card card){
        LinearLayout mCardView = (LinearLayout) view.findViewById(R.id.ll_card_image);
        TextView mCardName = (TextView) view.findViewById(R.id.tv_card_name);
        TextView mCardDescription = (TextView) view.findViewById(R.id.tv_card_description);
        TextView mCardHP = (TextView) view.findViewById(R.id.tv_hp);
        TextView mCardEnergy = (TextView) view.findViewById(R.id.tv_energy);
        TextView mCardPower = (TextView) view.findViewById(R.id.tv_power);

        mCardName.setText(card.getName());
        mCardDescription.setText(card.getDescription());
        mCardHP.setText(card.getHp());
        mCardEnergy.setText(card.getEnergy());
        mCardPower.setText(card.getPower());
        return view;
    }

}

