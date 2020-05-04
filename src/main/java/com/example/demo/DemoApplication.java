package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.security.auth.login.Configuration;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication extends Application{

	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(DemoApplication.class, args);
		Application.launch(DemoApplication.class,args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello JavaFx and SpringBoot");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.setScene(new Scene(createRoot()));
		primaryStage.show();
	}

	private Parent createRoot() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(DemoApplication.class.getResource("/main.fxml"));
		//这里就用到了springboot
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		return fxmlLoader.load();
	}
}
