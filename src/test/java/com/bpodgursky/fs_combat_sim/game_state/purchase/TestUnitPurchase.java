package com.bpodgursky.fs_combat_sim.game_state.purchase;

import java.util.List;

import com.bpodgursky.fs_combat_sim.game_state.Card;
import com.bpodgursky.fs_combat_sim.game_state.Faction;
import com.bpodgursky.fs_combat_sim.game_state.Player;
import com.bpodgursky.fs_combat_sim.game_state.PlayerState;
import com.bpodgursky.fs_combat_sim.game_state.Token;
import com.bpodgursky.fs_combat_sim.game_state.Unit;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import com.liveramp.commons.collections.CountingMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestUnitPurchase {

  private static final Purchase PURCHASE_ASPECT_WARRIOR = Purchases.unit(Unit.ASPECT_WARRIOR);
  private static final Purchase PURCHASE_WRAITHGUARD = Purchases.unit(Unit.WRAITHGUARD);
  private static final Purchase PURCHASE_FALCON = Purchases.unit(Unit.FALCON);

  @Test
  public void testRaw() {

    PlayerState state = new PlayerState(new Player(Faction.ELDAR), 6, 0, 3, new CountingMap<Unit>(), new CountingMap<Token>(), Sets.<Card>newHashSet());

    state = PURCHASE_ASPECT_WARRIOR.apply(state);
    assertEquals(4, state.getMaterial());
    assertEquals(1, state.getUnits().get().get(Unit.ASPECT_WARRIOR).intValue());

    try {
      state = PURCHASE_FALCON.apply(state);
      fail();
    } catch (IllegalArgumentException e) {
      //  expected
    }

    state = PURCHASE_ASPECT_WARRIOR.apply(state);
    assertEquals(2, state.getMaterial());
    assertEquals(2, state.getUnits().get().get(Unit.ASPECT_WARRIOR).intValue());

    state = PURCHASE_ASPECT_WARRIOR.apply(state);
    assertEquals(0, state.getMaterial());
    assertEquals(3, state.getUnits().get().get(Unit.ASPECT_WARRIOR).intValue());

    try {
      state = PURCHASE_ASPECT_WARRIOR.apply(state);
      fail();
    } catch (IllegalArgumentException e) {
      //  expected
    }

  }

  @Test
  public void testSequence() {
    PlayerState state = new PlayerState(new Player(Faction.ELDAR), 6, 0, 3, new CountingMap<Unit>(), new CountingMap<Token>(), Sets.<Card>newHashSet());

    assertFailedSequence(state, Lists.newArrayList(
        PURCHASE_FALCON
    ));

    assertFailedSequence(state, Lists.newArrayList(
        PURCHASE_WRAITHGUARD
    ));

    //  resolve forge token and spend cash

    PlayerState wraithguard = state.applyAll(Lists.newArrayList(
        Purchases.RESOLVE_FORGE_TOKEN,
        PURCHASE_WRAITHGUARD
    ));

    assertEquals(1, wraithguard.getUnits().get().get(Unit.WRAITHGUARD).intValue());
    assertEquals(3, wraithguard.getMaterial());

    //  build a city and spend cash

    PlayerState wraithguard2 = state.applyAll(Lists.newArrayList(
        Purchases.CITY,
        PURCHASE_WRAITHGUARD
    ));

    assertEquals(1, wraithguard2.getUnits().get().get(Unit.WRAITHGUARD).intValue());
    assertEquals(0, wraithguard2.getMaterial());

    //  resolve both forge and cache tokens

    PlayerState wraithguard3 = state.applyAll(Lists.newArrayList(
        Purchases.RESOLVE_FORGE_TOKEN,
        Purchases.RESOLVE_CACHE_TOKEN,
        PURCHASE_WRAITHGUARD
    ));

    assertEquals(1, wraithguard3.getUnits().get().get(Unit.WRAITHGUARD).intValue());
    assertEquals(5, wraithguard3.getMaterial());
    assertEquals(1, wraithguard3.getNumUnresolvedTokens());

  }

  private void assertFailedSequence(PlayerState state, List<Purchase> purchases) {
    try {
      state.applyAll(purchases);
      fail();
    } catch (IllegalArgumentException e) {
      //  fine
    }
  }

}