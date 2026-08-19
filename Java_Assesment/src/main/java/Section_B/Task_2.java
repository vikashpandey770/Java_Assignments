package Section_B;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

// 1. Model Class
class MenuItem {
    private int itemId;
    private String name;
    private double price;
    private boolean isAvailable;

    public MenuItem(int itemId, String name, double price, boolean isAvailable) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }
}

// 2. Custom Checked Exception
class ItemUnavailableException extends Exception {
    private final String itemName;

    public ItemUnavailableException(String itemName) {
        super("Cannot add item to cart: '" + itemName + "' is currently unavailable.");
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}

// 3. Cart Manager Class
class CartManager {
    private final ArrayList<MenuItem> items;
    public CartManager() {
        this.items = new ArrayList<>();
    }
    public void addItem(MenuItem item) throws ItemUnavailableException {
        if (!item.isAvailable()) {
            throw new ItemUnavailableException(item.getName());
        }
        items.add(item);
        System.out.println("Added to cart: " + item.getName());
    }
    public void removeItem(int itemId) {
        boolean found = false;
        Iterator<MenuItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            MenuItem item = iterator.next();
            if (item.getItemId() == itemId) {
                iterator.remove();
                found = true;
                System.out.println("Removed item ID " + itemId + " (" + item.getName() + ") from cart.");
                break;
            }
        }
        if (!found) {
            throw new NoSuchElementException("No item found in cart with ID: " + itemId);
        }
    }
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        System.out.println("\n--- Cart Items ---");
        double grandTotal = 0.0;
        for (MenuItem item : items) {
            System.out.printf("%s - Rs. %.2f%n", item.getName(), item.getPrice());
            grandTotal += item.getPrice();
        }
        System.out.println("------------------");
        System.out.printf("Grand Total: Rs. %.2f%n\n", grandTotal);
    }
}

// 4. Main Class to Run/Test
public class Task_2 {
    public static void main(String[] args) {
        CartManager cart = new CartManager();
        
        MenuItem burger = new MenuItem(101, "Veg Burger", 149.00, true);
        MenuItem pizza = new MenuItem(102, "Margherita Pizza", 299.00, true);
        MenuItem pasta = new MenuItem(103, "White Sauce Pasta", 199.00, false);
        System.out.println("--- Testing Display Empty Cart ---");
        cart.displayCart();
        System.out.println("--- Adding Items ---");
        try {
            cart.addItem(burger);
            cart.addItem(pizza);
            cart.addItem(pasta); 
        } catch (ItemUnavailableException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        cart.displayCart();
        System.out.println("--- Removing Items ---");
        try {
            cart.removeItem(101); 
            cart.removeItem(999); 
        } catch (NoSuchElementException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        cart.displayCart();
    }
}