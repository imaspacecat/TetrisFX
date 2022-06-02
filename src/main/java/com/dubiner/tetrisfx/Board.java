package com.dubiner.tetrisfx;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Board {
    private final int width;
    private final int height;
    private final RectangleMod[][] board;
    private final int recPixelSize;
    private final int activeFlag = 0;



    public Board(int width, int height, int recPixelSize){
        this.width = width;
        this.height = height;
        this.recPixelSize = recPixelSize;
        board = new RectangleMod[width][height];
    }

    // create matrix of Rectangle objects with specified pixel size
    public void initBoard(Group group){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new RectangleMod(activeFlag, i * recPixelSize, j * recPixelSize, recPixelSize, recPixelSize);
                board[i][j].setFill(Color.BLACK);
                board[i][j].setStrokeWidth(2);
                board[i][j].setStroke(Color.WHITE);
                // add all rectangles to Group object, so they can be rendered in the scene
                group.getChildren().add(board[i][j]);
            }
        }

        board[0][0].setFill(Color.RED);
        board[1][0].setFill(Color.RED);
        board[2][0].setFill(Color.RED);
        board[3][0].setFill(Color.RED);
        board[4][0].setFill(Color.RED);
        board[5][0].setFill(Color.RED);
        board[6][0].setFill(Color.RED);
        board[7][0].setFill(Color.RED);
        board[8][0].setFill(Color.RED);
        board[9][0].setFill(Color.RED);


        board[1][2].setFill(Color.RED);
        board[2][2].setFill(Color.RED);
        board[3][2].setFill(Color.RED);
        board[4][2].setFill(Color.RED);
        board[5][2].setFill(Color.RED);
        board[6][2].setFill(Color.RED);
        board[7][2].setFill(Color.RED);
        board[8][2].setFill(Color.RED);
        board[9][2].setFill(Color.RED);
        board[0][0].setFill(Color.RED);
        board[0][1].setFill(Color.RED);

    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void update(){
        ArrayList<Rectangle> recToMove = new ArrayList<>();

        int rowCount = 0;

        outer: for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                // erase red squares and save new square to paint in list
                if(j != board[0].length-1) {
//                    if(board[i][j].getFill() != Color.BLACK && board[i][j+1].getFill() != Color.RED) {
                        if(board[i][j].getFill() != Color.BLACK){
                            if(board[i][j+1].getFill() != Color.RED || board[i][j+1].getFlag() == 0){
                                recToMove.add(board[i][j]);
                                recToMove.add(board[i][j+1]);
                            } else{
                                recToMove.clear();
                                break outer;
                            }
                        }
//                        board[i][j].setFill(Color.BLACK);


                }
            }
        }

        for(int i = 0; i < recToMove.size(); i++) {
            if(recToMove.get(i).getFill() == Color.RED){
                recToMove.get(i).setFill(Color.BLACK);
            } else{
                recToMove.get(i).setFill(Color.RED);
            }
//            recToMove.get(i).setFill(Color.RED);
        }


        // erase row at bottom
        // improve efficiency later (put in other loop)
        for(int k = 0; k < board.length; k++) {
            if (board[k][height - 1].getFill() == Color.RED){
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
}
