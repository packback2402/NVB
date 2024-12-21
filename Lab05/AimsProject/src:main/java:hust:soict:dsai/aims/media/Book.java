package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private final ArrayList<String> authors;

    // Constructor
    public Book(int id, String title, String category, double cost) {
        super(id, title, category, cost); // Call the Media constructor
        this.authors = new ArrayList<>();
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists: " + authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }
    @Override
    public void displayInfo() {
        System.out.println("Book - Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Cost: $" + getCost());
        System.out.println("Authors: " + getAuthors());
    }

    @Override
    public String toString() {
        return "Book - Title: " + getTitle() +
               ", Category: " + getCategory() +
               ", Cost: $" + getCost() +
               ", Authors: " + authors;
    }
}
    