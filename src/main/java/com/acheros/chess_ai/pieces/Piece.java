package com.acheros.chess_ai.pieces;

import com.acheros.chess_ai.util.PieceUtil;
import javafx.scene.image.Image;

import java.io.Serializable;

public abstract class Piece implements Serializable {
    protected boolean white;
    public Piece(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    public Image getImage() {
        return PieceUtil.getImage(getClass(), white);
    }

    public abstract String getName();
    public abstract char getFen();
    public abstract String getNotation();

    public String toString() {
        return (white ? "white" : "black") + getName();
    }

    public Image getImageOfSize(double v) {
        return PieceUtil.getImageOfSize(getName(), white, v);
    }

    public boolean isKing() {
        return false;
    }
    public boolean isQueen() {
        return false;
    }
    public boolean isRook() {
        return false;
    }
    public boolean isBishop() {
        return false;
    }
    public boolean isKnight() {
        return false;
    }
    public boolean isPawn() {
        return true;
    }
}
