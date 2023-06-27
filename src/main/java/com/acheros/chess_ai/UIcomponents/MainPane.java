package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.util.MyChessBoardPane;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {

    private final MyChessBoardPane board;

    public MainPane() {
        setPrefSize(1000, 600);
        board = new MyChessBoardPane();
        setCenter(board);
    }
}
