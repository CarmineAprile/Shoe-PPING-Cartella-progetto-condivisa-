package com.example.shoepping;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

import static com.example.shoepping.SplashGController.image;

public class ChangeWindow {

    public void switchPage(Parent root, AnchorPane pane){
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        //lock dimension of window
        stage.setResizable(false);
        stage.setTitle("ShoePPING");

        //set icon in stage
        stage.getIcons().add(image);
        stage.show();

        pane.getScene().getWindow().hide();
    }

}
