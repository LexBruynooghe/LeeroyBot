package com.acheros.chess_ai.pieces;

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
}
