package com.bpodgursky.fs_combat_sim.game_state;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import com.liveramp.commons.collections.nested_map.TwoNestedMap;

public class Factions {


  public static final Multimap<Faction, Unit> UNITS = HashMultimap.create();

  static {

    UNITS.putAll(Faction.ELDAR, Sets.newHashSet(
        Unit.BASTION,
        Unit.ASPECT_WARRIOR,
        Unit.WRAITHGUARD,
        Unit.FALCON
    ));

    UNITS.putAll(Faction.ORKS, Sets.newHashSet(
        Unit.BASTION,
        Unit.ORK_BOYZ
    ));

    UNITS.putAll(Faction.SPACE_MARINES, Sets.<Unit>newHashSet(
        Unit.BASTION,
        Unit.SCOUT,
        Unit.SPACE_MARINE,
        Unit.LAND_RAIDER,
        Unit.WARLORD_TITAN,
        Unit.STRIKE_CRUISER,
        Unit.BATTLE_BARGE
    ));

    UNITS.putAll(Faction.CHAOS, Sets.<Unit>newHashSet(
        Unit.BASTION,
        Unit.CULTIST
    ));

  }

  public static final Multimap<Faction, Card> STARTING_CARDS = HashMultimap.create();

  static {

    STARTING_CARDS.putAll(Faction.SPACE_MARINES, Sets.newHashSet(
        Card.AMBUSH,
        Card.BLESSED_POWER_ARMOR,
        Card.FAITH_IN_THE_EMPEROR,
        Card.FURY_OF_THE_ULTRAMAR,
        Card.RECONNAISANCE
    ));

    STARTING_CARDS.putAll(Faction.ELDAR, Sets.newHashSet(
        Card.HIT_AND_RUN,
        Card.HOWLING_BANSHEES,
        Card.STRIKING_SCORPIONS,
        Card.RANGER_SUPPORT,
        Card.COMMAND_OF_THE_AUTARCH
    ));

  }

  public static final Multimap<Faction, Card> CARDS = HashMultimap.create(STARTING_CARDS);

  static {

    CARDS.putAll(Faction.SPACE_MARINES, Sets.newHashSet(
        Card.HOLD_THE_LINE,
        Card.GLORY_AND_DEATH,
        Card.VETERAN_SCOUTS,
        Card.DROP_POD_ASSAULT,

        Card.SHOW_NO_FEAR
    ));

  }


  public static TwoNestedMap<Faction, AreaType, Unit> REINFORCEMENT_UNITS = new TwoNestedMap<Faction, AreaType, Unit>();

  static {

    REINFORCEMENT_UNITS.put(Faction.ELDAR, AreaType.WORLD, Unit.REINFORCEMENT_ASPECT_WARRIOR);
    REINFORCEMENT_UNITS.put(Faction.CHAOS, AreaType.WORLD, Unit.REINFORCEMENT_CULTIST);
    REINFORCEMENT_UNITS.put(Faction.ORKS, AreaType.WORLD, Unit.REINFORCEMENT_ORK_BOYZ);
    REINFORCEMENT_UNITS.put(Faction.SPACE_MARINES, AreaType.WORLD, Unit.REINFORCEMENT_SCOUT);

    REINFORCEMENT_UNITS.put(Faction.SPACE_MARINES, AreaType.VOID, Unit.REINFORCEMENT_STRIKE_CRUISER);
  }

}
