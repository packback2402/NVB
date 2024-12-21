package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    // ObservableList to allow automatic UI updates
    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("Media added to cart: " + media.getTitle());
            } else {
                System.out.println("This media is already in the cart: " + media.getTitle());
            }
        } else {
            System.out.println("The cart is full. Cannot add: " + media.getTitle());
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Media removed from cart: " + media.getTitle());
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    public double totalCost() {
        return itemsOrdered.stream().mapToDouble(Media::getCost).sum();
    }

    public Media searchMediaByTitle(String title) {
        return itemsOrdered.stream()
                .filter(media -> media.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public void sortByTitle() {
        FXCollections.sort(itemsOrdered, Comparator.comparing(Media::getTitle));
        System.out.println("Cart items sorted by title.");
    }

    public void sortByCost() {
        FXCollections.sort(itemsOrdered, Comparator.comparing(Media::getCost).reversed());
        System.out.println("Cart items sorted by cost.");
    }

    public void printCart() {
        System.out.println("*************** CART ***************");
        itemsOrdered.forEach(media -> System.out.println(media.getTitle() + " - $" + media.getCost()));
        System.out.println("************************************");
        System.out.println("Total cost: $" + totalCost());
    }
}
