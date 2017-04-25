package com.bpodgursky.fs_combat_sim.game_state.purchase;

import java.util.Map;

import com.bpodgursky.fs_combat_sim.game_state.FactionUnits;
import com.bpodgursky.fs_combat_sim.game_state.Player;
import com.bpodgursky.fs_combat_sim.game_state.PlayerState;
import com.bpodgursky.fs_combat_sim.game_state.Unit;

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
    Map<Unit, Integer> units = inputState.getUnits();

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

    if(unit.isForgeTokenRequired()){
      playerTokens--;
    }


    return new PlayerState(inputPlayer, inputMaterial - materialCost,
        inputState.getNumCities(),
        playerTokens,

        );
  }
}
