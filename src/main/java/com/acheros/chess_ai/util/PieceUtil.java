package com.acheros.chess_ai.util;

import com.acheros.chess_ai.Main;
import com.acheros.chess_ai.pieces.*;
import javafx.scene.image.Image;

import java.util.Map;

public class PieceUtil {
    private static final Map<Class<? extends Piece>, PieceImage> class2PieceImages = Map.of(
            King.class, new PieceImage(toImgDefault("king_black.png"), toImgDefault("king_white.png")),
            Queen.class, new PieceImage(toImgDefault("queen_black.png"), toImgDefault("queen_white.png")),
            Rook.class, new PieceImage(toImgDefault("rook_black.png"), toImgDefault("rook_white.png")),
            Bishop.class, new PieceImage(toImgDefault("bishop_black.png"), toImgDefault("bishop_white.png")),
            Knight.class, new PieceImage(toImgDefault("knight_black.png"), toImgDefault("knight_white.png")),
            Pawn.class, new PieceImage(toImgDefault("pawn_black.png"), toImgDefault("pawn_white.png"))
    );

    public static Image getImage(Class<? extends Piece> pieceClass, boolean white) {
        return class2PieceImages.get(pieceClass).get(white);
    }

    private static Image toImgOfSize(String filename, double size) {
        return new Image(Main.class.getResource("images/" + filename).toExternalForm(), size, size, false, true);
    }

    private static Image toImgDefault(String filename) {
        return new Image(Main.class.getResource("images/" + filename).toExternalForm(), 1000.0, 1000.0, false, true);
    }

    public static Image getImageOfSize(String name, boolean white, double v) {
        return toImgOfSize(name + (white? "_white" : "_black") + ".png", v);
    }

    private record PieceImage(Image black, Image white) {
        public Image get(boolean w) {
            return w ? white : black;
        }
    }
}
