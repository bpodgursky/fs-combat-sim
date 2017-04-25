package com.bpodgursky.fs_combat_sim.game_state.purchase;

import com.bpodgursky.fs_combat_sim.game_state.PlayerState;

public class PurchaseCity implements Purchase {

  protected PurchaseCity(){}

  public PlayerState apply(PlayerState inputState) {

    return new PlayerState(
        inputState.getPlayer(),
        inputState.getMaterial() - 3,
        inputState.getNumCities() + 1,
        inputState.getNumUnresolvedTokens(),
        inputState.getUnits(),
        inputState.getResolvedTokens(),
        inputState.getCardsInHand()
    );
  }

}
