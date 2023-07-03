package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.gamelogic.Boardstate;
import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {

    private final BoardContextPane boardContext;

    public MainPane() {
        setPrefSize(1000, 600);

        Boardstate boardstate = new Boardstate(Boardstate.STARTFEN);

        boardContext = new BoardContextPane(boardstate);
        setCenter(boardContext);
    }
}
