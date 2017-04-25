package com.bpodgursky.fs_combat_sim.game_state;

public class Unit {

  public static final Unit BASTION = new Unit(UnitType.BASTION,
      AreaType.WORLD, 2, 3, 2, 0, 2, false, false, 1
  );

  public static final Unit SCOUT = new Unit(UnitType.SCOUT,
      AreaType.WORLD, 1, 2, 2, 0, 2, false, false, 6
  );

  public static final Unit REINFORCEMENT_SCOUT = new Unit(UnitType.SCOUT,
      AreaType.WORLD, 1, 2, 2, 0, 2, false, true, Integer.MAX_VALUE
  );

  public static final Unit SPACE_MARINE = new Unit(UnitType.SPACE_MARINE,
      AreaType.WORLD, 2, 3, 3, 1, 3, false, false, 6
  );

  public static final Unit LAND_RAIDER = new Unit(UnitType.LAND_RAIDER,
      AreaType.WORLD, 3, 4, 3, 2, 4, false, false, 6
  );

  public static final Unit WARLORD_TITAN = new Unit(UnitType.WARLORD_TITAN,
      AreaType.WORLD, 3, 5, 4, 3, 5, true, false, 2
  );

  public static final Unit STRIKE_CRUISER = new Unit(UnitType.STRIKE_CRUISER,
      AreaType.VOID, 2, 2, 2, 0, 2, false, false, 3
  );

  public static final Unit REINFORCEMENT_STRIKE_CRUISER = new Unit(UnitType.STRIKE_CRUISER,
      AreaType.VOID, 2, 2, 2, 0, 2, false, true, Integer.MAX_VALUE
  );

  public static final Unit BATTLE_BARGE = new Unit(UnitType.BATTLE_BARGE,
      AreaType.VOID, 4, 4, 3, 2, 5, true, false, 2
  );

  public static final Unit ORK_BOYZ = new Unit(UnitType.ORK_BOYZ,
      AreaType.WORLD, 2, 2, 1, 0, 2, false, false, 6  //  TODO not sure
  );

  public static final Unit REINFORCEMENT_ORK_BOYZ = new Unit(UnitType.ORK_BOYZ,
      AreaType.WORLD, 2, 2, 1, 0, 2, false, false, 6  //  TODO not sure
  );

  public static final Unit ASPECT_WARRIOR = new Unit(UnitType.ASPECT_WARRIOR,
      AreaType.WORLD, 2, 1, 2, 0, 2, false, false, 6  //  TODO not sure
  );

  public static final Unit REINFORCEMENT_ASPECT_WARRIOR = new Unit(UnitType.ASPECT_WARRIOR,
      AreaType.WORLD, 2, 1, 2, 0, 2, false, false, Integer.MAX_VALUE
  );

  public static final Unit CULTIST = new Unit(UnitType.CULTIST,
      AreaType.WORLD, 1, 2, 2, 0, 2, false, false, 6   //  TODO not sure
  );

  public static final Unit REINFORCEMENT_CULTIST = new Unit(UnitType.CULTIST,
      AreaType.WORLD, 1, 2, 2, 0, 2, false, true, Integer.MAX_VALUE //  TODO not sure
  );


  private final UnitType unit;
  private final AreaType area;
  private final int dice;
  private final int health;
  private final int morale;
  private final int commandLevel;
  private final int materialCost;
  private final boolean isForgeTokenRequired;
  private final boolean isReinforcement;
  private final int maxCount;

  Unit(UnitType unit,
       AreaType area,
       int dice, int health, int morale, int commandLevel, int materialCost,
       boolean forgeTokenRequired,
       boolean isReinforcement,
       int maxCount) {
    this.unit = unit;
    this.area = area;
    this.dice = dice;
    this.health = health;
    this.morale = morale;
    this.commandLevel = commandLevel;
    this.materialCost = materialCost;
    this.isForgeTokenRequired = forgeTokenRequired;
    this.isReinforcement = isReinforcement;
    this.maxCount = maxCount;
  }

  public int getDice() {
    return dice;
  }

  public int getHealth() {
    return health;
  }

  public int getMorale() {
    return morale;
  }

  public int getCommandLevel() {
    return commandLevel;
  }

  public int getMaterialCost() {
    return materialCost;
  }

  public UnitType getUnitType() {
    return unit;
  }

  public boolean isForgeTokenRequired() {
    return isForgeTokenRequired;
  }

  public boolean isReinforcement() {
    return isReinforcement;
  }

}
