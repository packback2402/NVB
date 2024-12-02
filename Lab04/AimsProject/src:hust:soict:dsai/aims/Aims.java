package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Collections;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Store store = new Store();
        Cart cart = new Cart();

        store.addMedia(new Book("Pride and Prejudice", "Romance", 12.50f));
        store.addMedia(new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 14.99f));
        store.addMedia(new CompactDisc("Back in Black", "Rock", 18.99f, "AC/DC", 42, "Robert John Lange"));
        store.addMedia(new Book("Brave New World", "Science Fiction", 13.50f));

        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    storeMenu(store, cart, scanner);
                    break;
                case 2: 
                    updateStore(store, scanner);
                    break;
                case 3: 
                    cartMenu(cart, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu(Store store, Cart cart, Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1: 
                    viewMediaDetails(store, scanner, cart);
                    break;
                case 2: 
                    addMediaToCart(store, cart, scanner);
                    break;
                case 3: 
                    playMedia(store, scanner);
                    break;
                case 4: 
                    cart.displayCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please try again!");
            }
        }
    }

    public static void viewMediaDetails(Store store, Scanner scanner, Cart cart) {
        System.out.print("Please enter the title: ");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            media.displayInfo();
            mediaDetailsMenu(scanner, media, cart);
        } else {
            System.out.println("Not found!");
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Media media, Cart cart) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addMediaToCartHelper(cart, media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Please try again!");
            }
        }
    }

    public static void addMediaToCartHelper(Cart cart, Media media) {
        cart.addMedia(media); 
        System.out.println("The media titled \"" + media.getTitle() + "\" has been added to the cart.");
    }

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        System.out.print("Please enter the title of the media you wish to add to the cart: ");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
        } else {
            System.out.println("The specified media could not be found!");
        }
    }

    public static void playMedia(Store store, Scanner scanner) {
        System.out.print("Please enter the title of the media you want to play: ");
        String title = scanner.nextLine();
        Media media = store.searchMediaByTitle(title);
        if (media != null) {
            if (media instanceof Playable) {
                ((Playable) media).play();
            } else {
                System.out.println("This media is not playable.");
            }
        } else {
            System.out.println("The specified media could not be found!");
        }
    }

    public static void updateStore(Store store, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1: 
                System.out.print("Enter media type (Book/DVD/CD): ");
                String mediaType = scanner.nextLine();
                if (mediaType.equalsIgnoreCase("Book")) {
                    System.out.print("Enter title, category, cost: ");
                    String title = scanner.nextLine();
                    String category = scanner.nextLine();
                    float cost = scanner.nextFloat();
                    store.addMedia(new Book(title, category, cost));
                } else if (mediaType.equalsIgnoreCase("DVD")) {
                    System.out.print("Enter title, category, director, length, cost: ");
                    String titleDvd = scanner.nextLine();
                    String categoryDvd = scanner.nextLine();
                    String director = scanner.nextLine();
                    int length = scanner.nextInt();
                    float costDvd = scanner.nextFloat();
                    store.addMedia(new DigitalVideoDisc(titleDvd, categoryDvd, director, length, costDvd));
                } else if (mediaType.equalsIgnoreCase("CD")) {
                    System.out.print("Enter title, category, artist, director, length, cost: ");
                    String titleCd = scanner.nextLine();
                    String categoryCd = scanner.nextLine();
                    String artist = scanner.nextLine();
                    String directorCd = scanner.nextLine();
                    int lengthCd = scanner.nextInt();
                    float costCd = scanner.nextFloat();
                    store.addMedia(new CompactDisc(titleCd, categoryCd, costCd, artist, lengthCd, directorCd));
                } else {
                    System.out.println("Invalid media type!");
                }
                break;
            case 2: 
                System.out.print("Enter the title of the media to remove: ");
                String titleToRemove = scanner.nextLine();
                Media mediaToRemove = store.searchMediaByTitle(titleToRemove);
                if (mediaToRemove != null) {
                    store.removeMedia(mediaToRemove);
                } else {
                    System.out.println("Media not found!");
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void cartMenu(Cart cart, Scanner scanner) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    filterCart(cart, scanner);
                    break;
                case 2:
                    sortCart(cart, scanner);
                    break;
                case 3:
                    removeMediaFromCart(cart, scanner);
                    break;
                case 4:
                    playMediaFromCart(cart, scanner);
                    break;
                case 5:
                    placeOrder(cart);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void filterCart(Cart cart, Scanner scanner) {
        System.out.println("Filter by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int filterChoice = scanner.nextInt();
        scanner.nextLine();
        switch (filterChoice) {
            case 1:
                System.out.print("Enter media ID: ");
                int id = scanner.nextInt();
                Media media = cart.getItemsOrdered().stream()
                        .filter(m -> m.getId() == id)
                        .findFirst()
                        .orElse(null);
                if (media != null) {
                    media.displayInfo();
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 2:
                System.out.print("Enter media title: ");
                String title = scanner.nextLine();
                cart.getItemsOrdered().stream()
                        .filter(m -> m.getTitle().contains(title))
                        .forEach(Media::displayInfo);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void sortCart(Cart cart, Scanner scanner) {
        System.out.println("Sort by: ");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();
        switch (sortChoice) {
            case 1:
                Collections.sort(cart.getItemsOrdered(), new CompareByTitleThenCost());
                break;
            case 2:
                Collections.sort(cart.getItemsOrdered(), new CompareByCostThenTitle());
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        cart.displayCart();
    }

    public static void removeMediaFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        Media mediaToRemove = cart.getItemsOrdered().stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
        if (mediaToRemove != null) {
            cart.removeMedia(mediaToRemove);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMediaFromCart(Cart cart, Scanner scanner) {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media mediaToPlay = cart.getItemsOrdered().stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
        if (mediaToPlay != null && mediaToPlay instanceof Playable) {
            ((Playable) mediaToPlay).play();
        } else {
            System.out.println("Media not found or cannot be played.");
        }
    }

    public static void placeOrder(Cart cart) {
        System.out.println("Order placed! Total Cost: $" + cart.totalCost());
        cart.getItemsOrdered().clear();
        System.out.println("Cart has been cleared.");
    }
}