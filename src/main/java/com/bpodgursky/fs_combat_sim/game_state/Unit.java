package com.bpodgursky.fs_combat_sim.game_state;

public enum Unit {
  SCOUT(1, 2, 2, 0, 2),
  SPACE_MARINE(2, 3, 3, 1, 3);


  private final int dice;
  private final int health;
  private final int morale;
  private final int commandLevel;
  private final int materialCost;

  Unit(int dice, int health, int morale, int commandLevel, int materialCost) {

    this.dice = dice;
    this.health = health;
    this.morale = morale;
    this.commandLevel = commandLevel;
    this.materialCost = materialCost;
  }

  public int getDice() {
    return dice;
  }

  public int getHealth() {
    return health;
  }

  public int getMorale() {
    return morale;
  }

  public int getCommandLevel() {
    return commandLevel;
  }

  public int getMaterialCost() {
    return materialCost;
  }
}
