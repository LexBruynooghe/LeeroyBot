package com.acheros.chess_ai.pieces;

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
}
