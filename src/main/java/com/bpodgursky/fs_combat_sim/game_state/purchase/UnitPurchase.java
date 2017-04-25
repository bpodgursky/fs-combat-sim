package com.bpodgursky.fs_combat_sim.game_state.purchase;

import com.bpodgursky.fs_combat_sim.game_state.Player;
import com.bpodgursky.fs_combat_sim.game_state.PlayerState;
import com.bpodgursky.fs_combat_sim.game_state.Unit;

import com.liveramp.commons.collections.CountingMap;

public class UnitPurchase implements Purchase {

  private final Unit unit;

  public UnitPurchase(Unit unit) {
    this.unit = unit;
  }

  public Unit getUnit() {
    return unit;
  }

  public PlayerState apply(PlayerState inputState) {

    int inputMaterial = inputState.getMaterial();
    int materialCost = unit.getMaterialCost();
    Player inputPlayer = inputState.getPlayer();
    int techLevel = inputState.getNumCities();
    int requiredTechLevel = unit.getCommandLevel();
    CountingMap<Unit> units = new CountingMap<Unit>(inputState.getUnits().get());

    int playerTokens = inputState.getNumTokens();

    if (techLevel < requiredTechLevel) {

      if (techLevel == requiredTechLevel - 1) {
        //  spend one token as a forge token
        playerTokens--;
      }
      //  tech level too high
      else {
        throw new IllegalArgumentException();
      }

    }

    if (unit.isForgeTokenRequired()) {
      playerTokens--;
    }

    units.increment(unit, 1L);

    return new PlayerState(inputPlayer, inputMaterial - materialCost,
        inputState.getNumCities(),
        playerTokens,
        units,
        inputState.getCardsInHand()
    );

  }
}
