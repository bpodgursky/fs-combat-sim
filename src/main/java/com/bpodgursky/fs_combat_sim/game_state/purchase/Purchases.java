package com.bpodgursky.fs_combat_sim.game_state.purchase;

import com.bpodgursky.fs_combat_sim.game_state.Token;
import com.bpodgursky.fs_combat_sim.game_state.Unit;

public class Purchases {

  public static final Purchase CITY = new PurchaseCity();
  public static final Purchase RESOLVE_CACHE_TOKEN = new ResolveToken(Token.CACHE);
  public static final Purchase RESOLVE_FORGE_TOKEN = new ResolveToken(Token.FORGE);
  public static final Purchase RESOLVE_REINFORCEMENT_TOKEN = new ResolveToken(Token.REINFORCEMENT);

  //  almost always would rather use the token first
  public static final Purchase unit(Unit unit) {
    return unit(unit, true);
  }

  public static final Purchase unit(Unit unit, boolean useCacheToken) {
    return new UnitPurchase(unit, useCacheToken);
  }

}
