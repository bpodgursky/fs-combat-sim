package com.bpodgursky.fs_combat_sim.game_state;

import java.util.Map;

import com.google.common.collect.Multiset;

public class PlayerCombatState {

  private final Map<DieRoll, Integer> combatDice;
  private final Map<CombatToken, Integer> combatTokens;

  private final Map<Unit, Integer> activeUnits;
  private final Map<Unit, Integer> routedUnits;

  private final Multiset<Card> activeCards;

  public PlayerCombatState(Map<DieRoll, Integer> combatDice,
                           Map<CombatToken, Integer> combatTokens,
                           Map<Unit, Integer> activeUnits,
                           Map<Unit, Integer> routedUnits,
                           Multiset<Card> activeCards) {
    this.combatDice = combatDice;
    this.combatTokens = combatTokens;
    this.activeUnits = activeUnits;
    this.routedUnits = routedUnits;
    this.activeCards = activeCards;
  }

}
