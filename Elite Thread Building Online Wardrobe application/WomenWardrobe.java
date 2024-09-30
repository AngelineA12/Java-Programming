package com.EliteThreads.shoppingapp.wardrobe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.EliteThreads.shoppingapp.model.Item;
import com.EliteThreads.shoppingapp.model.WomenItemType;
import com.EliteThreads.shoppingapp.ShoppingCart;

public class WomenWardrobe {
    private Map<WomenItemType, List<Item>> wardrobe;
   
    private ShoppingCart cart;

    public WomenWardrobe(ShoppingCart cart) {
        this.cart = cart;
        this.wardrobe = new HashMap<>(); // Initialize the wardrobe map
        initializeWardrobe();

    }
    

    private void initializeWardrobe() {
                for (WomenItemType itemType : WomenItemType.values()) {
            wardrobe.put(itemType, new ArrayList<>());
            switch (itemType) {
                case ETHNIC:
                    wardrobe.get(itemType).add(new Item("Traditional Saree - Kanjivaram Silk - Red", 150.0));
                    wardrobe.get(itemType).add(new Item("Anarkali Suit - Designer - Blue", 200.0));
                    wardrobe.get(itemType).add(new Item("Lehenga - Embroidered - Green", 180.0));
                    wardrobe.get(itemType).add(new Item("Salwar Kameez - Cotton - Pink", 160.0));
                    wardrobe.get(itemType).add(new Item("Kurti - Floral Print - Yellow", 100.0));
                    wardrobe.get(itemType).add(new Item("Churidar - Silk - Orange", 170.0));
                    wardrobe.get(itemType).add(new Item("Saree - Georgette - Purple", 120.0));
                    wardrobe.get(itemType).add(new Item("Ethnic Gown - Sequin - Silver", 250.0));
                    wardrobe.get(itemType).add(new Item("Patiala Suit - Punjabi - Maroon", 190.0));
                    wardrobe.get(itemType).add(new Item("Bridal Lehenga - Velvet - Gold", 350.0));
                    break;
                case FORMALS:
                    wardrobe.get(itemType).add(new Item("Blazer - Formal - Black", 100.0));
                    wardrobe.get(itemType).add(new Item("Pantsuit - Corporate - Grey", 120.0));
                    wardrobe.get(itemType).add(new Item("Business Suit - Professional - Navy Blue", 150.0));
                    wardrobe.get(itemType).add(new Item("Skirt Suit - Office Wear - Beige", 130.0));
                    wardrobe.get(itemType).add(new Item("Formal Dress - Knee Length - White", 90.0));
                    wardrobe.get(itemType).add(new Item("Office Shirt - Striped - Light Blue", 70.0));
                    wardrobe.get(itemType).add(new Item("Pencil Skirt - Formal - Dark Grey", 80.0));
                    wardrobe.get(itemType).add(new Item("Formal Trousers - Slim Fit - Brown", 60.0));
                    wardrobe.get(itemType).add(new Item("Business Blouse - Silk - Ivory", 85.0));
                    wardrobe.get(itemType).add(new Item("Corporate Dress - Midi - Olive Green", 110.0));
                    break;
                case FOOTWEAR:
                    wardrobe.get(itemType).add(new Item("High Heels - Stiletto - Red", 80.0));
                    wardrobe.get(itemType).add(new Item("Flats - Casual - Beige", 60.0));
                    wardrobe.get(itemType).add(new Item("Sandals - Ethnic - Gold", 70.0));
                    wardrobe.get(itemType).add(new Item("Boots - Knee High - Black", 100.0));
                    wardrobe.get(itemType).add(new Item("Wedges - Platform - Tan", 90.0));
                    wardrobe.get(itemType).add(new Item("Sneakers - Sporty - White", 75.0));
                    wardrobe.get(itemType).add(new Item("Pumps - Party - Silver", 85.0));
                    wardrobe.get(itemType).add(new Item("Ballerina - Ballet Flats - Pink", 65.0));
                    wardrobe.get(itemType).add(new Item("Mules - Slide - Blue", 55.0));
                    wardrobe.get(itemType).add(new Item("Espadrilles - Canvas - Navy", 50.0));
                    break;
                case JEWELLERY:
                    wardrobe.get(itemType).add(new Item("Ring - Diamond - Solitaire - Gold", 300.0));
                    wardrobe.get(itemType).add(new Item("Pendant - Gemstone - Ruby - Silver", 250.0));
                    wardrobe.get(itemType).add(new Item("Bracelet - Pearl - Beaded - White", 180.0));
                    wardrobe.get(itemType).add(new Item("Earrings - Hoops - Diamond - Rose Gold", 220.0));
                    wardrobe.get(itemType).add(new Item("Necklace - Emerald - Choker - Gold", 400.0));
                    wardrobe.get(itemType).add(new Item("Anklet - Silver - Traditional - Red", 120.0));
                    wardrobe.get(itemType).add(new Item("Bangles - Glass - Bangles - Green", 80.0));
                    wardrobe.get(itemType).add(new Item("Brooch - Floral - Brooch - Blue", 150.0));
                    wardrobe.get(itemType).add(new Item("Toe Ring - Silver - Toe Ring - Pink", 50.0));
                    wardrobe.get(itemType).add(new Item("Hairpin - Rhinestone - Hairpin - Purple", 40.0));
                    break;
                case WESTERN:
                    wardrobe.get(itemType).add(new Item("Jeans - Skinny - Levi's - Blue", 70.0));
                    wardrobe.get(itemType).add(new Item("T-shirt - Graphic - Nike - Black", 40.0));
                    wardrobe.get(itemType).add(new Item("Jacket - Denim - Wrangler - Brown", 120.0));
                    wardrobe.get(itemType).add(new Item("Skirt - Mini - Forever 21 - Pink", 50.0));
                    wardrobe.get(itemType).add(new Item("Dress - Bodycon - H&M - Red", 80.0));
                    wardrobe.get(itemType).add(new Item("Tank Top - Crop - Adidas - Grey", 30.0));
                    wardrobe.get(itemType).add(new Item("Shorts - Denim - Guess - Light Blue", 60.0));
                    wardrobe.get(itemType).add(new Item("Blouse - Ruffled - Zara - White", 45.0));
                    wardrobe.get(itemType).add(new Item("Cardigan - Knitted - Gap - Beige", 55.0));
                    wardrobe.get(itemType).add(new Item("Jumpsuit - Floral - Topshop - Green", 90.0));
                    break;
                case ACCESSORIES:
                    wardrobe.get(itemType).add(new Item("Handbag - Leather - Coach - Brown", 150.0));
                    wardrobe.get(itemType).add(new Item("Sunglasses - Aviator - Ray-Ban - Black", 100.0));
                    wardrobe.get(itemType).add(new Item("Watch - Chronograph - Fossil - Silver", 180.0));
                    wardrobe.get(itemType).add(new Item("Fragrance - Eau de Parfum - Chanel - Floral", 200.0));
                    wardrobe.get(itemType).add(new Item("Hair Accessories - Scrunchie - Gucci - Pink", 50.0));
                    wardrobe.get(itemType).add(new Item("Belt - Leather - Louis Vuitton - Tan", 120.0));
                    wardrobe.get(itemType).add(new Item("Scarf - Cashmere - Burberry - Checkered", 160.0));
                    wardrobe.get(itemType).add(new Item("Hat - Fedora - Prada - Grey", 90.0));
                    wardrobe.get(itemType).add(new Item("Gloves - Leather - Hermes - Black", 80.0));
                    wardrobe.get(itemType).add(new Item("Umbrella - Compact - Versace - Gold", 70.0));
                    break;
            }
        }
    }

    public void browseWardrobe() {
        System.out.println("==== Elevate your elegance, Embrace your unique allure ====\n");

        Scanner scanner = new Scanner(System.in);
        boolean browsing = true;
        
        while (browsing) {
            System.out.println("==== WOMEN ====\n");
            for (WomenItemType itemType : WomenItemType.values()) {
                System.out.println(itemType.ordinal() + 1 + ". " + itemType);
            }
            System.out.println((WomenItemType.values().length + 1) + ". View Cart");
            System.out.println((WomenItemType.values().length + 2) + ". Go back to previous options\n");
            
            int choice = scanner.nextInt();
            if (choice > 0 && choice <= WomenItemType.values().length) {
                WomenItemType selectedType = WomenItemType.values()[choice - 1];
                List<Item> items = wardrobe.get(selectedType);
                System.out.println("===== Available items =====");
                for (int i = 0; i < items.size(); i++) {
                    System.out.println((i + 1) + ". " + items.get(i).getName() + " - $" + items.get(i).getPrice());
                }
                System.out.println((items.size() + 1) + ". Go back to Women Wardrobe\n");
                int itemChoice = scanner.nextInt();
                if (itemChoice > 0 && itemChoice <= items.size()) {
                    Item selectedItem = items.get(itemChoice - 1);
                    System.out.println(selectedItem.getName() + " added to cart.\n");
                    addToCart(selectedItem);
                } else if (itemChoice == items.size() + 1) {
                    // Continue browsing
                } else {
                    System.out.println("Invalid choice.");
                }
            } else if (choice == WomenItemType.values().length + 1) {
                viewCart();
            } else if (choice == WomenItemType.values().length + 2) {
                browsing = false;
                // Go back to previous options
                browsing = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public void addToCart(Item item) {
        cart.addItem(item);
    }

    public void viewCart() {
        System.out.println("==== Items in Cart: ====");
        if (cart.isEmpty()) {
            System.out.println("No items in the cart.\n");
        } else {
            for (Item item : cart) {
                System.out.println(item.getName() + " - $" + item.getPrice()+ "\n");
            }
        }
    }
}
