package com.bpodgursky.fs_combat_sim.game_state.combat;

import java.util.function.Consumer;

import com.bpodgursky.fs_combat_sim.game_state.CombatState;

//Consumer - functions should be written as mutating, and immutability is taken care of for them
public interface CombatEffect extends Consumer<CombatState> {


}
