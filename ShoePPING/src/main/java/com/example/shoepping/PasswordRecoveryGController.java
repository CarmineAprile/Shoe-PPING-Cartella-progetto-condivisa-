package com.example.shoepping;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class PasswordRecoveryGController {

    @FXML
    TextField recoveryUsername;

    @FXML
    Button recoverButton;

    @FXML
    ImageView backButton;
    @FXML
    AnchorPane recoveryPane;
    @FXML
    TextField recoveryEmail;

    public void goBack() throws IOException {
        Parent root;

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, recoveryPane);
    }


    public void sendPassword() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("E-mail sent!");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("We have sended an e-mail to reset password.");

        alert.showAndWait();
    }

    public void maxLenghtUser() {
        final int maxLengthUser = 20;

        if (recoveryUsername.getText().length() > maxLengthUser) {
            int pos = recoveryUsername.getCaretPosition();
            recoveryUsername.setText(recoveryUsername.getText(0, maxLengthUser));
            recoveryUsername.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtEmail() {
        final int maxLengthEmail = 40;

        if (recoveryEmail.getText().length() > maxLengthEmail) {
            int pos = recoveryEmail.getCaretPosition();
            recoveryEmail.setText(recoveryEmail.getText(0, maxLengthEmail));
            recoveryEmail.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }
}
