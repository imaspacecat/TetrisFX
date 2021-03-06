package com.dubiner.tetrisfx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    private final int recPixelSize = 30;
    private final int width = 10;
    private final int height = 20;
//    Rectangle[][] board = new Rectangle[10][20];
    Group group = new Group();
    Board board = new Board(width, height, recPixelSize, group);


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                board.update();
            }
        };


        timer.scheduleAtFixedRate(task, 500, 500);

        Scene scene = new Scene(group, board.getWidth() * recPixelSize, board.getHeight() * recPixelSize);
//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                if(keyEvent.getCode() == KeyCode.SPACE){
//                    System.out.println("test");
//                }
//            }
//        });
        group.requestFocus();
        group.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                System.out.println(keyEvent.getCode().toString());
            }
        });
        stage.setScene(scene);
        stage.setTitle("Tetris");
        stage.show();
    }

}

