package aims;

public class Aims {
    public static void main(String[] args) {
        // Tạo đối tượng giỏ hàng
        Cart cart = new Cart();
        
        // Tạo một số DVD và thêm vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Zero Length DVD", "Experiment", "Unknown", 0, 5.99);  // DVD không có nội dung
        
        // Thêm các DVD vào giỏ hàng
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);
        cart.addDigitalVideoDisc(dvd4);
        
        // Hiển thị thông tin tất cả các DVD trong giỏ
        System.out.println("\nCart contents:");
        cart.displayCart();
        
        // Tính và hiển thị tổng chi phí
        System.out.println("\nTotal cost: $" + cart.totalCost());
        
        // Thử phát demo các DVD
        System.out.println("\nPlaying demos:");
        dvd1.playDemo();
        dvd2.playDemo();
        dvd4.playDemo();  // Đây là DVD có length = 0
        
        // Sắp xếp giỏ hàng theo tiêu đề và hiển thị lại
        System.out.println("\nSorting cart by title:");
        cart.sortByTitle();
        cart.displayCart();
        
        // Sắp xếp giỏ hàng theo giá và hiển thị lại
        System.out.println("\nSorting cart by cost:");
        cart.sortByCost();
        cart.displayCart();
        
        // Tìm kiếm DVD theo tiêu đề
        System.out.println("\nSearching for DVDs with title 'Star':");
        for (DigitalVideoDisc disc : cart.searchByTitle("Star")) {
            disc.displayInfo();
        }
        
        // Tìm kiếm DVD theo thể loại
        System.out.println("\nSearching for DVDs in category 'Animation':");
        for (DigitalVideoDisc disc : cart.searchByCategory("Animation")) {
            disc.displayInfo();
        }
        
        // Tìm kiếm DVD theo khoảng giá
        System.out.println("\nSearching for DVDs with price between $15 and $20:");
        for (DigitalVideoDisc disc : cart.searchByPrice(15, 20)) {
            disc.displayInfo();
        }
        
        // Chọn ngẫu nhiên một DVD miễn phí từ giỏ hàng
        System.out.println("\nGetting a random free DVD:");
        DigitalVideoDisc freeDisc = cart.getRandomFreeDisc();
        if (freeDisc != null) {
            System.out.println("You got \"" + freeDisc.getTitle() + "\" for free!");
        }
    }
}
