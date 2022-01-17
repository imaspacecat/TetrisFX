package com.dubiner.tetrisfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    private int newX = 230;
    private int newY = 0;
    final int width = 500;
    final int height = 1000;
    final int moveAmount = 20;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tetris");
        primaryStage.setResizable(false);

        Rectangle player = new Rectangle(230, 0, 20, 20);

        Polygon tShape = new Polygon();
        tShape.getPoints().addAll(
                0.0, 0.0,
                150.0, 0.0,
                150.0, 50.0,
                100.0, 50.0,
                100.0, 100.0,
                50.0, 100.0,
                50.0, 50.0,
                0.0, 50.0
        );

//        Rectangle tShape1 = new Rectangle(0, 0, 150, 50);
//        Rectangle tShape2 = new Rectangle(50, 50, 50, 50);
//
//        Group tShape = new Group(tShape1, tShape2);



        Pane canvas = new Pane(player, tShape);

        Scene scene = new Scene(canvas, width, height);

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
            } //else if(e.getCode() == KeyCode.D){
//                newX = checkXBoundaries(newX+moveAmount);
//                tShape.setTranslateX(newX);
//            } else if(e.getCode() == KeyCode.A){
//                newX = checkXBoundaries(newX-moveAmount);
//                tShape.setTranslateX(newX);
//            } else if(e.getCode() == KeyCode.W){
//                newY = checkYBoundaries(newY-moveAmount);
//                tShape.setTranslateY(newY);
//            } else if(e.getCode() == KeyCode.S){
//                newY = checkYBoundaries(newY+moveAmount);
//                tShape.setTranslateY(newY);
//            }
        });



        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }


    private int checkXBoundaries(int newX){
        //instead of 20 subtract the width of the shape (the shape will be a parameter)
        if(newX > width-20){
            return width-20;
        } else if(newX < 0){
            return 0;
        }
        return newX;
    }

    private int checkYBoundaries(int newY){
        //instead of 20 subtract the height of the shape (the shape will be a parameter)
        if(newY > height-20){
            return height-20;
        } else if(newY < 0){
            return 0;
        }
        return newY;
    }




}