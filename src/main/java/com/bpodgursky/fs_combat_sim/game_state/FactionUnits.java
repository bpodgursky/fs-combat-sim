package com.bpodgursky.fs_combat_sim.game_state;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import com.liveramp.commons.collections.nested_map.TwoNestedMap;

public class FactionUnits {

  public static final Set<Unit> ELDAR = Sets.newHashSet(
    Unit.ASPECT_WARRIOR
  );

  public static final Set<Unit> ORKS = Sets.newHashSet(
      Unit.ORK_BOYZ
  );

  public static final Set<Unit> SPACE_MARINES = Sets.newHashSet(
      Unit.SCOUT,
      Unit.SPACE_MARINE,
      Unit.LAND_RAIDER,
      Unit.WARLORD_TITAN,
      Unit.STRIKE_CRUISER,
      Unit.BATTLE_BARGE
  );

  public static final Set<Unit> CHAOS = Sets.newHashSet(
      Unit.REINFORCEMENT_CULTIST
  );

  public static TwoNestedMap<Faction, AreaType, Unit> REINFORCEMENT_UNITS = new TwoNestedMap<Faction, AreaType, Unit>();
  static {

    REINFORCEMENT_UNITS.put(Faction.ELDAR, AreaType.WORLD, Unit.REINFORCEMENT_ASPECT_WARRIOR);
    REINFORCEMENT_UNITS.put(Faction.CHAOS, AreaType.WORLD, Unit.REINFORCEMENT_CULTIST);
    REINFORCEMENT_UNITS.put(Faction.ORKS, AreaType.WORLD, Unit.REINFORCEMENT_ORK_BOYZ);
    REINFORCEMENT_UNITS.put(Faction.SPACE_MARINES, AreaType.WORLD, Unit.REINFORCEMENT_SCOUT);

    REINFORCEMENT_UNITS.put(Faction.SPACE_MARINES, AreaType.VOID, Unit.REINFORCEMENT_STRIKE_CRUISER);
  }

}
