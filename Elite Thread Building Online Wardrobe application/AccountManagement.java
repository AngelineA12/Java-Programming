package com.EliteThreads.shoppingapp.model;

import java.util.Map;
import java.util.HashMap;

public interface AccountManagement {
    Map<String, String> userCredentials = new HashMap<>();

    void signUp(String username, String gender, int age, String password, String confirmPassword);

    boolean login(String username, String password);
}
