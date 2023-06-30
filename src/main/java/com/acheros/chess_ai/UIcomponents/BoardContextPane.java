package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.Main;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BoardContextPane extends BorderPane {

    private final BoardPane board;
    public BoardContextPane() {
        getStylesheets().add(Main.class.getResource("stylesheets/boardcontext.css").toExternalForm());

        board = new BoardPane();

        Sidebar sidebar = new Sidebar();

        Button settingsButton = new Button("settings");
        settingsButton.getStyleClass().add("settingsButton");
        settingsButton.setAlignment(Pos.BASELINE_LEFT);

        sidebar.getChildren().add(settingsButton);

        setCenter(board);
        setRight(sidebar);
    }

    private static class SidebarElement extends HBox {
        public SidebarElement(Node node) {
            setAlignment(Pos.BASELINE_LEFT);
            getChildren().add(node);
        }
    }

    private static class Sidebar extends VBox {
        public Sidebar() {
            setAlignment(Pos.BASELINE_LEFT);
            getStyleClass().add("sidebar");
        }
    }
}
