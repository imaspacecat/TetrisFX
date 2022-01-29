package com.dubiner.tetrisfx;

public interface Tetromino {
    enum Rotation{
        LEFT,
        RIGHT
    }

    enum Direction{
        LEFT,
        RIGHT,
        DOWN
    }

    // rotates the shape left 90 deg or right 90 deg both in the array and visually
    void rotate(Rotation rotation);

    // returns the coordinates of the shape in the array in the format {{x1, y1},{x2, y2},{x3, y3}, etc}
    int[][] getCoordinates();

    // moves the shape units left or right; pos for right and neg for left
    // moves both visually and in the array
//    default void move(Direction direction, int units){
////        for (int x = 0; x < ; x++) {
////            for (int y = 0; y < ; y++) {
////
////            }
////        }
//    }

    // returns true if the shape overlaps another in the array
    // always use this function before moving the shape visually
    boolean isColliding();

    // records the position of the tetromino on array for later use (row detection and collision)
    // resets position of tetromino and spawns new shape
    void kill();

    //resets the position of the shape to the starting point and randomizes the shape and color
    void spawn();

    void createTetromino(int x, int y);






}
