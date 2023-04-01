package com.example.shoepping.dao;

import com.example.shoepping.model.User;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;



public class UserDAOCSV implements UserDao {

    private static final String CSV_FILE_NAME = "usersDBFile.csv";

    private final File fd;

    static final int USERNAME_INDEX = 0;
    static final int PASSWORD_INDEX = 1;
    static final int EMAIL_INDEX = 2;

    public UserDAOCSV(){
        this.fd = new File(CSV_FILE_NAME);
    }


    @Override
    public boolean checkLogin(User instance) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new BufferedReader(new FileReader(fd)));
        String[] rec;
        boolean exist = false;

        while ((rec = csvReader.readNext()) != null) {

            boolean recordFound = (rec[USERNAME_INDEX].equals(instance.getUsername()) && rec[PASSWORD_INDEX].equals(instance.getPassword()));
            if (recordFound) {
                exist = true;
            }
        }
        csvReader.close();

        return exist;
    }

    @Override
    public boolean checkExistence(User instance) throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new BufferedReader(new FileReader(fd)));
        String[] rec;
        boolean exist = false;

        while ((rec = csvReader.readNext()) != null) {

            boolean recordFound = rec[USERNAME_INDEX].equals(instance.getUsername());
            if (recordFound) {
                exist = true;
            }
        }
        csvReader.close();

        return exist;
    }

    @Override
    public void addUser(User instance) throws IOException {
        // create csvWriter object passing file reader as a parameter
        CSVWriter csvWriter = new CSVWriter(new BufferedWriter(new FileWriter(fd, true)));

        String[] rec = new String[3];

        rec[USERNAME_INDEX] = String.valueOf(instance.getUsername());
        rec[PASSWORD_INDEX] = instance.getPassword();
        rec[EMAIL_INDEX] = instance.getEmail();


        csvWriter.writeNext(rec);
        csvWriter.flush();
        csvWriter.close();
    }


}
