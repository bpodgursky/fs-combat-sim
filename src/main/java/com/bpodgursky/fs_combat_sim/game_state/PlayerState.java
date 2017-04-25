package com.bpodgursky.fs_combat_sim.game_state;

import java.util.Set;

public class PlayerState {

  //  units

  //  cities

  private final int numCities;

  //  cards in hand
  private final Set<Card> cardsInHand;

  public PlayerState(int numCities, Set<Card> cardsInHand) {
    this.numCities = numCities;
    this.cardsInHand = cardsInHand;
  }

}
