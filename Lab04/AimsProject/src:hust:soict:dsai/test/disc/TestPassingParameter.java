// package hust.soict.dsai.test.disc;
// import hust.soict.dsai.aims.media.DigitalVideoDisc;

// public class TestPassingParameter {

//     public static void main(String[] args) {
//         // Create two DVD objects
//         DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
//         DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

//         // Print the titles before swapping
//         System.out.println("Before swap:");
//         System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//         System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

//         // Use an array to swap the two DVD objects
//         DigitalVideoDisc[] dvdArray = {jungleDVD, cinderellaDVD};
//         swap(dvdArray);

//         // Print the titles after swapping
//         System.out.println("\nAfter swap (correct):");
//         System.out.println("jungle dvd title: " + dvdArray[0].getTitle());
//         System.out.println("cinderella dvd title: " + dvdArray[1].getTitle());

//         // Change the title of jungleDVD to cinderellaDVD's title
//         changeTitle(jungleDVD, cinderellaDVD.getTitle());
//         System.out.println("\nAfter changeTitle:");
//         System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//     }

//     public static void swap(DigitalVideoDisc[] dvds) {
//             DigitalVideoDisc temp = dvds[0];
//             dvds[0] = dvds[1];
//             dvds[1] = temp;
//     }

//     // Change the title of the given DVD object
//     public static void changeTitle(DigitalVideoDisc dvd, String title) {
//         dvd.setTitle(title);
//     }
// }
