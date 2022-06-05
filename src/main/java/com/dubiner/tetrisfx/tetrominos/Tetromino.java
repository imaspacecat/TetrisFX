package com.dubiner.tetrisfx.tetrominos;

import javafx.scene.paint.Color;

public interface Tetromino {

    Color getColor();

    int[][] getInitialCoordinates(int[] origin);
}
