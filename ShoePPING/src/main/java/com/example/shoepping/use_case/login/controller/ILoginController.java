package com.example.shoepping.use_case.login.controller;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;

public interface ILoginController {

    // aggiungere gestione personalizzata dell'eccezione
    void onLogin(String username, String pass, boolean check) throws SQLException, ClassNotFoundException, IOException, CsvValidationException;
}
