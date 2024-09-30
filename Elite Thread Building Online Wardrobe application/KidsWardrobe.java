

package com.EliteThreads.shoppingapp.wardrobe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;
import com.EliteThreads.shoppingapp.model.Category;
import com.EliteThreads.shoppingapp.model.Item;
import com.EliteThreads.shoppingapp.model.KidsItemType;
import com.EliteThreads.shoppingapp.model.KidsCategory;
import com.EliteThreads.shoppingapp.ShoppingCart;

public class KidsWardrobe {
    private Map<KidsCategory, Map<KidsItemType, List<Item>>> wardrobe;

   private ShoppingCart cart;

    public KidsWardrobe(ShoppingCart cart) {
        this.cart = cart;
        this.wardrobe = new HashMap<>(); // Initialize the wardrobe map
        initializeWardrobe();
    }


    private void initializeWardrobe() {
        for (KidsCategory category : KidsCategory.values()) {
            Map<KidsItemType, List<Item>> categoryWardrobe = new HashMap<>();
            for (KidsItemType itemType : KidsItemType.values()) {
                categoryWardrobe.put(itemType, new ArrayList<>());
                switch (itemType) {
                    case DRESSES:
                        if (category == KidsCategory.BOYS) {
                            // Boys dresses
                            categoryWardrobe.get(itemType).add(new Item("Shirt & Shorts Set - Striped - Blue", 40.0));
                            categoryWardrobe.get(itemType).add(new Item("T-shirt & Jeans Set - Printed - Grey", 35.0));
                            categoryWardrobe.get(itemType).add(new Item("Polo Shirt & Pants Set - Casual - Green", 38.0));
                            categoryWardrobe.get(itemType).add(new Item("Button-up Shirt & Chinos Set - Formal - Navy", 45.0));
                            categoryWardrobe.get(itemType).add(new Item("Graphic T-shirt - Superhero Print - Red", 30.0));
                            categoryWardrobe.get(itemType).add(new Item("Sweatshirt & Joggers Set - Sporty - Black", 50.0));
                            categoryWardrobe.get(itemType).add(new Item("Hoodie & Shorts Set - Active Wear - Orange", 55.0));
                            categoryWardrobe.get(itemType).add(new Item("Vest & Denim Set - Fashionable - Light Blue", 45.0));
                            categoryWardrobe.get(itemType).add(new Item("Checkered Shirt & Cargo Shorts Set - Casual - Khaki", 42.0));
                            categoryWardrobe.get(itemType).add(new Item("Striped Polo & Bermuda Shorts Set - Smart Casual - Navy", 40.0));
                        } else if (category == KidsCategory.GIRLS) {
                            // Girls dresses
                            categoryWardrobe.get(itemType).add(new Item("Dress - Floral Print - Pink", 45.0));
                            categoryWardrobe.get(itemType).add(new Item("Skirt & Top Set - Polka Dot - Red", 38.0));
                            categoryWardrobe.get(itemType).add(new Item("Tutu Dress - Princess Theme - Purple", 50.0));
                            categoryWardrobe.get(itemType).add(new Item("Maxi Dress - Unicorn Print - Pastel", 55.0));
                            categoryWardrobe.get(itemType).add(new Item("Party Dress - Sequined - Gold", 60.0));
                            categoryWardrobe.get(itemType).add(new Item("Ruffle Dress - Striped - Blue", 48.0));
                            categoryWardrobe.get(itemType).add(new Item("Denim Jumpsuit - Embroidered - Denim Blue", 52.0));
                            categoryWardrobe.get(itemType).add(new Item("Floral Print Romper - Summer Style - Yellow", 42.0));
                            categoryWardrobe.get(itemType).add(new Item("Sleeveless Dress & Cardigan Set - Formal - Coral", 50.0));
                            categoryWardrobe.get(itemType).add(new Item("Lace Dress & Headband Set - Special Occasion - White", 55.0));
                        }
                        break;
                    case FOOTWEAR:
                        if (category == KidsCategory.BOYS) {
                            // Boys footwear
                            categoryWardrobe.get(itemType).add(new Item("Sneakers - Sporty - Blue", 30.0));
                            categoryWardrobe.get(itemType).add(new Item("Sandals - Velcro - Brown", 25.0));
                            categoryWardrobe.get(itemType).add(new Item("Boots - Winter - Black", 40.0));
                            categoryWardrobe.get(itemType).add(new Item("Slip-on Shoes - Canvas - Grey", 28.0));
                            categoryWardrobe.get(itemType).add(new Item("Dress Shoes - Lace-up - Brown", 35.0));
                            categoryWardrobe.get(itemType).add(new Item("Flip Flops - Beach Wear - Green", 15.0));
                            categoryWardrobe.get(itemType).add(new Item("Trainers - Running - Red", 35.0));
                            categoryWardrobe.get(itemType).add(new Item("Boat Shoes - Casual - Navy", 32.0));
                            categoryWardrobe.get(itemType).add(new Item("Espadrilles - Summer Style - Beige", 22.0));
                            categoryWardrobe.get(itemType).add(new Item("Formal Shoes - Black Tie - Black", 40.0));
                        } else if (category == KidsCategory.GIRLS) {
                            // Girls footwear
                            categoryWardrobe.get(itemType).add(new Item("Ballet Flats - Glitter - Pink", 28.0));
                            categoryWardrobe.get(itemType).add(new Item("Mary Jane Shoes - Floral - White", 32.0));
                            categoryWardrobe.get(itemType).add(new Item("Sneakers - Unicorn Print - Pastel", 30.0));
                            categoryWardrobe.get(itemType).add(new Item("Sandals - Strappy - Gold", 25.0));
                            categoryWardrobe.get(itemType).add(new Item("Boots - Knee High - Black", 35.0));
                            categoryWardrobe.get(itemType).add(new Item("Flip Flops - Beach Wear - Purple", 15.0));
                            categoryWardrobe.get(itemType).add(new Item("Slip-on Shoes - Sequined - Silver", 28.0));
                            categoryWardrobe.get(itemType).add(new Item("Jelly Shoes - Summer Style - Clear", 18.0));
                            categoryWardrobe.get(itemType).add(new Item("Trainers - Sporty - Aqua Blue", 32.0));
                            categoryWardrobe.get(itemType).add(new Item("Dress Shoes - Bow Detail - Rose Gold", 30.0));
                        }
                        break;
                    // Add more cases for other item types if needed...
                }
            }
            wardrobe.put(category, categoryWardrobe);
        }
    }

    public void browseWardrobe() {
        System.out.println("==== Nurture their imagination, Dress them in joy ====");
        Scanner scanner = new Scanner(System.in);
        boolean browsing = true;

        while (browsing) {
            System.out.println("==== KIDS ====\n");

            for (KidsCategory category : KidsCategory.values()) {
                System.out.println(category.ordinal() + 1 + ". " + category);
            }
            System.out.println((KidsCategory.values().length + 1) + ". View Cart");
            System.out.println((KidsCategory.values().length + 2) + ". Go back to previous options\n");

            int choice = scanner.nextInt();
            if (choice > 0 && choice <= KidsCategory.values().length) {
                KidsCategory selectedCategory = KidsCategory.values()[choice - 1];
                Map<KidsItemType, List<Item>> categoryWardrobe = wardrobe.get(selectedCategory);
                System.out.println("Choose among: ");
                for (KidsItemType itemType : categoryWardrobe.keySet()) {
                    System.out.println(itemType.ordinal() + 1 + ". " + itemType);
                }
                System.out.println((KidsItemType.values().length + 1) + ". Go back to " + selectedCategory);

                int itemTypeChoice = scanner.nextInt();
                if (itemTypeChoice > 0 && itemTypeChoice <= KidsItemType.values().length) {
                    KidsItemType selectedType = KidsItemType.values()[itemTypeChoice - 1];
                    List<Item> items = categoryWardrobe.get(selectedType);
System.out.println("===== Available items =====");
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println((i + 1) + ". " + items.get(i).getName() + " - $" + items.get(i).getPrice());
                    }
                    System.out.println((items.size() + 1) + ". Go back to " + selectedCategory);
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
                } else if (itemTypeChoice == KidsItemType.values().length + 1) {
                    // Continue browsing
                } else {
                    System.out.println("Invalid choice.");
                }
            } else if (choice == KidsCategory.values().length + 1) {
                viewCart();
            } else if (choice == KidsCategory.values().length + 2) {
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
