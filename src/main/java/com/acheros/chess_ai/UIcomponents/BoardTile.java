package com.acheros.chess_ai.UIcomponents;

import com.acheros.chess_ai.pieces.Piece;
import com.acheros.chess_ai.models.BoardStateModel;
import com.acheros.chess_ai.util.ImageContainer;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BoardTile extends StackPane implements InvalidationListener {

    private Piece piece;
    private final ImageContainer imageView;
    private final BoardStateModel boardState;
    private final int index;
    private final Label indexLabel;

    public BoardTile(boolean white, int index, BoardStateModel model) {

        getStyleClass().addAll("BoardTile", white ? "white" : "black");

        imageView = new ImageContainer();

        this.boardState = model;
        boardState.addListener(this);

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
        setOnDragEntered(this::dragEntered);
        setOnDragExited(this::dragExited);
    }


    private static final DataFormat CUSTOM_PIECE = new DataFormat("custom/piece");

    private void dragDropped(DragEvent e) {
        boardState.set(index,(Piece) e.getDragboard().getContent(CUSTOM_PIECE));
        e.setDropCompleted(true);
        e.consume();
    }

    private void dragDetected(MouseEvent e) {
        if (piece != null) {
            Dragboard db = startDragAndDrop(TransferMode.MOVE);
            ClipboardContent cc = new ClipboardContent();
            cc.put(CUSTOM_PIECE, piece);
            Image image = piece.getImageOfSize(getWidth() * 1.2);
            db.setDragView(image);
            db.setDragViewOffsetX(getWidth() / 2);
            db.setDragViewOffsetY(getHeight() / 2);
            getStyleClass().add("dragAndDropSource");

            db.setContent(cc);
            e.consume();
        }
    }

    private void dragDone(DragEvent e) {
        if (e.isAccepted()) {
            boardState.set(index, null);
        }
        getStyleClass().remove("dragAndDropSource");
        e.consume();
    }


    private void dragOver(DragEvent e) {
        if (e.getGestureSource() != this && (piece == null || piece.isWhite() != ((Piece) e.getDragboard().getContent(CUSTOM_PIECE)).isWhite()) && e.getDragboard().hasContent(CUSTOM_PIECE)) {
            e.acceptTransferModes(TransferMode.MOVE);
        }
        e.consume();
    }

    private void dragEntered(DragEvent e) {
        if (e.getGestureSource() != this && (piece == null || piece.isWhite() != ((Piece) e.getDragboard().getContent(CUSTOM_PIECE)).isWhite()) && e.getDragboard().hasContent(CUSTOM_PIECE)) {
            getStyleClass().add("hovered");
        }
        e.consume();
    }
    private void dragExited(DragEvent dragEvent) {
        getStyleClass().remove("hovered");
    }

    @Override
    public void invalidated(Observable observable) {
        setPiece(boardState.get(index));
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
}
