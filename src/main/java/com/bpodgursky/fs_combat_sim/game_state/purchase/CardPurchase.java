package com.bpodgursky.fs_combat_sim.game_state.purchase;

import java.util.Set;

import com.bpodgursky.fs_combat_sim.game_state.Card;
import com.bpodgursky.fs_combat_sim.game_state.PlayerState;
import com.google.common.collect.Sets;

public class CardPurchase implements Purchase{

  private final Card toBuy;
  private final Card toReplace;

  protected CardPurchase(Card toBuy, Card toReplace){
    this.toBuy = toBuy;
    this.toReplace = toReplace;
  }

  public PlayerState apply(PlayerState inputState) {

    Set<Card> cardsInHand = Sets.newHashSet(inputState.getCardsInHand());

    if(!cardsInHand.contains(toReplace)){
      throw new IllegalArgumentException();
    }

    cardsInHand.remove(toReplace);

    int cities = inputState.getNumCities();
    int commandLevel = toBuy.getCommandLevel();

    if(commandLevel > cities){
      throw new IllegalArgumentException();
    }

    cardsInHand.add(toBuy);

    return new PlayerState(
        inputState.getPlayer(),
        inputState.getMaterial() - toBuy.getCost(),
        inputState.getNumCities(),
        inputState.getNumUnresolvedTokens(),
        inputState.getUnits(),
        inputState.getResolvedTokens(),
        cardsInHand
    );

  }
}
