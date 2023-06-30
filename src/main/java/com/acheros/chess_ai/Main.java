package com.acheros.chess_ai;

import com.acheros.chess_ai.UIcomponents.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        MainPane mainPane = new MainPane();
        Scene scene = new Scene(mainPane,1000,600);
        stage.setTitle("ChessAI userinterface v0.1");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}