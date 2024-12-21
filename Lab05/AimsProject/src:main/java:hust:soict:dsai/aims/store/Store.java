package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Store {
    private final ArrayList<Media> itemsInStore = new ArrayList<>();
    private int nextId = 1;

    public int getNextId() {
        return nextId++;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    // Add a media item to the store
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added to store: " + media.getTitle());
        } else {
            System.out.println("Media item already exists: " + media.getTitle());
        }
    }

    // Sort items by title (default order)
    public void sortByTitle() {
        Collections.sort(itemsInStore); // Uses Media's compareTo()
        System.out.println("Store items sorted by title.");
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media removed from store: " + media.getTitle());
        } else {
            System.out.println("Media not found in store.");
        }
    }
    
    // Sort items by cost
    public void sortByCost() {
        itemsInStore.sort((media1, media2) -> Double.compare(media1.getCost(), media2.getCost()));
        System.out.println("Store items sorted by cost.");
    }

    // Display all media items in the store
    public void displayStore() {
        System.out.println("***********************STORE***********************");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("***************************************************");
    }
}
