package com.bpodgursky.fs_combat_sim.game_state.purchase;

import com.bpodgursky.fs_combat_sim.game_state.PlayerState;

public interface Purchase {

  public PlayerState apply(PlayerState inputState);

}
