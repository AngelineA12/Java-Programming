package com.EliteThreads.shoppingapp.wardrobe;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import com.EliteThreads.shoppingapp.model.Category;
import com.EliteThreads.shoppingapp.model.Item;
import com.EliteThreads.shoppingapp.model.MenItemType;
import com.EliteThreads.shoppingapp.ShoppingCart;



public class MenWardrobe {
    private Map<MenItemType, List<Item>> wardrobe;
    private ShoppingCart cart;

     public MenWardrobe(ShoppingCart cart) {
        this.cart = cart;
        this.wardrobe = new HashMap<>(); // Initialize the wardrobe map
        initializeWardrobe();
    }

    private void initializeWardrobe() {
        for (MenItemType itemType : MenItemType.values()) {
            wardrobe.put(itemType, new ArrayList<>());
            switch (itemType) {
                case ACCESSORIES:
                    wardrobe.get(itemType).add(new Item("Handbag - Leather - Coach - Brown", 150.0));
                    wardrobe.get(itemType).add(new Item("Sunglasses - Aviator - Ray-Ban - Black", 100.0));
                    wardrobe.get(itemType).add(new Item("Watch - Chronograph - Fossil - Silver", 180.0));
                    wardrobe.get(itemType).add(new Item("Fragrance - Eau de Parfum - Chanel - Floral", 200.0));
                    wardrobe.get(itemType).add(new Item("Wallet - Bifold - Gucci - Tan", 120.0));
                    wardrobe.get(itemType).add(new Item("Scarf - Cashmere - Burberry - Checkered", 160.0));
                    wardrobe.get(itemType).add(new Item("Hat - Fedora - Prada - Grey", 90.0));
                    wardrobe.get(itemType).add(new Item("Gloves - Leather - Hermes - Black", 80.0));
                    wardrobe.get(itemType).add(new Item("Belt - Reversible - Louis Vuitton - Brown/Black", 200.0));
                    wardrobe.get(itemType).add(new Item("Tie - Silk - Versace - Patterned", 150.0));
                    break;
                case FORMALS:
                    wardrobe.get(itemType).add(new Item("Suit - Formal - Black", 300.0));
                    wardrobe.get(itemType).add(new Item("Shirt - Dress - White", 80.0));
                    wardrobe.get(itemType).add(new Item("Tie - Silk - Red", 50.0));
                    wardrobe.get(itemType).add(new Item("Trousers - Dress - Navy Blue", 120.0));
                    wardrobe.get(itemType).add(new Item("Blazer - Formal - Grey", 250.0));
                    wardrobe.get(itemType).add(new Item("Vest - Suit - Charcoal", 100.0));
                    wardrobe.get(itemType).add(new Item("Dress Shoes - Oxford - Brown", 180.0));
                    wardrobe.get(itemType).add(new Item("Cufflinks - Silver - Classic", 70.0));
                    wardrobe.get(itemType).add(new Item("Pocket Square - Satin - Burgundy", 40.0));
                    wardrobe.get(itemType).add(new Item("Dress Shirt - French Cuff - Blue", 90.0));
                    break;
                case CASUALS:
                    wardrobe.get(itemType).add(new Item("Jeans - Slim Fit - Blue", 70.0));
                    wardrobe.get(itemType).add(new Item("T-shirt - Graphic - Grey", 30.0));
                    wardrobe.get(itemType).add(new Item("Hoodie - Pullover - Black", 80.0));
                    wardrobe.get(itemType).add(new Item("Shorts - Cargo - Khaki", 40.0));
                    wardrobe.get(itemType).add(new Item("Polo Shirt - Cotton - Navy Blue", 60.0));
                    wardrobe.get(itemType).add(new Item("Sweatpants - Joggers - Grey", 50.0));
                    wardrobe.get(itemType).add(new Item("Track Jacket - Zip-up - Green", 90.0));
                    wardrobe.get(itemType).add(new Item("Denim Jacket - Distressed - Blue", 120.0));
                    wardrobe.get(itemType).add(new Item("Plaid Shirt - Flannel - Red", 45.0));
                    wardrobe.get(itemType).add(new Item("Cargo Pants - Multi-Pocket - Beige", 55.0));
                    break;
                case FOOTWEAR:
                    wardrobe.get(itemType).add(new Item("Sneakers - Casual - White", 90.0));
                    wardrobe.get(itemType).add(new Item("Loafers - Leather - Brown", 120.0));
                    wardrobe.get(itemType).add(new Item("Boots - Ankle - Black", 150.0));
                    wardrobe.get(itemType).add(new Item("Sandals - Flip Flops - Blue", 50.0));
                    wardrobe.get(itemType).add(new Item("Dress Shoes - Derby - Tan", 110.0));
                    wardrobe.get(itemType).add(new Item("Athletic Shoes - Running - Grey", 80.0));
                    wardrobe.get(itemType).add(new Item("Slippers - Moccasin - Brown", 40.0));
                    wardrobe.get(itemType).add(new Item("Hiking Boots - Waterproof - Olive", 160.0));
                    wardrobe.get(itemType).add(new Item("Espadrilles - Canvas - Navy", 70.0));
                    wardrobe.get(itemType).add(new Item("Driving Shoes - Suede - Grey", 100.0));
                    break;
                case JEWELLERY:
                    wardrobe.get(itemType).add(new Item("Ring - Titanium - Silver", 80.0));
                    wardrobe.get(itemType).add(new Item("Chain - Curb Link - Gold", 200.0));
                    wardrobe.get(itemType).add(new Item("Bracelet - Leather - Brown", 90.0));
                    wardrobe.get(itemType).add(new Item("Watch - Sport - Black", 150.0));
                    wardrobe.get(itemType).add(new Item("Earrings - Stud - Stainless Steel", 40.0));
                    wardrobe.get(itemType).add(new Item("Necklace - Pendant - Silver", 120.0));
                    wardrobe.get(itemType).add(new Item("Tie Clip - Metal - Gold", 30.0));
                    wardrobe.get(itemType).add(new Item("Cuff Bracelet - Stainless Steel", 60.0));
                    wardrobe.get(itemType).add(new Item("Money Clip - Carbon Fiber", 70.0));
                    wardrobe.get(itemType).add(new Item("Brooch - Vintage - Rhinestone", 50.0));
                    break;
            }
        }
    }

    public void browseWardrobe() {
        System.out.println("==== Refine your style, Express your essence ====\n");

        Scanner scanner = new Scanner(System.in);
        boolean browsing = true;
        
        while (browsing) {
            System.out.println("==== MEN ====\n");

           
            for (MenItemType itemType : MenItemType.values()) {
                System.out.println(itemType.ordinal() + 1 + ". " + itemType);
            }
            System.out.println((MenItemType.values().length + 1) + ". View Cart");
            System.out.println((MenItemType.values().length + 2) + ". Go back to previous options\n");
            
            int choice = scanner.nextInt();
            if (choice > 0 && choice <= MenItemType.values().length) {
                MenItemType selectedType = MenItemType.values()[choice - 1];
                List<Item> items = wardrobe.get(selectedType);
                System.out.println("===== Available items =====");

                for (int i = 0; i < items.size(); i++) {
                    System.out.println((i + 1) + ". " + items.get(i).getName() + " - $" + items.get(i).getPrice());
                }
                System.out.println((items.size() + 1) + ". Go back to Men Wardrobe\n");
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
            } else if (choice == MenItemType.values().length + 1) {
                viewCart();
            } else if (choice == MenItemType.values().length + 2) {
                browsing = false;
                // Go back to previous options
                // Implement logic to go back to previous options
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
