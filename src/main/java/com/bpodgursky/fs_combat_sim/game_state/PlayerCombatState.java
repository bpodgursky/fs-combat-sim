package com.bpodgursky.fs_combat_sim.game_state;

import java.util.function.Consumer;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;

import com.liveramp.commons.collections.CountingMap;

public class PlayerCombatState {

  private final CountingMap<DieRoll> combatDice;
  private final CountingMap<CombatToken> combatTokens;

  private final CountingMap<Unit> activeUnits;
  private final CountingMap<Unit> routedUnits;

  private final Multiset<Card> activeCards;

  public PlayerCombatState(CountingMap<DieRoll> combatDice,
                           CountingMap<CombatToken> combatTokens,
                           CountingMap<Unit> activeUnits,
                           CountingMap<Unit> routedUnits,
                           Multiset<Card> activeCards) {
    this.combatDice = combatDice;
    this.combatTokens = combatTokens;
    this.activeUnits = activeUnits;
    this.routedUnits = routedUnits;
    this.activeCards = activeCards;
  }


  private static <T> boolean decrement(CountingMap<T> map, T key) {
    if (map.get().get(key) > 0) {
      map.increment(key, -1L);
      return true;
    }
    return false;
  }

  private static <T> void increment(CountingMap<T> map, T key) {
    map.increment(key, 1L);
  }

  public PlayerCombatState addCombatDie(DieRoll die) {
    return clone(s -> increment(s.combatDice, die));
  }

  public PlayerCombatState removeCombatDie(DieRoll die) {
    return clone(s -> decrement(s.combatDice, die));
  }

  public PlayerCombatState addCombatToken(CombatToken token) {
    return clone(s -> increment(s.combatTokens, token));
  }

  public PlayerCombatState removeCombatToken(CombatToken token) {
    return clone(s -> decrement(s.combatTokens, token));
  }

  public PlayerCombatState addActiveUnit(Unit unit) {
    return clone(s -> increment(s.activeUnits, unit));
  }

  public PlayerCombatState killActiveUnit(Unit unit) {
    return clone(s -> decrement(s.activeUnits, unit));
  }

  public PlayerCombatState addRoutedUnit(Unit unit) {
    return clone(s -> increment(s.routedUnits, unit));
  }

  public PlayerCombatState killRoutedUnit(Unit unit) {
    return clone(s -> decrement(s.routedUnits, unit));
  }

  public PlayerCombatState routeUnit(Unit unit) {
    return clone(s -> {
      if (decrement(s.activeUnits, unit)) {
        increment(s.routedUnits, unit);
      }
    });
  }

  public PlayerCombatState rallyUnit(Unit unit) {
    return clone(s -> {
      if (decrement(s.routedUnits, unit)) {
        increment(s.activeUnits, unit);
      }
    });
  }

  public PlayerCombatState addActiveCard(Card card) {
    return clone(s -> s.activeCards.add(card));
  }

  public PlayerCombatState clone(Consumer<PlayerCombatState> consumer) {
    PlayerCombatState stateCopy = new PlayerCombatState(
        copyMap(this.combatDice),
        copyMap(combatTokens),
        copyMap(activeUnits),
        copyMap(routedUnits),
        HashMultiset.create(activeCards));
    consumer.accept(stateCopy);
    return stateCopy;
  }

  private <T> CountingMap<T> copyMap(CountingMap<T> combatDice) {
    return new CountingMap<>(Maps.newHashMap(combatDice.get()));
  }

}
