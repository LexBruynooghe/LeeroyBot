package com.acheros.chess_ai.MoveGenerators;

import com.acheros.chess_ai.gamelogic.Boardstate;
import com.acheros.chess_ai.gamelogic.Move;

import java.util.Set;

public interface LegalMoveGenerator {
    Set<Move> generateMoves(Boardstate boardstate);
}
