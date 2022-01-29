package com.dubiner.tetrisfx;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class TetrominoShapes {

    final int RECWIDTH = 50;
    final int RECHEIGHT = 50;

    class TShape implements Tetromino{
        Rectangle a = new Rectangle(0, 0, RECWIDTH, RECHEIGHT);
        Rectangle b = new Rectangle(RECWIDTH, 0, RECWIDTH, RECHEIGHT);
        Rectangle c = new Rectangle(RECWIDTH*2, 0, RECWIDTH, RECHEIGHT);
        Rectangle d = new Rectangle(RECWIDTH, RECHEIGHT, RECWIDTH, RECHEIGHT);

        Group group = new Group(a, b, c, d);

//        canvas.getChildren().add(group);


        @Override
        public void rotate(Rotation rotation) {

        }

        @Override
        public int[][] getCoordinates() {
            return new int[0][];
        }

        @Override
        public boolean isColliding() {
            return false;
        }

        @Override
        public void kill() {

        }

        @Override
        public void spawn() {

        }

        @Override
        public void createTetromino(int x, int y) {

        }
    }

}


