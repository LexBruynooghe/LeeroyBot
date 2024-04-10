package com.acheros.chess_ai.pieces;

import com.acheros.chess_ai.gamelogic.Move;

public class King extends Piece{
    @Override
    public char getFen() {
        return white ? 'K' : 'k';
    }

    @Override
    public String getNotation() {
        return "K";
    }

    public King(boolean white) {
        super(white);
    }

    @Override
    public String getName() {
        return "king";
    }

    @Override
    public boolean isKing() {
        return true;
    }

    @Override public boolean isWithinMoveSet(Move move) {
        int rowDiff = Math.abs(move.start() / 8 - move.target() / 8);
        int colDiff = Math.abs(move.start() % 8 - move.target() % 8);

        // King can move 1 square in any direction or 2 squares on the same row
        return rowDiff <= 1 && colDiff <= 2;
    }
}
