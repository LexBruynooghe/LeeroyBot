package com.acheros.chess_ai.pieces;

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
}
