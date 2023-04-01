package com.example.shoepping;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BuyUserGController{

    public String username = "";

    @FXML
    HBox sellButton;
    @FXML
    ImageView userIcon;
    @FXML
    Button nikeButton;
    @FXML
    Button adidasButton;
    @FXML
    Button newBalanceButton;
    @FXML
    Button catalogButton;

    public void salva(String username){
        this.username = username;
    }


    public void onNike() {
        System.out.println("nike");
    }


    public void onAdidasClick() {
        System.out.println("adidas");
    }


    public void onNewBalanceClick() {
        System.out.println("newBalance");
    }

    public void onProfileClick() {
        System.out.println(username);
    }

    public void onSellClick() {
        System.out.println("sell");
    }

    public void onCatalogClick() {
        System.out.println("catalog");
    }
}
