package com.ib.cards.battle.battlecardsib;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ib.cards.battle.battlecardsib.domain.Card;

/**
 * Created by iago on 03/03/17.
 */

public class Util {

    public static View adaptCardToView(View view, Card card) {
        LinearLayout mCardImageView = (LinearLayout) view.findViewById(R.id.ll_card_image);
        TextView mCardName = (TextView) view.findViewById(R.id.tv_card_name);
        TextView mCardDescription = (TextView) view.findViewById(R.id.tv_card_description);
        TextView mCardHP = (TextView) view.findViewById(R.id.tv_hp);
        TextView mCardEnergy = (TextView) view.findViewById(R.id.tv_energy);
        TextView mCardPower = (TextView) view.findViewById(R.id.tv_power);

        mCardName.setText(card.getName());
        mCardDescription.setText(card.getDescription());
        mCardHP.setText(Integer.toString(card.getHp()));
        mCardEnergy.setText(Integer.toString(card.getEnergy()));
        mCardPower.setText(Integer.toString(card.getPower()));
        mCardImageView.setBackgroundResource(card.getImage());
        return view;
    }
}
