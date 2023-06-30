package com.acheros.chess_ai.util;

import com.acheros.chess_ai.UIcomponents.BoardPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class BoardContainer extends Region {
    private final BoardPane board;

    public BoardContainer(BoardPane board) {
        this.board = board;
        getChildren().add(board);
    }
    @Override
    protected void layoutChildren() {
        double width = getWidth();
        double height = getHeight();
        board.setMaxSize(width, height);
        board.setMinSize(width, height);
        double boardWidth = board.getBoundsInLocal().getWidth();
        double boardHeight = board.getBoundsInLocal().getHeight();
        board.relocate((width - boardWidth) / 2 , (height - boardHeight) /2);
    }
}
