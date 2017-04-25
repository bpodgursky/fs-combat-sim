package com.bpodgursky.fs_combat_sim.game_state;

import java.util.Set;

import com.google.common.collect.Sets;

public class FactionUnits {

  public static final Set<Unit> ELDAR = Sets.newHashSet(
    Unit.ASPECT_WARRIOR
  );

  public static final Set<Unit> ORKS = Sets.newHashSet(
      Unit.ORK_BOYZ
  );

  public static final Set<Unit> SPACE_MARINES = Sets.newHashSet(
      Unit.SCOUT,
      Unit.SPACE_MARINE
  );

  public static final Set<Unit> CHAOS = Sets.newHashSet(
      Unit.CULTIST
  );

}
