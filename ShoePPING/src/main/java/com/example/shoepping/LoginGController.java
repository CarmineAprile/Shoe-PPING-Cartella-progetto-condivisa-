package com.example.shoepping;

import com.example.shoepping.use_case.login.controller.ILoginController;
import com.example.shoepping.use_case.login.controller.LoginController;
import com.example.shoepping.use_case.login.view.ILoginView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.Objects;

public class LoginGController implements ILoginView {
    @FXML
    CheckBox checkFS;
    @FXML
    TextField loginUsername;
    @FXML
    Label usernameLabel;
    @FXML
    TextField loginPassword;
    @FXML
    Label passwordLabel;
    @FXML
    Text forgotPassword;
    @FXML
    Button loginButton;
    @FXML
    ImageView googleLogo;
    @FXML
    Text createProfile;
    @FXML
    AnchorPane loginPane;



    public void passwordRecovery() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("password-recovery-view.fxml")));
        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, loginPane);
    }

    public void login() throws Exception {
        String user = loginUsername.getText();
        String pass = loginPassword.getText();

        //Serve a "svuotare" le label di errore
        usernameLabel.setText("");
        passwordLabel.setText("");

        boolean check = checkFS.isSelected();

        ILoginController loginPresenter = new LoginController(this);
        loginPresenter.onLogin(user, pass, check);
    }

    public void googleLogin() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login with Google");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Work in progress...");

        alert.showAndWait();
    }

    public void registration() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registration-view.fxml")));
        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, loginPane);
    }

    public void onLoginSuccessUser() throws IOException {

        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("buy-user-view.fxml")));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("buy-user-view.fxml"));
        Parent root = loader.load();

        BuyUserGController buyUserGController = loader.getController();
        buyUserGController.salva(loginUsername.getText());

        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, loginPane);
    }

    public void onLoginSuccessAdmin(){
        System.out.println("Sei l'amministratore, benvenuto.");
    }


    @Override
    public void onLoginError(String message, int codeError) {
        // codeError = 0, manca username
        // codeError = 1, manca password
        // codeError = 2, password lenght <=6
        // codeError = 3, login failed

        switch (codeError) {
            case 0 -> usernameLabel.setText(message);
            case 1, 2 -> passwordLabel.setText(message);
            default ->{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(message);

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText(message);

                alert.showAndWait();
            }
        }

    }

    public void maxLenghtUser() {

        final int maxLengthUser = 20;

        if (loginUsername.getText().length() > maxLengthUser) {
            int pos = loginUsername.getCaretPosition();
            loginUsername.setText(loginUsername.getText(0, maxLengthUser));
            loginUsername.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtPass() {

        final int maxLengthPass = 20;

        if (loginPassword.getText().length() > maxLengthPass) {
            int pos = loginPassword.getCaretPosition();
            loginPassword.setText(loginPassword.getText(0, maxLengthPass));
            loginPassword.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }
}
