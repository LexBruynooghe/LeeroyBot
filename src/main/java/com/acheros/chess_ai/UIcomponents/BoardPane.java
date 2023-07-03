package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.Main;
import com.acheros.chess_ai.gamelogic.Board;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;


public class BoardPane extends GridPane {
    private final Board board;
    private final List<BoardTile> tiles = new ArrayList<>();

    public BoardPane(Board board) {
        this.board = board;

        // structure
        setGridLinesVisible(false);

        // sizing; keeps the board square
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
        getStyleClass().add("board");

        // adding tiles
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                BoardTile boardTile = new BoardTile((r + c) % 2 == 0, 63 - r * 8 - (7 - c), board);
                tiles.add(boardTile);
                add(boardTile, c, r);
            }
        }
    }

    public void setShowIndex(boolean b) {
        tiles.forEach(tile -> tile.setShowIndex(b));
    }
}
