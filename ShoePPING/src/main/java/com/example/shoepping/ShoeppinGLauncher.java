package com.example.shoepping;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ShoeppinGLauncher extends Application {

    static Stage stage = null;

    @Override
    public void start(Stage stage) throws IOException {
        //remove window decoration

        stage.initStyle(StageStyle.UNDECORATED);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("splash-screen.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        set(stage);

        //set icon in stage
        Image image = new Image(new File("src/main/resources/drawable/iconapp.png").toURI().toString());
        stage.getIcons().add(image);
    }


    public static void set(Stage stage){
        ShoeppinGLauncher.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}