package com.acheros.chess_ai.gamelogic;

import com.acheros.chess_ai.exceptions.IllegalMoveException;

public class Move {
    int start;
    int target;
    public Move(int start, int target) {
        if (start != target && start >= 0 && target >= 0 && start < 64 && target < 64) {
            this.start = start;
            this.target = target;
        } else {
            throw new IllegalMoveException();
        }
    }

    public int start() {
        return start;
    }

    public int target() {
        return target;
    }
}
