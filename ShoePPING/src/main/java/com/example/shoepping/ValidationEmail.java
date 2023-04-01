package com.example.shoepping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationEmail {

    private ValidationEmail() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean valEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9-]+\\.[A-Z]{2,6}$";

        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);

        return matcher.find();
    }
}

