package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.Main;
import com.acheros.chess_ai.gamelogic.Boardstate;
import com.acheros.chess_ai.util.BoardContainer;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BoardContextPane extends BorderPane {

    private final Dialog<Void> settingsDialog;
    private final BoardPane board;
    public BoardContextPane(Boardstate boardstate) {
        getStylesheets().add(Main.class.getResource("stylesheets/boardcontext.css").toExternalForm());

        settingsDialog = new SettingsDialog();

        board = new BoardPane(boardstate);

        Sidebar sidebar = new Sidebar();

        Button settingsButton = new Button("settings");
        settingsButton.getStyleClass().add("settingsButton");
        settingsButton.setAlignment(Pos.BASELINE_LEFT);
        settingsButton.setOnAction(e -> settingsDialog.showAndWait());

        sidebar.getChildren().add(settingsButton);

        BoardContainer boardContainer = new BoardContainer(board);
        setLeft(sidebar);
        setCenter(boardContainer);


    }

    private static class SidebarElement extends HBox {
        public SidebarElement(Node node) {
            setAlignment(Pos.BASELINE_LEFT);
            getChildren().add(node);
        }
    }

    public static class Sidebar extends VBox {
        public Sidebar() {
            setAlignment(Pos.BASELINE_LEFT);
            getStyleClass().add("sidebar");
        }
    }

    public class SettingsDialog extends Dialog<Void> {
        DialogPane main;
        public SettingsDialog() {
            main = new SettingsDialogPane();
            setDialogPane(main);

        }
    }

    private class SettingsDialogPane extends DialogPane {
        public SettingsDialogPane() {
            setPrefSize(200, 300);

            getStylesheets().add(Main.class.getResource("stylesheets/boardsettings.css").toExternalForm());

            BorderPane borderPane = new BorderPane();

            CheckBox showIndex = new CheckBox("show index");
            showIndex.selectedProperty().addListener(e -> board.setShowIndex(showIndex.isSelected()));

            VBox settings = new VBox(5);
            settings.getStyleClass().add("settings-list");
            settings.getChildren().addAll(showIndex);

            borderPane.setCenter(settings);

            Button closeButton = (Button) createButton(ButtonType.OK);

            borderPane.setBottom(closeButton);

            setContent(borderPane);
        }
    }
}
