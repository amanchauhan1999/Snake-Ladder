package com.example.snakeandladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class tile extends Rectangle{
    public tile(int tilesize){
        setWidth(tilesize);
        setHeight(tilesize);
        setFill(Color.LAVENDER);
        setStroke(Color.BLACK);
    }
}
