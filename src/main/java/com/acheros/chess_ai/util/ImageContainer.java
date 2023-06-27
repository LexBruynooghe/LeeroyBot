package com.acheros.chess_ai.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class ImageContainer extends Region {
    private final ImageView imageView ;

    public ImageContainer() {
        this.imageView = new ImageView();
        getChildren().add(imageView);
    }

    @Override
    protected void layoutChildren() {
        double width = getWidth();
        double height = getHeight();
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        double imageWidth = imageView.getBoundsInLocal().getWidth();
        double imageHeight = imageView.getBoundsInLocal().getHeight();

        imageView.relocate((width - imageWidth) / 2 , (height - imageHeight) /2);
    }

    public void setImage(Image image) {
        imageView.setImage(image);
    }
}
