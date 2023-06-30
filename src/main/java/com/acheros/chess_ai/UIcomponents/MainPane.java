package com.acheros.chess_ai.UIcomponents;

import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {

    private final BoardContextPane boardContext;

    public MainPane() {
        setPrefSize(1000, 600);
        boardContext = new BoardContextPane();
        setCenter(boardContext);
    }
}
