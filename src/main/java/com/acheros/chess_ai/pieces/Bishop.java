package com.acheros.chess_ai.pieces;

import com.acheros.chess_ai.gamelogic.Move;

public class Bishop extends Piece{
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public String getName() {
        return "bishop";
    }

    @Override
    public char getFen() {
        return white ? 'B' : 'b';
    }

    @Override
    public String getNotation() {
        return "B";
    }

    @Override
    public boolean isBishop() {
        return true;
    }

    @Override
    public boolean isWithinMoveSet(Move move) {
        int rowDiff = Math.abs(move.start() / 8 - move.target() / 8);
        int colDiff = Math.abs(move.start() % 8 - move.target() % 8);

        return rowDiff == colDiff;
    }
}
