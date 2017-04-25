package com.bpodgursky.fs_combat_sim.game_state;

import java.util.Map;
import java.util.Set;

public class PlayerState {

  private final Player player;

  private final Map<Unit, Integer> units;

  private final int numCities;

  private final int material;

  private final Set<Card> cardsInHand;

  private final int numTokens;

  public PlayerState(Player player, int material, int numCities, int numTokens, Map<Unit, Integer> units, Set<Card> cardsInHand) {

    if(material < 0){
      throw new IllegalArgumentException();
    }

    if(numTokens < 0){
      throw new IllegalArgumentException();
    }

    for (Unit unit : units.keySet()) {
      if(!FactionUnits.UNITS.get(player.getFaction()).contains(unit)){
        throw new IllegalArgumentException();
      }
    }

    this.material = material;
    this.player = player;
    this.numCities = numCities;
    this.cardsInHand = cardsInHand;
    this.units = units;
  }

  public Player getPlayer() {
    return player;
  }

  public Map<Unit, Integer> getUnits() {
    return units;
  }

  public int getNumTokens(){
    return numTokens;
  }

  public int getNumCities() {
    return numCities;
  }

  public Set<Card> getCardsInHand() {
    return cardsInHand;
  }

  public int getMaterial() {
    return material;
  }
}
