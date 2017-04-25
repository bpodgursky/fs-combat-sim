package com.bpodgursky.fs_combat_sim.game_state.purchase;

import com.bpodgursky.fs_combat_sim.game_state.PlayerState;
import com.bpodgursky.fs_combat_sim.game_state.Token;
import com.google.common.collect.Maps;

import com.liveramp.commons.collections.CountingMap;

public class ResolveToken implements Purchase{

  private final Token purchase;

  protected ResolveToken(Token purchase){
    this.purchase = purchase;
  }

  public PlayerState apply(PlayerState inputState) {
    CountingMap<Token> tokens = new CountingMap<Token>(Maps.newHashMap(inputState.getResolvedTokens().get()));
    tokens.increment(purchase, 1L);

    return new PlayerState(
        inputState.getPlayer(),
        inputState.getMaterial(),
        inputState.getNumCities(),
        inputState.getNumUnresolvedTokens() - 1,
        inputState.getUnits(),
        tokens,
        inputState.getCardsInHand()
    );

  }
}
