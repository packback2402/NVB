package aims;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Cart {
    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

    // Add a DVD to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        itemsOrdered.add(disc);	
        System.out.println("The disc has been added.");
    }

    // Remove a DVD from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (itemsOrdered.remove(disc)) {
            System.out.println("The disc has been removed.");
        } else {
            System.out.println("The disc was not found in the cart.");
        }
    }

    // Calculate the total cost of DVDs in the cart
    public double totalCost() {
        double total = 0;
        for (DigitalVideoDisc disc : itemsOrdered) {
            total += disc.getCost();
        }
        return total;
    }

    // Display all DVDs in the cart
    public void displayCart() {
        for (DigitalVideoDisc disc : itemsOrdered) {
            disc.displayInfo();
        }
    }

    // Sort DVDs in the cart by title alphabetically
    public void sortByTitle() {
        itemsOrdered.sort(Comparator.comparing(DigitalVideoDisc::getTitle)
                                    .thenComparing(Comparator.comparing(DigitalVideoDisc::getCost).reversed()));
        System.out.println("Cart sorted by title.");
    }

    // Sort DVDs in the cart by cost in descending order
    public void sortByCost() {
        itemsOrdered.sort(Comparator.comparing(DigitalVideoDisc::getCost).reversed()
                                    .thenComparing(DigitalVideoDisc::getTitle));
        System.out.println("Cart sorted by cost.");
    }

    // Search DVDs by title
    public ArrayList<DigitalVideoDisc> searchByTitle(String title) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<>();
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(disc);
            }
        }
        return result;
    }

    // Search DVDs by category
    public ArrayList<DigitalVideoDisc> searchByCategory(String category) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<>();
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc.getCategory().equalsIgnoreCase(category)) {
                result.add(disc);
            }
        }
        return result;
    }

    // Search DVDs by price range
    public ArrayList<DigitalVideoDisc> searchByPrice(double min, double max) {
        ArrayList<DigitalVideoDisc> result = new ArrayList<>();
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc.getCost() >= min && disc.getCost() <= max) {
                result.add(disc);
            }
        }
        return result;
    }

    // Get a random DVD for free as a promotion
    public DigitalVideoDisc getRandomFreeDisc() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty, no free disc available.");
            return null;
        }
        Random rand = new Random();
        DigitalVideoDisc freeDisc = itemsOrdered.get(rand.nextInt(itemsOrdered.size()));
        System.out.println("You get \"" + freeDisc.getTitle() + "\" for free!");
        return freeDisc;
    }
}
