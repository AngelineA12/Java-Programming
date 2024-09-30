package com.EliteThreads.shoppingapp;
import java.util.Map;
import java.util.HashMap;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;
import com.EliteThreads.shoppingapp.model.AccountManagement;

import com.EliteThreads.shoppingapp.model.Customer;
import com.EliteThreads.shoppingapp.model.User;
import com.EliteThreads.shoppingapp.model.Category;
import com.EliteThreads.shoppingapp.model.Item;
import com.EliteThreads.shoppingapp.model.ItemType;
import com.EliteThreads.shoppingapp.model.KidsCategory;
import com.EliteThreads.shoppingapp.wardrobe.MenWardrobe;
import com.EliteThreads.shoppingapp.wardrobe.WomenWardrobe;
import com.EliteThreads.shoppingapp.wardrobe.KidsWardrobe;
import com.EliteThreads.shoppingapp.model.Product;
import com.EliteThreads.shoppingapp.ShoppingCart;

public class ShoppingApp implements AccountManagement {
    private ShoppingCart cart;
    private MenWardrobe menWardrobe;
    private WomenWardrobe womenWardrobe;
    private KidsWardrobe kidsWardrobe;
    private Scanner scanner;
     private Map<String, String> cardDetails;

    public ShoppingApp(ShoppingCart cart) {
        this.cart = cart;
         this.cardDetails = new HashMap<>();
        this.menWardrobe = new MenWardrobe(cart);
        this.womenWardrobe = new WomenWardrobe(cart);
        this.kidsWardrobe = new KidsWardrobe(cart);
        this.scanner = new Scanner(System.in);
    }

    

    public void start() {
        System.out.println("=================================================");
        System.out.println("=== Welcome to ELITE THREADS Online Shopping App! ===");
System.out.println(" __        __   _                               ");
System.out.println(" \\ \\      / /__| | ___ ___  _ __ ___   ___ ");
System.out.println("  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ ");
System.out.println("   \\ V  V /  __/ | (_| (_) | | | | | |  __/   ");
System.out.println("    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  "); 
System.out.println("                                                   ");
while (true) {
            System.out.println("==== Please Sign up if you are new user ====");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("=== THANK YOU, VISIT AGAIN ===");
                    System.out.println("** FOLLOW US ON:**");
                    System.out.println("** INSTAGRAM: @elitethreads");
                    System.out.println("** FACEBOOK: @elitethreadsbrd");
                    System.out.println("** OFFICIAL WEBSITE: **");
                    System.out.println("** @elitethreads.com");
                    System.out.println("********Exiting********");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    private boolean premiumMembershipUpdated = false;
    private void signUp() {
        System.out.println("==== Sign Up ====");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter gender: ");
        String gender = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter password: ");
        String password = scanner.next();
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.next();
        signUp(username, gender, age, password, confirmPassword);
        login();
    }

    private void login() {
        System.out.println("==== Login ====");
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        if (login(username, password)) {
            shoppingMenu();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void shoppingMenu() {
        while (true) {
            System.out.println("======== ELITE THREADS ========");
            System.out.println("1. Browse Wardrobe");
            System.out.println("2. View Cart");
            System.out.println("3. Finalize Products");
            System.out.println("4. Update Premium Membership");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    wardrobeMenu();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    finalizeProducts();
                    break;
                case 4:
                    updatePremiumMembership();
                    break;
                case 5:
                    rateApp();
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void wardrobeMenu() {
        System.out.println("==== ELITE WARDROBE =====\n");
        System.out.println("==== PARTNERS FROM LEADING BRANDS ====");
        System.out.println("==== CLOTHING ====");
        System.out.println("Zara, H&M, Forever 21, Gap, Nike, Adidas, Levi's, Ralph Lauren, Tommy Hilfiger, Calvin Klein\n");
        System.out.println("==== JEWLLERY ====");
        System.out.println("Tiffany & Co., Pandora, Swarovski, Cartier, David Yurman, Alex and Ani, Kendra Scott, Bulgari, Chopard, Van Cleef & Arpels\n");
        System.out.println("==== ACCESSOREIES ====");
        System.out.println("Coach, Michael Kors, Kate Spade, Louis Vuitton, Gucci, Fossil, Titan, , Ray-Ban, Oakley, Prada, Hermès\n");
        System.out.println("==== FOOTWEAR ====");
        System.out.println("Nike, Adidas, Puma, Reebok, Converse, Vans, Timberland, Dr. Martens, Birkenstock, Skechers\n");
        System.out.println("======= EXCITING COLLECTIONS AHEAD ======\n");
            for (Category category : Category.values()) {
            System.out.println(category.ordinal() + 1 + ". " + category);
        }
        System.out.println((Category.values().length + 1) + ". Go back to previous options\n");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= Category.values().length) {
            Category selectedCategory = Category.values()[choice - 1];
            switch (selectedCategory) {
                case MEN:
                    menWardrobe.browseWardrobe();
                    break;
                case WOMEN:
                    womenWardrobe.browseWardrobe();
                    break;
                case KIDS:
                    kidsWardrobe.browseWardrobe();
                    break;
            }
        } else if (choice == Category.values().length + 1) {
            // Go back to previous options
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void viewCart() {
        System.out.println("==== Items in Cart: ====");

        if (cart.isEmpty()) {
            System.out.println("No items in the cart.\n");
        } else {
            for (Item item : cart) {
                System.out.println(item.getName() + " - $" + item.getPrice() + "\n");
            }
        }
    }


    private void finalizeProducts() {
                if(cart.isEmpty()){
           System.out.println("No items in the cart.");
           System.out.println("Please add items to your cart before finalizing the product.\n");
         } else{
         viewCart();
        System.out.println("Do you want to continue with the placement of order? (yes/no)");
        String continueOrder = scanner.next();
        if (continueOrder.equalsIgnoreCase("yes")) {
            
            double totalAmount = calculateTotalAmount();
            double gst = calculateGST(totalAmount);
            double deliveryCharges = calculateDeliveryCharges();
            double finalAmount = totalAmount + gst + deliveryCharges;
            System.out.println("==== Your total bill: ====");
            System.out.println("Total Amount: $" + totalAmount);
            System.out.println("GST: $" + gst);
            System.out.println("Delivery Charges: $" + deliveryCharges);
            System.out.println("Final Amount (Including GST and Delivery Charges): $" + finalAmount);
            System.out.println("Do you want to proceed with the payment? (yes/no)");
            String proceedPayment = scanner.next();
            if (proceedPayment.equalsIgnoreCase("yes")) {
                System.out.println("=== Please provide your address details: ===");
                scanner.nextLine(); // Consume newline character
                System.out.print("Door No: ");
                String doorNo = scanner.nextLine();
                System.out.print("Street: ");
                String street = scanner.nextLine();
                System.out.print("City: ");
                String city = scanner.nextLine();
                System.out.print("State: ");
                String state = scanner.nextLine();
                System.out.print("Country: ");
                String country = scanner.nextLine();
                System.out.print("PIN: ");
                int pin = scanner.nextInt();
                
// Set address details
cart.setDoorNo(doorNo);
cart.setStreet(street);
cart.setCity(city);
cart.setState(state);
cart.setCountry(country);
cart.setPin(pin);

                System.out.println("=== Choose payment option: ===");
                System.out.println("1. Online");
                System.out.println("2. Cash on Delivery\n");
                System.out.print("Enter your choice: ");
                int paymentChoice = scanner.nextInt();
                 String deliveryDate = generateDeliveryDate();
                if (paymentChoice == 1) {
                    makeOnlinePayment(deliveryDate);
                    
                } else if (paymentChoice == 2) {
                    makeCashOnDeliveryPayment(deliveryDate);
                                    } else {
                    System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("Order placement cancelled.\n");
            }
        } else {
            System.out.println("Order placement cancelled.\n");
        }
    } 
}

  public double calculateTotalAmount() {
    double totalAmount = 0.0;
    for (Item item : cart.getItems()) {
        totalAmount += item.getPrice();
    }
    return totalAmount;
}


    private double calculateGST(double totalAmount) {
        // Assuming 18% GST
        return 0.18 * totalAmount;
    }

    private double calculateDeliveryCharges() {
        // Assuming fixed delivery charge
        return 10.0;
    }

private void makeOnlinePayment(String deliveryDate) {
    System.out.println("=== Enter card details ===");
    String cardHolderName;
    String cardNumber;
    String cvv;

    if (!cardDetails.isEmpty()) {
        System.out.println("Using the same card details as the previous payment.");
        cardHolderName = cardDetails.get("cardHolderName");
        cardNumber = cardDetails.get("cardNumber");
        cvv = cardDetails.get("cvv");
    } else {
        System.out.print("Card Holder Name: ");
        cardHolderName = scanner.next();
        System.out.print("Card Number (12 digits): ");
        cardNumber = scanner.next();
        if (cardNumber.length() != 12) {
            System.out.println("Invalid card number.");
            return;
        }
        System.out.print("CVV: ");
        cvv = scanner.next();
    }
    cardDetails.put("cardHolderName", cardHolderName);
    cardDetails.put("cardNumber", cardNumber);
    cardDetails.put("cvv", cvv);

    System.out.println("=== Payment completed successfully ===");
    System.out.println("=== Your order placed successfully ===");
    System.out.println("=== Your order will be delivered on: " + deliveryDate + " ===\n");

    // Store card details for premium membership
    cart.setCardUsed(true);
    cart.setCardHolderName(cardHolderName);
    cart.setCardNumber(cardNumber);
    
invoice();
cart.clear();

    updatePremiumMembership();
}
private void makeCashOnDeliveryPayment(String deliveryDate) {
    System.out.println("=== Your order placed successfully ===");
    System.out.println("=== Your order will be delivered on: " + generateDeliveryDate() + " ===\n");

    // Store card details for premium membership
    cart.setCardUsed(false);
    cart.setCardHolderName(null);
    cart.setCardNumber(null);
invoice();
cart.clear();

    // Proceed with premium membership update
    updatePremiumMembership();
}


    
private String generateDeliveryDate() {
    // Generate random delivery date (within 7 days from today)
    Random random = new Random();
    int daysToAdd = random.nextInt(7);
    
    // Get the current date
    LocalDate currentDate = LocalDate.now();
    
    // Add random days to the current date
    LocalDate deliveryDate = currentDate.plusDays(daysToAdd);
    
    // Get the day of the week for the delivery date
    String dayOfWeek = deliveryDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
    
    // Format the delivery date string
    String formattedDeliveryDate = deliveryDate.getDayOfMonth() + " " + deliveryDate.getMonth().toString() + " (" + dayOfWeek + ")";
    
    return formattedDeliveryDate;
}

 private void updatePremiumMembership() {
    System.out.println("=== For Exciting offers, Update yourself as PREMIUM MEMBER ===");
    System.out.println("Do you want to update to premium membership to get exciting offers? (yes/no)");
    String updatePremium = scanner.next();
    if (updatePremium.equalsIgnoreCase("yes")) {
        System.out.println("Choose your plan:");
        System.out.println("1. Monthly - $10");
        System.out.println("2. Annually - $100");
        System.out.print("Enter your choice: ");
        int planChoice = scanner.nextInt();
        double amount = (planChoice == 1) ? 10.0 : 100.0;
        System.out.println("Your total bill: $" + amount);
        System.out.println("Do you want to proceed with the payment? (yes/no)");
        String proceedPayment = scanner.next();
        if (proceedPayment.equalsIgnoreCase("yes")) {
            System.out.println("Please provide your payment details:");
            String cardHolderName;
            String cardNumber;
            String cvv;
            if (cart.isCardUsed()) {
                System.out.println("Do you want to use the card details from the previous transaction? (yes/no)");
                String usePreviousCard = scanner.next();
                if (usePreviousCard.equalsIgnoreCase("yes")) {
                    cardHolderName = cart.getCardHolderName();
                    cardNumber = cart.getCardNumber();
                    cvv = cardDetails.get("cvv"); // Get CVV from stored card details
                    System.out.println("Enter the CVV of the Card: ");
                    String cvv1 = scanner.next();
                    if (cvv1.equals(cvv)) {
                        // Check if CVV matches
                        System.out.println("** PAYMENT COMPLETED SUCCESSFULLY **");
                        System.out.println("** You have become a premium member! **\n");
                    } else {
                        System.out.println("Invalid CVV. Payment failed.\n");
                        return;
                    }
                } else {
                    System.out.print("Card Holder Name: ");
                    cardHolderName = scanner.next();
                    System.out.print("Card Number (12 digits): ");
                    cardNumber = scanner.next();
                    if (cardNumber.length() != 12) {
                        System.out.println("Invalid card number.");
                        return;
                    }
                    System.out.print("CVV: ");
                    cvv = scanner.next();
                    System.out.println("** PAYMENT COMPLETED SUCCESSFULLY **");
                    System.out.println("** You have become a premium member! **\n");
                }
            } else {
                System.out.print("Card Holder Name: ");
                cardHolderName = scanner.next();
                System.out.print("Card Number (12 digits): ");
                cardNumber = scanner.next();
                if (cardNumber.length() != 12) {
                    System.out.println("Invalid card number.");
                    return;
                }
                System.out.print("CVV: ");
                cvv = scanner.next();
                System.out.println("** PAYMENT COMPLETED SUCCESSFULLY **");
                System.out.println("** You have become a premium member! **\n");
            }
        } else {
            System.out.println("** Membership upgrade cancelled **\n");
        }
    } else {
        System.out.println("** Membership not upgraded **\n");
    }
    }

private void invoice() {
    System.out.println("=====================================");
    System.out.println("==== Invoice ====");
    System.out.println("Products Purchased:");
    if (cart.isEmpty()) {
        System.out.println("No items in the cart.");
    } else {
        for (Item item : cart.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }
    double totalAmount = calculateTotalAmount();
    double gst = calculateGST(totalAmount);
    double deliveryCharges = calculateDeliveryCharges();
    double finalAmount = totalAmount + gst + deliveryCharges;
    System.out.println("Total Amount: $" + totalAmount);
    System.out.println("GST: $" + gst);
    System.out.println("Delivery Charges: $" + deliveryCharges);
    System.out.println("Final Amount (Including GST and Delivery Charges): $" + finalAmount);
    
    System.out.println("Payment Method: " + (cart.isCardUsed() ? "Online" : "Cash on Delivery"));
    System.out.println("Address:");
    System.out.println("Door No: " + cart.getDoorNo());
    System.out.println("Street: " + cart.getStreet());
    System.out.println("City: " + cart.getCity());
    System.out.println("State: " + cart.getState());
    System.out.println("Country: " + cart.getCountry());
    System.out.println("PIN: " + cart.getPin());
    
    System.out.println("Delivery Date: " + generateDeliveryDate());
    System.out.println("=====================================");

}
    private void rateApp() {
        System.out.println("=== Rate us! Your stars guide our way! ===");
        System.out.println("Rate our app (1-5):");
        int rating = scanner.nextInt();
        switch (rating) {
            case 1:
            case 2:
                System.out.println("We're sorry to hear that. We'll work to improve our service.\n");
                break;
            case 3:
            case 4:
                System.out.println("Thank you for your rating! We'll continue to enhance our app.\n");
                break;
            case 5:
                System.out.println("Thank you for your 5-star rating! We're glad you enjoy our app.\n");
                break;
            default:
                System.out.println("Invalid rating.\n");
        }
    }



    @Override
    public void signUp(String username, String gender, int age, String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.\n");
            return;
        }
        AccountManagement.userCredentials.put(username, password);
        System.out.println("Account successfully created.\n");
    }

    @Override
    public boolean login(String username, String password) {
        return AccountManagement.userCredentials.containsKey(username) && AccountManagement.userCredentials.get(username).equals(password);
    }
}
