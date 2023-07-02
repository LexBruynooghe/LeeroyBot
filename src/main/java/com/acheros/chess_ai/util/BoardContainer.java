package com.acheros.chess_ai.util;

import com.acheros.chess_ai.UIcomponents.BoardPane;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class BoardContainer extends Region {
    private final BoardPane board;

    public BoardContainer(BoardPane board) {
        this.board = board;
        BorderPane main = new BorderPane();
        main.setCenter(board);
        getChildren().add(main);
    }
    @Override
    protected void layoutChildren() {
        double size = Math.min(getWidth(), getHeight());
        board.setMaxSize(size, size);
        board.setMinSize(size, size);
        double boardWidth = board.getBoundsInLocal().getWidth();
        double boardHeight = board.getBoundsInLocal().getHeight();
        board.relocate((size - boardWidth) / 2 , (size - boardHeight) /2);
    }
}
