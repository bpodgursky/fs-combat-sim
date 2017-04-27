package com.bpodgursky.fs_combat_sim.game_state;

public enum Card {

  HIT_AND_RUN("Hit and Run", 0, 0),
  HOWLING_BANSHEES("Howling Banshees", 0, 0),
  STRIKING_SCORPIONS("Striking Scorpions", 0, 0),
  RANGER_SUPPORT("Ranger Support", 0, 0),
  COMMAND_OF_THE_AUTARCH("Command of the Autarch", 0, 0),

  AMBUSH("Ambush", 0, 0),
  FURY_OF_THE_ULTRAMAR("Fury of the Ultramar", 0, 0),
  BLESSED_POWER_ARMOR("Blessed Power Armor", 0, 0),
  FAITH_IN_THE_EMPEROR("Faith in the Emperor", 0, 0),
  RECONNAISANCE("Reconnaisance", 0, 0),

  HOLD_THE_LINE("Hold the Line", 0, 2),
  GLORY_AND_DEATH("Glory and Death", 0, 2),
  VETERAN_SCOUTS("Veteran Scouts", 0, 2),
  DROP_POD_ASSAULT("Drop Pod Assault", 0, 2),

  SHOW_NO_FEAR("Show no Fear", 2, 4);

  private final String name;
  private final int commandLevel;
  private final int cost;

  Card(String name, int commandLevel, int cost){
    this.name = name;
    this.commandLevel = commandLevel;
    this.cost = cost;
  }
//  PlayerChoices getPlayerChoices(PlayerRole playerRole, CombatState combatState);
//
//  CombatState transformCombat(F madePlayerChoices, PlayerRole playerRole, CombatState currentState);


  public String getName() {
    return name;
  }

  public int getCommandLevel() {
    return commandLevel;
  }

  public int getCost() {
    return cost;
  }
}
