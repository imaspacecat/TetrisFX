package com.dubiner.tetrisfx.tetrominos;

import javafx.scene.paint.Color;

public class IShape implements Tetromino {
    @Override
    public Color getColor() {
        return Color.TURQUOISE;
    }

    @Override
    public int[][] getInitialCoordinates(int[] origin) {
        return new int[][] {{origin[0] + 0, origin[1] + 0}, {origin[0] + 1, origin[1] + 0},
                {origin[0] + 2, origin[1] + 0}, {origin[0] + 3, origin[1] + 0}};
    }
}
