package com.acheros.chess_ai.pieces;

import com.acheros.chess_ai.gamelogic.Move;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public char getFen() {
        return white ? 'Q' : 'q';
    }

    @Override
    public String getNotation() {
        return "Q";
    }

    @Override
    public String getName() {
        return "queen";
    }

    @Override
    public boolean isQueen() {
        return true;
    }

    @Override
    public boolean isWithinMoveSet(Move move) {
        int rowDiff = Math.abs(move.start() / 8 - move.target() / 8);
        int colDiff = Math.abs(move.start() % 8 - move.target() % 8);

        return (rowDiff == colDiff) || (rowDiff == 0 && colDiff > 0) || (rowDiff > 0 && colDiff == 0);
    }
}
