package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private final Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        // Create a JavaFX panel
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        // Set up the JFrame
        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        // Load JavaFX content into the JFXPanel
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
                CartScreenController controller = new CartScreenController(cart);
                loader.setController(controller);
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Unable to load Cart Screen", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
