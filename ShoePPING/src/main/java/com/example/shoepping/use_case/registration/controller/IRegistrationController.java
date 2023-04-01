package com.example.shoepping.use_case.registration.controller;

import com.example.shoepping.exception.DAOException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface IRegistrationController {
    void onRegistration(String username, String pass, String repass, String email, boolean check) throws SQLException, ClassNotFoundException, IOException, DAOException, CsvValidationException;
}
