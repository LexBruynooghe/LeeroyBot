package com.acheros.chess_ai.MoveGenerators;

import com.acheros.chess_ai.gamelogic.Boardstate;
import com.acheros.chess_ai.gamelogic.Move;

import java.util.HashSet;
import java.util.Set;

public class MyLegalMoveGenerator implements LegalMoveGenerator {
    @Override
    public Set<Move> generateMoves(Boardstate boardstate) {
        HashSet<Move> moves = new HashSet<>();

        moves.add(new Move(1,10));
        moves.add(new Move(1,8));

        return moves;
    }
}
