package com.acheros.chess_ai.UIcomponents;

import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {

    ChessBoardPane board;
    public MainPane() {
        setPrefSize(800,600);
        board = new ChessBoardPane();



        setCenter(board);
    }
}
