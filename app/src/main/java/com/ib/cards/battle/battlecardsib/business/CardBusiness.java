package com.ib.cards.battle.battlecardsib.business;

import com.ib.cards.battle.battlecardsib.R;
import com.ib.cards.battle.battlecardsib.domain.Card;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Bruno on 06/03/2017.
 */

public class CardBusiness {
    private int[] energyCards = {50, 52, 70, 60, 47, 38, };
    private Card generateCard(int category){
        Card card = new Card();
        return null;
    }
    private int getRandomNumber(int qtt){
        Random gerador = new Random();

        return gerador.nextInt(qtt);
    }

    public Card getCard(String nome){
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("Human", "Lara", "", 50, 85, 0, 20, R.drawable.warrior, 1));
        cards.add(new Card("Human", "Genges", "", 52, 80, 0, 22, R.drawable.warrior, 1));
        cards.add(new Card("Elf", "Lucian", "", 70, 120, 11, 25, R.drawable.warrior, 1));
        cards.add(new Card("Elf", "Remina", "", 65, 100, 11, 20, R.drawable.warrior, 1));
        cards.add(new Card("Dwarf", "Moiza", "", 47, 55, 0, 15, R.drawable.warrior, 1));
        cards.add(new Card("Dwarf", "Nuan", "", 38, 63, 0, 12, R.drawable.warrior, 1));
        cards.add(new Card("Troll", "Miza", "", 90, 40, 0, 21, R.drawable.warrior, 1));
        cards.add(new Card("Troll", "Muriel", "", 91, 30, 0, 22, R.drawable.warrior, 1));
        cards.add(new Card("Gargula", "Górgon", "", 72, 30, 5, 30, R.drawable.warrior, 1));
        cards.add(new Card("Gargula", "Glenda", "", 63, 25, 5, 28, R.drawable.warrior, 1));
        cards.add(new Card("Vampire", "Wilian", "", 80, 500, 7, 30, R.drawable.warrior, 1));
        cards.add(new Card("Vampire", "Rebeka", "", 82, 400, 7, 30, R.drawable.warrior, 1));
        cards.add(new Card("Orc", "Carmin", "", 100, 200, 0, 50, R.drawable.warrior, 1));
        cards.add(new Card("Orc", "Conda", "", 93, 180, 0, 40, R.drawable.warrior, 1));
        cards.add(new Card("Mage", "Merlin", "", 60, 85, 30, 15, R.drawable.warrior, 1));
        cards.add(new Card("Mage", "Nazan", "", 63, 80, 20, 23, R.drawable.warrior, 1));
        for (Card card : cards) {
            if(card.getName().equalsIgnoreCase(nome))
                return card;
        }
        return null;
    }

    public ArrayList<Card> getCards(){
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("Human", "Lara", "", 50, 85, 0, 20, R.drawable.warrior, 1));
        cards.add(new Card("Human", "Genges", "", 52, 80, 0, 22, R.drawable.warrior, 1));
        cards.add(new Card("Elf", "Lucian", "", 70, 120, 11, 25, R.drawable.warrior, 1));
        cards.add(new Card("Elf", "Remina", "", 65, 100, 11, 20, R.drawable.warrior, 1));
        cards.add(new Card("Dwarf", "Moiza", "", 47, 55, 0, 15, R.drawable.warrior, 1));
        cards.add(new Card("Dwarf", "Nuan", "", 38, 63, 0, 12, R.drawable.warrior, 1));
        cards.add(new Card("Troll", "Miza", "", 90, 40, 0, 21, R.drawable.warrior, 1));
        cards.add(new Card("Troll", "Muriel", "", 91, 30, 0, 22, R.drawable.warrior, 1));
        cards.add(new Card("Gargula", "Górgon", "", 72, 30, 5, 30, R.drawable.warrior, 1));
        cards.add(new Card("Gargula", "Glenda", "", 63, 25, 5, 28, R.drawable.warrior, 1));
        cards.add(new Card("Vampire", "Wilian", "", 80, 500, 7, 30, R.drawable.warrior, 1));
        cards.add(new Card("Vampire", "Rebeka", "", 82, 400, 7, 30, R.drawable.warrior, 1));
        cards.add(new Card("Orc", "Carmin", "", 100, 200, 0, 50, R.drawable.warrior, 1));
        cards.add(new Card("Orc", "Conda", "", 93, 180, 0, 40, R.drawable.warrior, 1));
        cards.add(new Card("Mage", "Merlin", "", 60, 85, 30, 15, R.drawable.warrior, 1));
        cards.add(new Card("Mage", "Nazan", "", 63, 80, 20, 23, R.drawable.warrior, 1));
        ArrayList<Card> cardsReturn = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            int index = getRandomNumber(cards.size());
            cardsReturn.add(cards.get(index));
            cards.remove(index);
        }
        return cardsReturn;
    }
}
