import java.util.Scanner;
public class TriangleStars {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so hang: ");
		int n = scanner.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j = n; j > i; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= (2*i - 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}
	
}
