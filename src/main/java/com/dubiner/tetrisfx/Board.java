package com.dubiner.tetrisfx;

import com.dubiner.tetrisfx.tetrominos.*;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import java.util.Random;
import java.util.ArrayList;

public class Board {
    private final int width;
    private final int height;
    private final RectangleMod[][] board;
    private final int recPixelSize;
    private final int activeFlag = 0;
    private final int[] origin = new int[] {0, 0};
    private Group group;

    private Random random = new Random();

    private final Tetromino[] shapes = new Tetromino[] {new TShape(), new IShape(), new JShape(), new LShape(),
    new OShape(), new SShape(), new ZShape()};

    private Tetromino currentShape = shapes[random.nextInt(7)];

    public Board(int width, int height, int recPixelSize, Group group){
        this.width = width;
        this.height = height;
        this.recPixelSize = recPixelSize;
        this.group = group;
        board = new RectangleMod[width][height];
        initBoard();
    }

    private void moveShapes(){

        // stores all the rectangles that need to be moved
        ArrayList<RectangleMod> recToMove = new ArrayList<>();

        // iterate over all rectangles in board
        outer: for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length-1; j++) {
                if(board[i][j].getFlag() == 1){
                    continue;
                }
                if(board[i][j].getFill() != Color.BLACK){
                    if(board[i][j+1].getFill() == Color.BLACK || board[i][j+1].getFlag() == 0){
                        // save rectangles in list to be changed later
                        recToMove.add(board[i][j]);
                        recToMove.add(board[i][j+1]);

                    } else{
                        // set all non-black rectangles with a flag of 1 (inactive)
                        for (int k = 0; k < board.length; k++) {
                            for (int l = 0; l < board[0].length; l++) {
                                if(board[k][l].getFill() != Color.BLACK){
                                    board[k][l].setFlag(1);
                                } else{
                                    board[k][l].setFlag(0);
                                }
                            }
                        }
                        // clear list of rectangles to move
                        recToMove.clear();
                        // leave loop
                        break outer;
                    }
                }
            }
        }

        for(int i = 0; i < recToMove.size(); i++) {
            if(recToMove.get(i).getFill() == Color.BLACK){
                recToMove.get(i).setFill(currentShape.getColor());
            } else{
                recToMove.get(i).setFill(Color.BLACK);
            }
//            recToMove.get(i).setFill(Color.RED);
        }
    }

    private void clearRow(){
        int rowCount = 0;
        // erase row at bottom
        // improve efficiency later (put in other loop)
        for(int k = 0; k < board.length; k++) {
            if (board[k][height - 1].getFill() != Color.BLACK){
                rowCount++;
                board[k][height-1].setFlag(1);
                if (rowCount == width) {
                    // erase row
                    for (int i = 0; i < board.length; i++) {
                        board[i][height - 1].setFill(Color.BLACK);
                    }

                    // increase score

                }
            }
        }
        rowCount = 0;
    }

    private void spawnNewShape(){
        int activeCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j].getFill() != Color.BLACK && board[i][j].getFlag() == 0){
                    activeCount++;
                }
            }
        }
        if(activeCount == 0){
            currentShape = shapes[random.nextInt(7)];
            drawShape(currentShape);
        }
    }

    public void update(){

        moveShapes();
        clearRow();
        spawnNewShape();


    }

    // create matrix of Rectangle objects with specified pixel size

    private void initBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new RectangleMod(0, i * recPixelSize, j * recPixelSize, recPixelSize, recPixelSize);
                board[i][j].setFill(Color.BLACK);
                board[i][j].setStrokeWidth(2);
                board[i][j].setStroke(Color.WHITE);
                // add all rectangles to Group object, so they can be rendered in the scene
                group.getChildren().add(board[i][j]);
            }
        }

        board[0][19].setFill(Color.RED);
        board[2][19].setFill(Color.RED);
        board[3][19].setFill(Color.RED);
        board[4][19].setFill(Color.RED);
        board[5][19].setFill(Color.RED);
        board[6][19].setFill(Color.RED);
        board[7][19].setFill(Color.RED);
        board[8][19].setFill(Color.RED);
        board[9][19].setFill(Color.RED);

        drawShape(currentShape);
    }

    public void drawShape(Tetromino shape){
        for (int i = 0; i < shape.getInitialCoordinates(origin).length; i++) {
            board[shape.getInitialCoordinates(origin)[i][0]]
                    [shape.getInitialCoordinates(origin)[i][1]].setFill(shape.getColor());
            board[shape.getInitialCoordinates(origin)[i][0]]
                    [shape.getInitialCoordinates(origin)[i][1]].setFlag(0);
        }
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
