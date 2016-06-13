package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyJavaFx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btnOk = new Button("OK");
        Scene scene = new Scene(btnOk, 200, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MyJavaFX");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
