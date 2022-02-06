package com.dubiner.tetrisfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;

public class TetrisGame extends Application {
    private final int gameWidth = 500; // 500
    private final int gameHeight = 1000; // 1000
    private final int boardWidth = 10; //10
    private final int boardHeight = 20; // 20

    private final Color RECFILL = new Color(1, 1, 1, 1);
    private final Color RECSTROKE = new Color(0, 0, 0, 1);

    private char[][] board = new char[][]{};

    Rectangle[][] rectangleList;

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

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tetris");
        primaryStage.setResizable(false);

        rectangleList = new Rectangle[boardWidth][boardHeight];

        Pane pane = new Pane();

        instantiateRectangles(rectangleList, pane);

        Scene scene = new Scene(pane, gameWidth, gameHeight);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // do gravity
//                updateScreen();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 500);

        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT){
                // move shape right
//                updateScreen();
            } else if(e.getCode() == KeyCode.LEFT){
                // move shape left
//                updateScreen();
            } else if(e.getCode() == KeyCode.UP){
                // rotate shape
//                updateScreen();
            } else if(e.getCode() == KeyCode.DOWN){
                // move shape down
//                updateScreen();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void instantiateRectangles(Rectangle[][] rectangles, Pane pane){
        int xCoord = 0;
        int yCoord = 0;
        for (int x = 0; x < rectangles.length; x++) {
            for (int y = 0; y < rectangles[0].length; y++) {
                System.out.println("x is: " + xCoord + " and y is: " + yCoord);
                rectangles[x][y] = new Rectangle(xCoord, yCoord, gameWidth / boardWidth, gameHeight / boardHeight);
                yCoord+= gameHeight / boardHeight;
                rectangles[x][y].setFill(RECFILL);
                rectangles[x][y].setStrokeWidth(2);
                rectangles[x][y].setStroke(RECSTROKE);
                pane.getChildren().add(rectangles[x][y]);
            }
            xCoord+= gameWidth / boardWidth;
            yCoord = 0;
        }
    }

    // iterate through board and fill squares correspondingly
    private void updateScreen() {
        for (int x = 0; x < rectangleList.length; x++) {
            for (int y = 0; y < rectangleList[0].length; y++) {
                switch(board[x][y]){
                    case '-': // empty squares
                        break;
                    case '*': // shapes not controlled by player
                        rectangleList[x][y].setFill(Color.RED);
                    case '%': // active block (current shape controlled by player)
                        rectangleList[x][y].setFill(Color.GREEN);
                }
            }
        }
    }
}
