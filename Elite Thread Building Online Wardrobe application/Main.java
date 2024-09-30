package com.EliteThreads.shoppingapp;

import com.EliteThreads.shoppingapp.model.AccountManagement;
import com.EliteThreads.shoppingapp.model.Customer;
import com.EliteThreads.shoppingapp.model.User;

import com.EliteThreads.shoppingapp.ShoppingApp;
import com.EliteThreads.shoppingapp.ShoppingCart;



public class Main {
    public static void main(String[] args) {
        // Create a ShoppingCart object and make it accessible throughout the session
        ShoppingCart shoppingCart = new ShoppingCart();

        // Pass the ShoppingCart object to the ShoppingApp constructor
        ShoppingApp shoppingApp = new ShoppingApp(shoppingCart);

        // Start the application
        shoppingApp.start();
    }
}
