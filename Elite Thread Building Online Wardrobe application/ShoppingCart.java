package com.EliteThreads.shoppingapp;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import com.EliteThreads.shoppingapp.model.Product;
import com.EliteThreads.shoppingapp.model.Item;

public class ShoppingCart implements Iterable<Item> {
    private List<Item> items;
    private boolean cardUsed;
    private String cardHolderName;
    private String cardNumber;
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private int pin;


    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }
    public void clear() {
    items.clear();
}
    public boolean isCardUsed() {
        return cardUsed;
    }

    public void setCardUsed(boolean cardUsed) {
        this.cardUsed = cardUsed;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    // Add getters and setters for address details
    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void viewCart() {
        System.out.println("Items in Cart:");
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }
}
