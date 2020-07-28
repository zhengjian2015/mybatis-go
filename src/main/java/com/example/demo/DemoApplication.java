package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * javafx 下载路径：
 * https://www.oracle.com/java/technologies/javafxscenebuilder-1x-archive-downloads.html
 *
 * javafx 安装教程
 * https://blog.csdn.net/corleone_4ever/article/details/104461476?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.compare&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.compare
 *
 *
 *
 *
 */
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
		//primaryStage.setWidth(680);
		//primaryStage.setHeight(450);
		primaryStage.resizableProperty().setValue(Boolean.FALSE);
		primaryStage.setScene(new Scene(createRoot()));
		primaryStage.show();

	}

	private Parent createRoot() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader();
		//fxmlLoader.setLocation(DemoApplication.class.getResource("/main.fxml"));
		fxmlLoader.setLocation(DemoApplication.class.getResource("/login.fxml"));
		//这里就用到了springboot
		fxmlLoader.setControllerFactory(applicationContext::getBean);
		return fxmlLoader.load();
	}
}
