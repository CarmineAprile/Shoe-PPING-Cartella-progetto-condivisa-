package com.example.shoepping;

import com.example.shoepping.use_case.registration.controller.IRegistrationController;
import com.example.shoepping.use_case.registration.controller.RegistrationController;
import com.example.shoepping.use_case.registration.view.IRegistrationView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class RegistrationGController implements IRegistrationView {

    @FXML
    CheckBox checkFS;
    @FXML
    AnchorPane registrationPane;
    @FXML
    TextField registrationUsername;
    @FXML
    TextField registrationPassword;
    @FXML
    TextField registrationRepassword;

    @FXML
    TextField registrationEmail;

    @FXML
    Button signupButton;
    @FXML
    ImageView backButton;
    @FXML
    Label usernameLabel;
    @FXML
    Label passwordLabel;
    @FXML
    Label retypeLabel;
    @FXML
    Label emailLabel;



    public void goBack() throws IOException {
        Parent root;

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, registrationPane);
    }

    public void registration() throws Exception {
        String user = registrationUsername.getText();
        String pass = registrationPassword.getText();
        String repass = registrationRepassword.getText();
        String email = registrationEmail.getText();

        //Serve a "svuotare" le label di errore
        usernameLabel.setText("");
        passwordLabel.setText("");
        retypeLabel.setText("");
        emailLabel.setText("");

        boolean check = checkFS.isSelected();

        IRegistrationController registrationPresenter = new RegistrationController(this);
        registrationPresenter.onRegistration(user,pass,repass,email, check);
    }

    public void maxLenghtUser() {
        final int maxLengthUser = 20;

        if (registrationUsername.getText().length() > maxLengthUser) {
            int pos = registrationUsername.getCaretPosition();
            registrationUsername.setText(registrationUsername.getText(0, maxLengthUser));
            registrationUsername.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtPass() {
        final int maxLengthPass = 20;

        if (registrationPassword.getText().length() > maxLengthPass) {
            int pos = registrationPassword.getCaretPosition();
            registrationPassword.setText(registrationPassword.getText(0, maxLengthPass));
            registrationPassword.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtRepass() {
        final int maxLengthRepass = 20;

        if (registrationRepassword.getText().length() > maxLengthRepass) {
            int pos = registrationRepassword.getCaretPosition();
            registrationRepassword.setText(registrationRepassword.getText(0, maxLengthRepass));
            registrationRepassword.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }

    public void maxLenghtEmail() {
        final int maxLengthEmail = 40;

        if (registrationEmail.getText().length() > maxLengthEmail) {
            int pos = registrationEmail.getCaretPosition();
            registrationEmail.setText(registrationEmail.getText(0, maxLengthEmail));
            registrationEmail.positionCaret(pos); //To reposition caret since setText sets it at the beginning by default
        }
    }


    @Override
    public void onRegistrationSuccess() throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        ChangeWindow cw = new ChangeWindow();
        cw.switchPage(root, registrationPane);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration succesfull");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText("Registration succesfull");

        alert.showAndWait();


    }

    @Override
    public void onRegistrationError(String message, int codeError) {
        switch (codeError) {

            // 0. Check for Username Empty
            // 1. Check for Password Empty
            // 2. Check for Password > 6
            // 3. Check for Repassword Empty
            // 4. Check for corrispondence of Password and Repassword
            // 5. Check for Email Empty
            // 6. Check for Email sintax

            case 0 ->
                usernameLabel.setText(message);

            case 1, 2 ->
                passwordLabel.setText(message);


            case 3 ->
                retypeLabel.setText(message);

            case 4 -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(message);

                // Header Text: null
                alert.setHeaderText(null);
                alert.setContentText(message);

                alert.showAndWait();
            }
            default ->
                emailLabel.setText(message);
        }

    }
}
