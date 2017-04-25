package com.bpodgursky.fs_combat_sim.game_state;

public enum ReinforcementUnit {
  SPACE_MARINE(Unit.SCOUT),
  ELDAR(Unit.ASPECT_WARRIOR),
  CHAOS(Unit.CULTIST),
  ORK(Unit.ORK_BOY);


  private final Unit baseUnit;

  ReinforcementUnit(Unit baseUnit) {
    this.baseUnit = baseUnit;
  }
}
