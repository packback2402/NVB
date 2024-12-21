package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructors
    public Disc(int id, String title, String category, double cost) {
        super(id, title, category, cost);
    }

    public Disc(int id, String title, String category, double cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getters
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    // Setters
    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
   
    // Display Information (default implementation)
    public void displayInfo() throws PlayerException {
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Director: " + (director != null ? director : "N/A"));
        System.out.println("Length: " + (length > 0 ? length + " minutes" : "N/A"));
        System.out.println("Cost: $" + getCost());
    }
    
    @Override
    public String toString() {
        return "DVD - Title: " + getTitle() +
               ", Category: " + getCategory() +
               ", Director: " + getDirector() +
               ", Length: " + getLength() + " minutes" +
               ", Cost: $" + getCost();
    }

}
