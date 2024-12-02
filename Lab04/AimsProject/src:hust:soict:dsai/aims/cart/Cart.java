package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.CompareByCostThenTitle;
import hust.soict.dsai.aims.media.CompareByTitleThenCost;
import hust.soict.dsai.aims.media.Media;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        } else {
            System.out.println("Media " + media.getTitle() + " is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Media " + media.getTitle() + " is not in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return Math.round(total * 100) / 100.0f;
    }

    public void displayCart() {
        System.out.println("Items in Cart:");
        for (Media media : itemsOrdered) {
            media.displayInfo();
        }
        System.out.println("Total Cost: $" + totalCost());
    }

    public void sortByTitleThenCost() {
        Collections.sort(itemsOrdered, new CompareByTitleThenCost());
        System.out.println("\nCart sorted by Title then Cost:");
        displayCart();
    }

    public void sortByCostThenTitle() {
        Collections.sort(itemsOrdered, new CompareByCostThenTitle());
        System.out.println("\nCart sorted by Cost then Title:");
        displayCart();
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}