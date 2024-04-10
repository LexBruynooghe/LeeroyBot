package com.acheros.chess_ai.pieces;

import com.acheros.chess_ai.gamelogic.Move;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public String getName() {
        return "pawn";
    }

    @Override
    public char getFen() {
        return white ? 'P' : 'p';
    }

    @Override
    public String getNotation() {
        return "";
    }

    @Override
    public boolean isPawn() {
        return true;
    }

    @Override public boolean isWithinMoveSet(Move move) {
        int rowDiff = Math.abs(move.start() / 8 - move.target() / 8);
        int colDiff = Math.abs(move.start() % 8 - move.target() % 8);

        return (rowDiff == 1 && colDiff == 0) || (rowDiff == 2 && colDiff == 0) || (rowDiff == 1 && colDiff == 1);
    }
}
