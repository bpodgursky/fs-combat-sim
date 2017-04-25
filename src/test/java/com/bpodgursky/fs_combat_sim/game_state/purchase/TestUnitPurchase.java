package com.bpodgursky.fs_combat_sim.game_state.purchase;

import com.bpodgursky.fs_combat_sim.game_state.Card;
import com.bpodgursky.fs_combat_sim.game_state.Faction;
import com.bpodgursky.fs_combat_sim.game_state.Player;
import com.bpodgursky.fs_combat_sim.game_state.PlayerState;
import com.bpodgursky.fs_combat_sim.game_state.Unit;
import com.google.common.collect.Sets;
import org.junit.Test;

import com.liveramp.commons.collections.CountingMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestUnitPurchase {

  @Test
  public void test(){

    PlayerState state = new PlayerState(new Player(Faction.ELDAR), 6, 0, 3, new CountingMap<Unit>(), Sets.<Card>newHashSet());
    UnitPurchase purchase = new UnitPurchase(Unit.ASPECT_WARRIOR);

    state = purchase.apply(state);
    assertEquals(4, state.getMaterial());
    assertEquals(1, state.getUnits().get().get(Unit.ASPECT_WARRIOR).intValue());

    state = purchase.apply(state);
    assertEquals(2, state.getMaterial());
    assertEquals(2, state.getUnits().get().get(Unit.ASPECT_WARRIOR).intValue());

    state = purchase.apply(state);
    assertEquals(0, state.getMaterial());
    assertEquals(3, state.getUnits().get().get(Unit.ASPECT_WARRIOR).intValue());

    try{
      state = purchase.apply(state);
      fail();
    }catch(IllegalArgumentException e){
      //  expected
    }

  }

}