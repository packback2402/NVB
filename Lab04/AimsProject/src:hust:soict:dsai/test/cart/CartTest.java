// package hust.soict.dsai.test.cart;

// import hust.soict.dsai.aims.cart.Cart;
// import hust.soict.dsai.aims.media.DigitalVideoDisc;

// public class CartTest {
//     public static void main(String[] args) {
//         // Create a new cart
//         Cart cart = new Cart();

//         // Create DVDs and add them to the cart
//         DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//         DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
//         DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
//         DigitalVideoDisc[] dvdArray = { dvd1, dvd2, dvd3 };
//         cart.addDigitalVideoDisc(dvdArray);

//         // Test the print method
//         cart.print();

//         // Test searching by ID
//         System.out.println("\n********************Search by ID*******************");
//         DigitalVideoDisc searchById = cart.searchById(2); // Searching for ID = 2
//         System.out.println(searchById != null ? searchById.toString() : "No match found.");
//         System.out.println("***************************************************");

//     }
// }
