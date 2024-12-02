// package hust.soict.dsai.test.store;

// import hust.soict.dsai.aims.media.DigitalVideoDisc;
// import hust.soict.dsai.aims.store.Store;

// public class StoreTest {
//     public static void main(String[] args) {
//         // Create a new store
//         Store store = new Store();

//         // Create some DVDs
//         DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//         DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
//         DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

//         // Add DVDs to the store
//         store.addDVD(dvd1);
//         store.addDVD(dvd2);
//         store.addDVD(dvd3);

//         // Display items in the store
//         System.out.println("\n***********************Store Contents***********************");
//         store.displayStore();

//         // Remove a DVD from the store
//         System.out.println("\n************************Remove a DVD************************");
//         store.removeDVD(dvd2);

//         // Display items in the store after removal
//         System.out.println("\n****************Store Contents After Removal****************");
//         store.displayStore();

//         // Try to remove a non-existent DVD
//         System.out.println("\n*************Attempt to Remove Non-existent DVD*************");
//         store.removeDVD(dvd2); // Star Wars was already removed
//     }
// }
