module com.acheros.chess_ai {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.acheros.chess_ai to javafx.fxml;
    exports com.acheros.chess_ai;
    exports com.acheros.chess_ai.UIcomponents;
    opens com.acheros.chess_ai.UIcomponents to javafx.fxml;
}