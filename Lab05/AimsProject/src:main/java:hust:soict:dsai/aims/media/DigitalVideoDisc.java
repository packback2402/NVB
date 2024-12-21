package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    // Constructors
    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0.0f);
    }

    public DigitalVideoDisc(String title, String category, double cost) {
        super(++nbDigitalVideoDiscs, title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, double cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, 0);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, director, length);
    }
    @Override
    public void displayInfo() {
        System.out.println("DVD - Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Director: " + getDirector());
        System.out.println("Length: " + getLength() + " minutes");
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

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength() + " minutes");
        } else {
            System.err.println("Error: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD Length is non-positive!");
        }
    }
}
