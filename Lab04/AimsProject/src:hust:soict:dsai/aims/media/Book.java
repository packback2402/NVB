package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors;

    public Book(String title, String category, float cost) {
        super(title, category, cost);
        this.authors = new ArrayList<>();
    }

    public void addAuthor(String author) {
        if (!authors.contains(author)) {
            authors.add(author);
        } else {
            System.out.println("Author " + author + " already exists in the list.");
        }
    }

    public void removeAuthor(String author) {
        if (authors.contains(author)) {
            authors.remove(author);
        } else {
            System.out.println("Author " + author + " is not in the list.");
        }
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + String.join(", ", authors) +
                " - Cost: $" + getCost();
    }
    @Override
    public void displayInfo() {
        System.out.println("Book - " + getTitle() + " - " + getCategory() + " - Authors: " + String.join(", ", authors)
                + " - Cost: $" + getCost());
    }
}