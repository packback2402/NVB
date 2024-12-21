package hust.soict.dsai.aims.screen;

import hust.soict.dsai.Aims;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private final JTextField directorField;
    private final JTextField lengthField;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel dvdPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        dvdPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        dvdPanel.add(new JLabel("Director:"));
        directorField = new JTextField();
        dvdPanel.add(directorField);

        dvdPanel.add(new JLabel("Length (minutes):"));
        lengthField = new JTextField();
        dvdPanel.add(lengthField);

        add(dvdPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void handleAddAction() {
        try {
            String title = titleField.getText().trim();
            String category = categoryField.getText().trim();
            double cost = Double.parseDouble(costField.getText().trim());
            String director = directorField.getText().trim();
            int length = Integer.parseInt(lengthField.getText().trim());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            Aims.getStoreScreenInstance().refreshCenter();
            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input for cost or length. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred. Please check your inputs and try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
