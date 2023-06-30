package com.acheros.chess_ai.pieces;

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
}
