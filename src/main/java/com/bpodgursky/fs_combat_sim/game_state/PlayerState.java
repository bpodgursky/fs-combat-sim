package com.bpodgursky.fs_combat_sim.game_state;

import java.util.Map;
import java.util.Set;

public class PlayerState {

  //  units
  private final Map<Unit, Integer> units;

  //  cities

  private final int numCities;

  //  cards in hand
  private final Set<Card> cardsInHand;

  public PlayerState(int numCities, Map<Unit, Integer> units, Set<Card> cardsInHand) {
    this.numCities = numCities;
    this.cardsInHand = cardsInHand;
  }

}
