package com.example.shoepping;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SplashGController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    static final Image image = new Image(new File("src/main/resources/drawable/iconapp.png").toURI().toString());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new SplashScreen().start();
    }

    class SplashScreen extends Thread{
        @Override
        public void run(){

            // fare la gestione dell'ecezione personalizzata
            try{
                Thread.sleep(2000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root;
                        try {
                            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
                        } catch (IOException e) {
                            throw new WrongThreadException(e);
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                        //lock dimension of window
                        stage.setResizable(false);
                        stage.setTitle("Welcome! Please login");

                        //set icon in stage
                        stage.getIcons().add(image);

                        rootPane.getScene().getWindow().hide();
                    }
                });

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
