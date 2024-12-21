package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Media implements Comparable<Media> {
    private final StringProperty title;
    private final StringProperty category;
    private final SimpleDoubleProperty cost;
    private final int id;

    public Media(int id, String title, String category, double cost) {
        this.id = id;
        this.title = new SimpleStringProperty(title);
        this.category = new SimpleStringProperty(category);
        this.cost = new SimpleDoubleProperty(cost);
    }

    // Getters for JavaFX properties
    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public SimpleDoubleProperty costProperty() {
        return cost;
    }

    // Getters for raw values
    public String getTitle() {
        return title.get();
    }

    public String getCategory() {
        return category.get();
    }

    public double getCost() {
        return cost.get();
    }

    public int getId() {
        return id;  // Getter for the unique ID
    }

    // Abstract method: may throw PlayerException if implementation requires
    public abstract void displayInfo() throws PlayerException;

    @Override
    public abstract String toString();

    // Implement Comparable
    @Override
    public int compareTo(Media other) {
        return this.getTitle().compareToIgnoreCase(other.getTitle());
    }

    // Modify equals() method: Two medias are equal if they have the same title
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Media)) return false;

        Media other = (Media) o;
        String thisTitle = this.getTitle();
        String otherTitle = other.getTitle();

        if (thisTitle == null && otherTitle == null) return true;
        if (thisTitle == null || otherTitle == null) return false;

        return thisTitle.equalsIgnoreCase(otherTitle);
    }
}
