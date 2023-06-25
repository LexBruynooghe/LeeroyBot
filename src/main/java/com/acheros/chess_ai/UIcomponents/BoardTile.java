package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.UIcomponents.pieces.Piece;
import com.acheros.chess_ai.models.BoardStateModel;
import com.acheros.chess_ai.util.PieceUtil;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.Serializable;

public class BoardTile extends StackPane implements InvalidationListener {

    private Piece piece;
    private final ImageView imageView;
    private final BoardStateModel model;
    private final int index;
    private final Label indexLabel;

    public BoardTile(boolean white, int index, BoardStateModel model) {
        getStyleClass().addAll("BoardTile", white ? "white" : "black");

        imageView = new ImageView();
        imageView.fitWidthProperty().bind(widthProperty());
        imageView.fitHeightProperty().bind(heightProperty());

        this.model = model;
        this.index = index;

        indexLabel = new Label(index + "");
        indexLabel.setTextFill(Color.MAGENTA);
        widthProperty().addListener(observable -> indexLabel.setFont(Font.font( "Verdana",FontWeight.SEMI_BOLD,getWidth() / 2)));
        indexLabel.setVisible(false);

        getChildren().addAll(imageView, indexLabel);

        setOnDragDetected(this::dragDetected);
        setOnDragOver(this::dragOver);
        setOnDragDropped(this::dragDropped);
        setOnDragDone(this::dragDone);
    }

    private static final DataFormat CUSTOM_PIECE = new DataFormat("custom/piece");

    private void dragDropped(DragEvent e) {
        setPiece((Piece) e.getDragboard().getContent(CUSTOM_PIECE));
        e.setDropCompleted(true);
        e.consume();
    }

    private void dragDetected(MouseEvent e) {
        if (piece != null) {
            Dragboard db = startDragAndDrop(TransferMode.MOVE);
            ClipboardContent cc = new ClipboardContent();
            cc.put(CUSTOM_PIECE, piece);
            Image image = piece.getImageOfSize(getWidth());
            db.setDragView(image);
            db.setDragViewOffsetX(getWidth() / 2);
            db.setDragViewOffsetY(getHeight() / 2);

            db.setContent(cc);
            e.consume();
        }
    }

    private void dragDone(DragEvent e) {
        if (e.isAccepted()) {
            setPiece(null);
        }
        e.consume();
    }


    private void dragOver(DragEvent e) {
        if (e.getGestureSource() != this && (piece == null || piece.isWhite() != ((Piece) e.getDragboard().getContent(CUSTOM_PIECE)).isWhite()) && e.getDragboard().hasContent(CUSTOM_PIECE)) {
            e.acceptTransferModes(TransferMode.MOVE);
        }
        e.consume();
    }



    @Override
    public void invalidated(Observable observable) {
        setPiece(model.get(index));
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        if (this.piece != piece) {
            this.piece = piece;
            imageView.setImage(piece == null ? null : piece.getImage());
        }
    }

    public void clear() {
        this.piece = null;
        imageView.setImage(null);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
