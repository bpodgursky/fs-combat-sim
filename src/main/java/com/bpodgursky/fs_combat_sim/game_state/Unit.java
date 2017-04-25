package com.bpodgursky.fs_combat_sim.game_state;

public class Unit {

  public static final Unit SCOUT = new Unit(
      UnitType.SCOUT, 1, 2, 2, 0, 2, false, false
  );

  public static final Unit REINFORCEMENT_SCOUT = new Unit(
      UnitType.SCOUT, 1, 2, 2, 0, 2, false, true
  );

  public static final Unit SPACE_MARINE = new Unit(
      UnitType.SPACE_MARINE, 2, 3, 3, 1, 3, false, false
  );

  public static final Unit LAND_RAIDER = new Unit(
      UnitType.LAND_RAIDER, 3, 4, 3, 2, 4, false, false
  );

  public static final Unit WARLORD_TITAN = new Unit(
      UnitType.WARLORD_TITAN, 3, 5, 4, 3, 5, true, false
  );

  public static final Unit STRIKE_CRUISER = new Unit(UnitType.STRIKE_CRUISER,
      2, 2, 2, 0, 2, false, false
  );

  public static final Unit REINFORCEMENT_STRIKE_CRUISER = new Unit(UnitType.STRIKE_CRUISER,
      2, 2, 2, 0, 2, false, true
  );

  public static final Unit BATTLE_BARGE = new Unit(UnitType.BATTLE_BARGE,
      4, 4, 3, 2, 5, true, false
  );

  public static final Unit ORK_BOYZ = new Unit(UnitType.ORK_BOYZ,
      2, 2, 1, 0, 2, false, false
  );

  public static final Unit ORK_BOYZ_REINFORCEMENT = new Unit(UnitType.ORK_BOYZ,
      2, 2, 1, 0, 2, false, false
  );

  public static final Unit ASPECT_WARRIOR = new Unit(UnitType.ASPECT_WARRIOR,
      2,1,2,0,2, false, false
  );

  public static final Unit ASPECT_WARRIOR_REINFORCEMENT = new Unit(UnitType.ASPECT_WARRIOR,
      2,1,2,0,2, false, false
  );

  public static final Unit CULTIST_REINFORCEMENT = new Unit(UnitType.CULTIST,
      1,2,2,0,2, false, true
  );


  private final UnitType unit;
  private final int dice;
  private final int health;
  private final int morale;
  private final int commandLevel;
  private final int materialCost;
  private final boolean isForgeTokenRequired;
  private final boolean isReinforcement;

  Unit(UnitType unit, int dice, int health, int morale, int commandLevel, int materialCost,
       boolean forgeTokenRequired,
       boolean isReinforcement) {
    this.unit = unit;
    this.dice = dice;
    this.health = health;
    this.morale = morale;
    this.commandLevel = commandLevel;
    this.materialCost = materialCost;
    this.isForgeTokenRequired = forgeTokenRequired;
    this.isReinforcement = isReinforcement;
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

  public boolean isForgeTokenRequired(){
    return isForgeTokenRequired;
  }

  public boolean isReinforcement(){
    return isReinforcement;
  }

}
