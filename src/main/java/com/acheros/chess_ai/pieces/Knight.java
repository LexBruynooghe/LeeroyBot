package com.acheros.chess_ai.pieces;

import com.acheros.chess_ai.gamelogic.Move;

public class Knight extends Piece{
    public Knight(boolean white) {
        super(white);
    }

    @Override
    public String getName() {
        return "knight";
    }

    @Override
    public char getFen() {
        return white ? 'N' : 'n';
    }

    @Override
    public String getNotation() {
        return "N";
    }

    @Override
    public boolean isKnight() {
        return true;
    }

    @Override public boolean isWithinMoveSet(Move move) {
        int rowDiff = Math.abs(move.start() / 8 - move.target() / 8);
        int colDiff = Math.abs(move.start() % 8 - move.target() % 8);

        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
