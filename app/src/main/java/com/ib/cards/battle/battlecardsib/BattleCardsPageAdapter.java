package com.ib.cards.battle.battlecardsib;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ib.cards.battle.battlecardsib.domain.Card;

import java.util.ArrayList;

/**
 * Created by iago on 24/02/17.
 */

public class BattleCardsPageAdapter extends PagerAdapter {

    private static final int NUM_ITEMS = 9;
    private Activity mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Card> mCards;
    private AlertDialog mAlertDialog;

    public BattleCardsPageAdapter(final Activity context, final ArrayList<Card> cards) {
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
        final Card card = mCards.get(position);

        container.addView(Util.adaptCardToView(view, card));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, BattleRoundActivity.class);
                intent.putExtra("card", card);
                mContext.startActivity(intent);
            }
        });
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

