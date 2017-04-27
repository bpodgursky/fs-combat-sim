package com.bpodgursky.fs_combat_sim.game_state;

import java.util.Map;
import java.util.function.Consumer;

public class CombatState {

  PlayerCombatState attackerState;
  PlayerCombatState defenderState;

  public CombatState(PlayerCombatState attackerState, PlayerCombatState defenderState) {
    this.attackerState = attackerState;
    this.defenderState = defenderState;
  }

  public PlayerCombatState getAttackerState() {
    return attackerState;
  }

  public PlayerCombatState getDefenderState() {
    return defenderState;
  }

  public PlayerCombatState getByRole(PlayerRole role) {
    if (role.equals(PlayerRole.ATTACKING)) {
      return getAttackerState();
    } else {
      return getDefenderState();
    }
  }

  public CombatState clonse(Consumer<CombatState> consumer) {
    CombatState newState = new CombatState(
        attackerState.clone(s -> {}),
        defenderState.clone(s -> {})
    );
    consumer.accept(newState);
    return newState;
  }


}
