package com.acheros.chess_ai.pieces;

import com.acheros.chess_ai.gamelogic.Move;

public class Rook extends Piece{
    public Rook(boolean white) {
        super(white);
    }

    @Override
    public String getName() {
        return "rook";
    }

    @Override
    public char getFen() {
        return white ? 'R' : 'r';
    }

    @Override
    public String getNotation() {
        return "R";
    }

    @Override
    public boolean isRook() {
        return true;
    }

    @Override
    public boolean isWithinMoveSet(Move move) {
        int rowDiff = Math.abs(move.start() / 8 - move.target() / 8);
        int colDiff = Math.abs(move.start() % 8 - move.target() % 8);

        return (rowDiff == 0 && colDiff > 0) || (rowDiff > 0 && colDiff == 0);
    }
}
