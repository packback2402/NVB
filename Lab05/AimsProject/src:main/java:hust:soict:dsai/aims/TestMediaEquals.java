package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;

public class TestMediaEquals {
    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) throws Exception {
        Media book1 = new Book(1,"Harry Potter", "Fantasy", 19.99f);
        Media book2 = new Book(2,"Harry Potter", "Adventure", 25.99f);
        Media book3 = new Book(3,"Lord of the Rings", "Fantasy", 29.99f);

        // Kiểm tra equals()
        System.out.println("book1 equals book2? " + book1.equals(book2)); // true
        System.out.println("book1 equals book3? " + book1.equals(book3)); // false

        // Kiểm tra null và khác kiểu
        System.out.println("book1 equals null? " + book1.equals(null)); // false
        System.out.println("book1 equals String? " + book1.equals("Harry Potter")); // false
    }
}
