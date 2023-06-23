package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.Main;
import com.acheros.chess_ai.UIcomponents.BoardTile;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Control;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


// Really didn't have to use an anchorpane here, just the gridpane would've been fine.
// Just wanted to experiment a little.
public class ChessBoardPane extends AnchorPane {

    private GridPane root;

    public ChessBoardPane() {
        // structure
        root = new GridPane();
        root.setGridLinesVisible(false);
        setLeftAnchor(root, 10.0);
        setBottomAnchor(root, 10.0);
        setRightAnchor(root,10.0);
        setTopAnchor(root,10.0);
        getChildren().add(root);

        // sizing; keeps the board (fair and) square
        minWidthProperty().bind(heightProperty());
        maxWidthProperty().bind(heightProperty());

        // style
        getStylesheets().add(Main.class.getResource("stylesheets/defaultboard.css").toExternalForm());
        getStyleClass().add("Board");

        // adding tiles
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                BoardTile boardTile = new BoardTile((r + c) % 2 == 0);
                // makes tiles scale with board
                boardTile.getWidthProperty().bind(root.widthProperty().divide(8.0));
                boardTile.getHeightProperty().bind(root.heightProperty().divide(8.0));
                root.add(boardTile, c, r);
            }
        }
    }
}
