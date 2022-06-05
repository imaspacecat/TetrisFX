package com.dubiner.tetrisfx.tetrominos;

import javafx.scene.paint.Color;

public class JShape implements Tetromino{
    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    @Override
    public int[][] getInitialCoordinates(int[] origin) {
        return new int[][] {{origin[0] + 0, origin[1] + 0}, {origin[0] + 0, origin[1] + 1},
                {origin[0] + 1, origin[1] + 1}, {origin[0] + 2, origin[1] + 1}};
    }
}
