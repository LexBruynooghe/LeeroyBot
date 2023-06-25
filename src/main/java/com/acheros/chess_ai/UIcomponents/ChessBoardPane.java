package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.Main;
import com.acheros.chess_ai.UIcomponents.pieces.*;
import com.acheros.chess_ai.models.BoardStateModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class ChessBoardPane extends AnchorPane {

    private final GridPane grid;

    private final BoardStateModel boardStateModel = new BoardStateModel();

    public ChessBoardPane() {
        // structure
        grid = new GridPane();
        grid.setGridLinesVisible(false);
        setLeftAnchor(grid, 10.0);
        setBottomAnchor(grid, 10.0);
        setRightAnchor(grid,10.0);
        setTopAnchor(grid,10.0);
        getChildren().add(grid);

        // sizing; keeps the board (fair and) square
        minWidthProperty().bind(heightProperty());
        maxWidthProperty().bind(heightProperty());

        // style
        getStylesheets().add(Main.class.getResource("stylesheets/defaultboard.css").toExternalForm());
        getStyleClass().add("Board");

        // adding tiles
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                BoardTile boardTile = new BoardTile((r + c) % 2 == 0, 63 - r * 8 - (7 - c),boardStateModel);

                // makes tiles and pieces scale with board
                boardTile.maxWidthProperty().bind(grid.widthProperty().divide(8.0));
                boardTile.minWidthProperty().bind(grid.widthProperty().divide(8.0));
                boardTile.maxHeightProperty().bind(grid.widthProperty().divide(8.0));
                boardTile.minHeightProperty().bind(grid.widthProperty().divide(8.0));

                boardStateModel.addListener(boardTile);

                grid.add(boardTile, c, r);
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
