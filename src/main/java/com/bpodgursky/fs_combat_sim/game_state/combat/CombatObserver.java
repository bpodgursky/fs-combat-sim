package com.bpodgursky.fs_combat_sim.game_state.combat;

import com.bpodgursky.fs_combat_sim.game_state.CombatState;
import org.apache.commons.lang3.tuple.Pair;

//Designed for persistent effects, like weirdboyz or spiritseer's guidance
public interface CombatObserver {

  Pair<CombatState, CombatObserver> observe(CombatState oldState, CombatState newState);

}
