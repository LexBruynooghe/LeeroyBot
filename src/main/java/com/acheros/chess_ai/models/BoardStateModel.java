package com.acheros.chess_ai.models;

import com.acheros.chess_ai.pieces.Piece;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;
import java.util.List;

public class BoardStateModel implements Observable {

    private final Piece[] boardstate;
    public BoardStateModel() {
        boardstate = new Piece[64];
    }

    public void set(int i, Piece piece) {
        if (boardstate[i] != piece) {
            boardstate[i] = piece;
            fireInvalidationEvent();
        }
    }

    public void remove(int i) {
        boardstate[i] = null;
        fireInvalidationEvent();
    }

    public Piece get(int i) {
        return boardstate[i];
    }
    private final List<InvalidationListener> listeners = new ArrayList<>();
    @Override
    public void addListener(InvalidationListener invalidationListener) {
        listeners.add(invalidationListener);
    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {
        listeners.remove(invalidationListener);
    }

    private void fireInvalidationEvent() {
        listeners.forEach(p -> p.invalidated(this));
    }
}
