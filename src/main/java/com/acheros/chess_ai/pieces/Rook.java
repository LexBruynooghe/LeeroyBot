package com.acheros.chess_ai.pieces;

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
}
