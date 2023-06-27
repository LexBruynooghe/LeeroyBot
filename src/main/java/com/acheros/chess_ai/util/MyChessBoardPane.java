package com.acheros.chess_ai.util;

import com.acheros.chess_ai.Main;
import com.acheros.chess_ai.UIcomponents.BoardTile;
import com.acheros.chess_ai.UIcomponents.pieces.*;
import com.acheros.chess_ai.models.BoardStateModel;
import javafx.scene.layout.*;


public class MyChessBoardPane extends GridPane {


    private final BoardStateModel boardStateModel = new BoardStateModel();

    public MyChessBoardPane() {
        // structure
        setGridLinesVisible(false);

        // sizing; keeps the board (fair and) square
        minWidthProperty().bind(heightProperty());
        maxWidthProperty().bind(heightProperty());
        for (int i = 0; i < 8; i++) {
            ColumnConstraints colConstraint = new ColumnConstraints();
            RowConstraints rowConstraint = new RowConstraints();
            // if sum of percentages of size of all constrains exceeds 100, distribution will be even
            colConstraint.setPercentWidth(100);
            rowConstraint.setPercentHeight(100);
            getColumnConstraints().add(colConstraint);
            getRowConstraints().add(rowConstraint);
        }


        // style
        getStylesheets().add(Main.class.getResource("stylesheets/defaultboard.css").toExternalForm());
        getStyleClass().add("Board");

        // adding tiles
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                BoardTile boardTile = new BoardTile((r + c) % 2 == 0, 63 - r * 8 - (7 - c),boardStateModel);
                add(boardTile, c, r);
            }
        }

        boardStateModel.set(5, new Queen(true));
        boardStateModel.set(9, new Bishop(false));
        boardStateModel.set(54, new Knight(false));
        boardStateModel.set(36, new Pawn(true));
        boardStateModel.set(15, new Rook(false));
        boardStateModel.set(56, new King(true));
    }
}
