package hust.soict.dsai;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;

import javax.swing.*;
import java.util.ArrayList;

public class Aims {
    private static Store store;
    private static Cart cart;
    private static StoreScreen storeScreenInstance;

    public static void main(String[] args) {
        // Prevent JavaFX from exiting after the first window closes
        Platform.setImplicitExit(false);

        // Initialize the store and cart
        store = new Store();
        cart = new Cart();

        // Add sample media to the store
        addSampleMediaToStore();

        // Launch the GUI (Store Screen)
        SwingUtilities.invokeLater(() -> {
            storeScreenInstance = new StoreScreen(store, cart);

            // DEMONSTRATION of handling PlayerException:
            // We added a CompactDisc in addSampleCompactDiscs. Let's add it to the cart to test.
            // This is optional code to show try-catch usage as requested.
            // If you want to test the exception, you can modify the track length to be 0 or negative.
            Media firstMedia = store.getItemsInStore().stream().filter(m -> m instanceof Playable).findFirst().orElse(null);
            if (firstMedia != null) {
                cart.addMedia(firstMedia);
                playFirstCartItem();
            }
        });
    }

    private static void addSampleMediaToStore() {
        addSampleBooks();
        addSampleCompactDiscs();
        addSampleDigitalVideoDiscs();
    }

    private static void addSampleBooks() {
        ArrayList<String> authors = new ArrayList<>();

        // Book 1
        authors.add("Joshua Bloch");
        Book book1 = new Book(store.getNextId(), "Effective Java", "Programming", 45.0);
        book1.addAuthor("Joshua Bloch");
        store.addMedia(book1);

        // Book 2
        authors.clear();
        authors.add("Robert C. Martin");
        Book book2 = new Book(store.getNextId(), "Clean Code", "Programming", 50.0);
        book2.addAuthor("Robert C. Martin");
        store.addMedia(book2);
    }

    private static void addSampleCompactDiscs() {
        CompactDisc cd = new CompactDisc("The Best of Queen", "Music", "Queen", "Helm Teon", 12.95);
        cd.addTrack(new Track("Bohemian Rhapsody", 6));
        cd.addTrack(new Track("Don't Stop Me Now", 4));
        store.addMedia(cd);
    }

    private static void addSampleDigitalVideoDiscs() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 89, 19.95));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 18.95));
    }

    // Attempt to play the first item in the cart if playable
    private static void playFirstCartItem() {
        if (!cart.getItemsOrdered().isEmpty()) {
            Media m = cart.getItemsOrdered().get(0);
            if (m instanceof Playable p) {
                try {
                    p.play();
                } catch (PlayerException e) {
                    System.err.println("PlayerException caught: " + e.getMessage());
                    e.printStackTrace();
                    // Show a dialog box with the exception message
                    JOptionPane.showMessageDialog(null,
                            "Error: " + e.getMessage(),
                            "Illegal DVD Length",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static Store getStore() {
        return store;
    }

    public static Cart getCart() {
        return cart;
    }

    public static StoreScreen getStoreScreenInstance() {
        return storeScreenInstance;
    }
}
