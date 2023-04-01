package com.example.shoepping.use_case.login.view;

import java.io.IOException;

public interface ILoginView {

    void onLoginSuccessUser() throws IOException;
    void onLoginSuccessAdmin();
    void onLoginError(String message, int codeError);
}
