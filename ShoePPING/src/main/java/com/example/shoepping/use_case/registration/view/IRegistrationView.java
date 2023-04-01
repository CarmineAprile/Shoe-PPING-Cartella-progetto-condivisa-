package com.example.shoepping.use_case.registration.view;

import java.io.IOException;

public interface IRegistrationView {

    void onRegistrationSuccess() throws IOException;

    void onRegistrationError(String message, int codeError);
}
