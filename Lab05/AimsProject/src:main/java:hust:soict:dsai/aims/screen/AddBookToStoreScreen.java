package hust.soict.dsai.aims.screen;

import hust.soict.dsai.Aims;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private final JTextArea authorsArea;

    public AddBookToStoreScreen(Store store) {
        super(store);

        // Set a larger size and center on screen
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel bookPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        bookPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        bookPanel.add(new JLabel("Authors (comma-separated):"));
        authorsArea = new JTextArea();
        bookPanel.add(authorsArea);

        add(bookPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void handleAddAction() {
        try {
            String title = titleField.getText().trim();
            String category = categoryField.getText().trim();
            double cost = Double.parseDouble(costField.getText().trim());
            String[] authors = authorsArea.getText().split(",");

            Book book = new Book(store.getNextId(), title, category, cost);
            for (String author : authors) {
                if (!author.trim().isEmpty()) {
                    book.addAuthor(author.trim());
                }
            }

            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            Aims.getStoreScreenInstance().refreshCenter();
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
