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


// todo:
//  1. merge Board with TetrisGame

public class TetrisGame extends Application {
    private int newX = 230;
    private int newY = 0;
    public final int WIDTH = 500;
    public final int HEIGHT = 1000;
    final int moveAmount = 20;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tetris");
        primaryStage.setResizable(false);

        Rectangle player = new Rectangle(230, 0, 20, 20);

        player.setFill(new Color(1,0,0,1));

        Pane canvas = new Pane(player);

        Scene scene = new Scene(canvas, WIDTH, HEIGHT);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                newY+=20;
                player.setY(newY);
            }
        };
        timer.scheduleAtFixedRate(task, 0, 500);

        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT){
                newX = checkXBoundaries(newX+moveAmount);
                player.setX(newX);
            } else if(e.getCode() == KeyCode.LEFT){
                newX = checkXBoundaries(newX-moveAmount);
                player.setX(newX);
            } else if(e.getCode() == KeyCode.UP){
                newY = checkYBoundaries(newY-moveAmount);
                player.setY(newY);
            } else if(e.getCode() == KeyCode.DOWN){
                newY = checkYBoundaries(newY+moveAmount);
                player.setY(newY);
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private int checkXBoundaries(int newX){
        //instead of 20 subtract the width of the shape (the shape will be a parameter)
        if(newX > WIDTH -20){
            return WIDTH -20;
        } else if(newX < 0){
            return 0;
        }
        return newX;
    }

    private int checkYBoundaries(int newY){
        //instead of 20 subtract the height of the shape (the shape will be a parameter)
        if(newY > HEIGHT -20){
            return HEIGHT -20;
        } else if(newY < 0){
            return 0;
        }
        return newY;
    }
}
