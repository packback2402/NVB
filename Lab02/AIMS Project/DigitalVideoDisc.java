package aims;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;

    // Constructor
    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public double getCost() {
        return cost;
    }

    // Display information of the DVD
    public void displayInfo() {
        System.out.println("Title: " + title + ", Category: " + category + ", Director: " + director +
                           ", Length: " + length + " minutes, Cost: $" + cost);
    }

    // Play demo of the DVD
    public void playDemo() {
        if (length > 0) {
            System.out.println("Playing demo of \"" + title + "\" directed by " + director + ".");
        } else {
            System.out.println("Cannot play demo: \"" + title + "\" has no content.");
        }
    }
}
