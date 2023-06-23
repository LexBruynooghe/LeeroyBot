package com.acheros.chess_ai.UIcomponents;

import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class BoardTile extends StackPane {

    private final Rectangle square;

    public BoardTile(boolean white) {
        getStyleClass().add("BoardTile");
        square = new Square(white);

        getChildren().add(square);
    }

    public DoubleProperty getWidthProperty() {
        return square.widthProperty();
    }

    public DoubleProperty getHeightProperty() {
        return square.heightProperty();
    }

    private static class Square extends Rectangle {
        public Square(boolean white) {
            getStyleClass().add(white ? "white" : "black");
        }
    }
}
