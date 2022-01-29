package com.dubiner.tetrisfx;

public class Main {


    public static void main(String[] args)  {
        Board board = new Board(10, 20);
        board.printBoard();

        TetrisGame.launch(TetrisGame.class);
    }




}
