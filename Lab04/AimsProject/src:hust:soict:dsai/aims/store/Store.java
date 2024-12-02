package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added: " + media.getTitle() + " to the store.");
        } else {
            System.out.println("Media " + media.getTitle() + " is already in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed: " + media.getTitle() + " from the store.");
        } else {
            System.out.println("Media " + media.getTitle() + " is not in the store.");
        }
    }

    public Media searchMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void displayStore() {
        System.out.println("Items in Store:");
        for (Media media : itemsInStore) {
            media.displayInfo();
        }
    }
}