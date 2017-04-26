package com.bpodgursky.fs_combat_sim.game_state;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bpodgursky.fs_combat_sim.game_state.purchase.Purchase;

import com.liveramp.commons.collections.CountingMap;

public class PlayerState {

  private final Player player;

  private final CountingMap<Unit> units;

  private final int numCities;

  private final int material;

  private final Set<Card> cardsInHand;

  private final int numUnresolvedTokens;

  private final CountingMap<Token> resolvedTokens;



  public PlayerState(Player player, int material, int numCities, int numUnresolvedTokens,
                     CountingMap<Unit> units,
                     CountingMap<Token> tokens,
                     Set<Card> cardsInHand) {

    if(material < 0){
      throw new IllegalArgumentException("Insufficient material");
    }

    if(numUnresolvedTokens < 0){
      throw new IllegalArgumentException("Insufficient tokens");
    }

    Map<Unit, Long> unitsMap = units.get();
    for (Unit unit : unitsMap.keySet()) {

      if(!FactionUnits.UNITS.get(player.getFaction()).contains(unit)){
        throw new IllegalArgumentException("Unit for wrong faction");
      }

      if(unit.getMaxCount() < unitsMap.get(unit)){
        throw new IllegalArgumentException("InsufficientPlasticException: #"+unit+" = "+unitsMap.get(unit));
      }

    }

    for (Map.Entry<Token, Long> entry : tokens.get().entrySet()) {

      if(entry.getValue() > 3){
        throw new IllegalArgumentException("Can't have more than 3 of a token");
      }

      if(entry.getValue() < 0){
        throw new IllegalArgumentException("InsufficientCardboardException: "+entry);
      }

    }

    this.numUnresolvedTokens = numUnresolvedTokens;
    this.resolvedTokens = tokens;
    this.material = material;
    this.player = player;
    this.numCities = numCities;
    this.cardsInHand = cardsInHand;
    this.units = units;
  }

  public Player getPlayer() {
    return player;
  }

  public CountingMap<Unit> getUnits() {
    return units;
  }

  public int getNumUnresolvedTokens(){
    return numUnresolvedTokens;
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

  public PlayerState applyAll(List<Purchase> purchases){

    PlayerState updated = this;
    for (Purchase purchase : purchases) {
      updated = purchase.apply(updated);
    }

    return updated;
  }

  public CountingMap<Token> getResolvedTokens() {
    return resolvedTokens;
  }
}
