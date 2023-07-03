package com.acheros.chess_ai.gamelogic;

import com.acheros.chess_ai.pieces.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.*;
import java.util.function.Supplier;

public class Board implements Observable {
    private Piece[] board;

    public Board(Piece[] board) {
        if (board.length == 64) {
            this.board = board;
        } else {
            throw new RuntimeException("board doesn't have the right size");
        }
    }
    private static final Map<Character, Supplier<Piece>> charToPieceType = new HashMap<>();
    static {
        charToPieceType.put('k', () -> new King(false));
        charToPieceType.put('K', () -> new King(true));
        charToPieceType.put('p', () -> new Pawn(false));
        charToPieceType.put('P', () -> new Pawn(true));
        charToPieceType.put('n', () -> new Knight(false));
        charToPieceType.put('N', () -> new Knight(true));
        charToPieceType.put('b', () -> new Bishop(false));
        charToPieceType.put('B', () -> new Bishop(true));
        charToPieceType.put('r', () -> new Rook(false));
        charToPieceType.put('R', () -> new Rook(true));
        charToPieceType.put('q', () -> new Queen(false));
        charToPieceType.put('Q', () -> new Queen(true));
    }

    public Board(String FEN) {
        board = new Piece[64];

        int column = 0;
        int row = 7;
        for (int i = 0; i < FEN.length(); i++) {
            char ch = FEN.charAt(i);
            if (ch == '/') {
                row--;
                column = 0;
            } else if (Character.isDigit(ch)) {
                column += Integer.parseInt(String.valueOf(ch));
            } else {
                board[row * 8 + column] = charToPieceType.get(ch).get();
                column++;
            }
        }
    }

    public void set(int i, Piece piece) {
        if (board[i] != piece) {
            board[i] = piece;
            fireInvalidationEvent();
        }
    }

    public void remove(int i) {
        board[i] = null;
        fireInvalidationEvent();
    }

    public void executeMove(Move move) {
        if (move.start() != move.target()) {
            board[move.target()] = board[move.start()];
            board[move.start()] = null;
            fireInvalidationEvent();
        }
    }

    public Piece get(int i) {
        return board[i];
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

    public void print() {
        System.out.println(Arrays.toString(board));
    }

}
