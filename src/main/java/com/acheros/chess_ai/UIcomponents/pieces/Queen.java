package com.acheros.chess_ai.UIcomponents.pieces;

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
}
