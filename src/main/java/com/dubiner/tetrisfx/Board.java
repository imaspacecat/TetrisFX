package com.dubiner.tetrisfx;

public class Board {
    private int width;
    private int height;

    private char[][] board;

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        board = new char[width][height];

        clearBoard();
    }

    public void clearBoard(){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                board[x][y] = '-';
            }
        }
    }

    public void printBoard(){
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }
}

