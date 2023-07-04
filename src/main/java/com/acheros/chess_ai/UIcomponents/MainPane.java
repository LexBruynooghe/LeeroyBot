package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.MoveGenerators.LegalMoveGenerator;
import com.acheros.chess_ai.MoveGenerators.MyLegalMoveGenerator;
import com.acheros.chess_ai.gamelogic.Boardstate;
import com.acheros.chess_ai.gamelogic.Move;
import javafx.scene.layout.BorderPane;

import java.util.Set;

public class MainPane extends BorderPane {

    private final BoardContextPane boardContext;

    public MainPane() {
        setPrefSize(1000, 600);

        Boardstate boardstate = new Boardstate(Boardstate.STARTFEN);

        boardContext = new BoardContextPane(boardstate);
        setCenter(boardContext);
    }
}
