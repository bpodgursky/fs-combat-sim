package com.bpodgursky.fs_combat_sim.game_state.purchase;

import java.util.Map;

import com.bpodgursky.fs_combat_sim.game_state.Player;
import com.bpodgursky.fs_combat_sim.game_state.PlayerState;
import com.bpodgursky.fs_combat_sim.game_state.Token;
import com.bpodgursky.fs_combat_sim.game_state.Unit;
import com.google.common.collect.Maps;

import com.liveramp.commons.collections.CountingMap;

public class UnitPurchase implements Purchase {

  private final Unit unit;
  private final boolean useCacheTokenIfAvailable;

  protected UnitPurchase(Unit unit, boolean useCacheTokenIfAvailable) {
    this.useCacheTokenIfAvailable = useCacheTokenIfAvailable;
    this.unit = unit;
  }

  public Unit getUnit() {
    return unit;
  }

  public PlayerState apply(PlayerState inputState) {

    int inputMaterial = inputState.getMaterial();
    Player inputPlayer = inputState.getPlayer();
    int techLevel = inputState.getNumCities();
    int requiredTechLevel = unit.getCommandLevel();
    CountingMap<Unit> units = new CountingMap<Unit>(Maps.newHashMap(inputState.getUnits().get()));
    CountingMap<Token> tokens = new CountingMap<Token>(Maps.newHashMap(inputState.getResolvedTokens().get()));

    if (techLevel < requiredTechLevel) {

      if (techLevel == requiredTechLevel - 1) {
        //  spend one token as a forge token
        tokens.increment(Token.FORGE, -1L);
      }
      //  tech level too high
      else {
        throw new IllegalArgumentException("Insufficient tech level");
      }

    }

    if (unit.isForgeTokenRequired()) {
      tokens.increment(Token.FORGE, -1L);
    }

    int materialCost = unit.getMaterialCost();

    Map<Token, Long> tokensMap = tokens.get();
    if (materialCost >= 2 &&
        useCacheTokenIfAvailable &&
        tokensMap.containsKey(Token.CACHE) &&
        tokensMap.get(Token.CACHE) > 0) {
      materialCost -= 2;
      tokens.increment(Token.CACHE, -1L);
    }

    units.increment(unit, 1L);

    return new PlayerState(inputPlayer, inputMaterial - materialCost,
        inputState.getNumCities(),
        inputState.getNumUnresolvedTokens(),
        units,
        tokens,
        inputState.getCardsInHand()
    );

  }
}
