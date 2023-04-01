package com.example.shoepping.use_case.registration.controller;


import com.example.shoepping.dao.UserDAOCSV;
import com.example.shoepping.dao.UserDAOJDBC;
import com.example.shoepping.exception.DAOException;
import com.example.shoepping.model.User;
import com.example.shoepping.use_case.registration.view.IRegistrationView;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public class RegistrationController implements IRegistrationController {

    IRegistrationView registrationView;

    public RegistrationController(IRegistrationView registrationView){
        this.registrationView = registrationView;
    }


    @Override
    public void onRegistration(String username, String pass, String repass, String email, boolean check) throws SQLException, ClassNotFoundException, IOException, DAOException, CsvValidationException {

        User user = new User(username, pass, repass, email);
        int registrationCode = user.isValid();

        switch (registrationCode) {
            case 0 -> registrationView.onRegistrationError("Please enter an Username", 0);
            case 1 -> registrationView.onRegistrationError("Please enter a Password", 1);
            case 2 -> registrationView.onRegistrationError("Please enter a Password greater than 6 characters", 2);
            case 3 -> registrationView.onRegistrationError("Please enter the Re-password", 3);
            case 4 -> registrationView.onRegistrationError("Passwords do not match", 4);
            case 5 -> registrationView.onRegistrationError("Please enter an email", 5);
            case 6 -> registrationView.onRegistrationError("Please enter a valid email", 6);
            default -> {
                if (check) {
                    UserDAOCSV userdao = new UserDAOCSV();
                    boolean countUser = userdao.checkExistence(user);

                    if (!countUser) {
                        userdao.addUser(user);
                        registrationView.onRegistrationSuccess();
                    } else {
                        registrationView.onRegistrationError("This username is already taken!", 0);
                    }

                } else {
                    UserDAOJDBC userdao = new UserDAOJDBC();
                    boolean countUser = userdao.checkExistence(user);

                    if (!countUser) {
                        userdao.addUser(user);
                        registrationView.onRegistrationSuccess();
                    } else {
                        registrationView.onRegistrationError("This username is already taken!", 0);
                    }
                }
            }
        }
    }
}
