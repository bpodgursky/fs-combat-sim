package com.bpodgursky.fs_combat_sim.game_state;

public class Player {

  private final Faction faction;

  public Player(Faction faction) {
    this.faction = faction;
  }

  public Faction getFaction(){
    return faction;
  }

}
