package com.dubiner.tetrisfx;

import javafx.beans.NamedArg;

public interface Tetromino {
    enum Orientation{
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    enum Direction{
        CLOCKWISE,
        COUNTERCLOCKWISE
    }

    // draws a shape on the board with coordinates specifying the origin (center of shape)
    // each implementation will have its own color denoted by an int
    // symbol denotes what value will be placed for each shape coordinate (useful for erasing)
    void draw(int[][] origin, int[][] board, int symbol);

    // rotates the tetromino 90 degrees clockwise or counterclockwise accordingly
    void proportionalRotation(Direction direction);

    // sets the tetromino to a certain orientation: left, right, up, or down
    void absoluteRotation(Orientation orientation);

    // returns a 2d array of the current coordinates of the shape
    // eg: {{1, 2}, {1, 3}, {1, 4}, {2, 3}}
    int[][] getCoordinates(int[][] board);

    // returns the current orientation of the shape
    Orientation getOrientation();

}
