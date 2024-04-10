package com.acheros.chess_ai.MoveGenerators;

import com.acheros.chess_ai.gamelogic.Boardstate;
import com.acheros.chess_ai.gamelogic.Move;
import com.acheros.chess_ai.gamelogic.PlayerColor;
import com.acheros.chess_ai.pieces.Piece;

import java.util.HashSet;
import java.util.Set;

public class BruteForce1 implements LegalMoveGenerator{

    private Boardstate boardstate;

    @Override
    public Set<Move> generateMoves(Boardstate boardstate) {
        Set<Move> moves = new HashSet<>();
        this.boardstate = boardstate;

        for (int i = 0; i < 64; i++) {
            if (boardstate.getBoard().get(i) != null && (boardstate.getBoard().get(i).isWhite()?PlayerColor.WHITE:PlayerColor.BLACK) == boardstate.getTurn()) {
                for (int j = 0; j < 64; j++) {
                    if (i!=j && isValidMove(new Move(i, j))) {
                        moves.add(new Move(i, j));
                    }
                }
            }
        }

        return moves;
    }

    private boolean isValidMove(Move move){
        //we know the piece we picked up is of the legal color, and is at least moved

        //check if it is within the move set
        if (!boardstate.getBoard().get(move.start()).isWithinMoveSet(move))
            return false;

        if (boardstate.getBoard().get(move.target()) == null){
            //TODO check for king 2 moves and basically all pawn moves
            return true;
        }

        //check if target is a piece from the same color
        if ((boardstate.getBoard().get(move.target()).isWhite()?PlayerColor.WHITE:PlayerColor.BLACK) == boardstate.getTurn())
            return false;

        //TODO check if the king is in check i suppose

        return true;
    }
}
