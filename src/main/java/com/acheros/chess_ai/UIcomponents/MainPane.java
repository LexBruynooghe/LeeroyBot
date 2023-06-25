package com.acheros.chess_ai.UIcomponents;

import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {

    private final ChessBoardPane board;

    public MainPane() {
        setPrefSize(1000, 600);
        board = new ChessBoardPane();

        setCenter(board);
    }
}
