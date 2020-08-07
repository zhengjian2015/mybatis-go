package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainStage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello JavaFx and SpringBoot");
        primaryStage.setScene(new Scene(createRoot()));
        primaryStage.show();
    }

    private Parent createRoot() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(DemoApplication.class.getResource("/main.fxml"));
        return fxmlLoader.load();
    }
}
