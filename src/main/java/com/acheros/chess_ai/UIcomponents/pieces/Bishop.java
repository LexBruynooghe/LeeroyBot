package com.acheros.chess_ai.UIcomponents.pieces;

public class Bishop extends Piece{
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public String getName() {
        return "bishop";
    }

    @Override
    public char getFen() {
        return white ? 'B' : 'b';
    }

    @Override
    public String getNotation() {
        return "B";
    }
}
