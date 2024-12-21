package hust.soict.dsai.aims.screen;

import hust.soict.dsai.Aims;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private final JTextField artistField;
    private final JTextField directorField;
    private final JTextArea tracksArea;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel cdPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        cdPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        cdPanel.add(new JLabel("Artist:"));
        artistField = new JTextField();
        cdPanel.add(artistField);

        cdPanel.add(new JLabel("Director:"));
        directorField = new JTextField();
        cdPanel.add(directorField);

        cdPanel.add(new JLabel("Tracks (comma-separated):"));
        tracksArea = new JTextArea();
        cdPanel.add(tracksArea);

        add(cdPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void handleAddAction() {
        try {
            String title = titleField.getText().trim();
            String category = categoryField.getText().trim();
            double cost = Double.parseDouble(costField.getText().trim());
            String artist = artistField.getText().trim();
            String director = directorField.getText().trim();
            String[] trackNames = tracksArea.getText().split(",");

            CompactDisc cd = new CompactDisc(title, category, artist, director, cost);

            Arrays.stream(trackNames)
                    .map(String::trim)
                    .filter(track -> !track.isEmpty())
                    .forEach(track -> cd.addTrack(new Track(track, 0)));

            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added successfully!");
            Aims.getStoreScreenInstance().refreshCenter();
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
