import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] myArray = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            myArray[i] = sc.nextInt();
        }

        System.out.println("Original Array: " + Arrays.toString(myArray));
        Arrays.sort(myArray);

        System.out.println("Sorted Array: " + Arrays.toString(myArray));

        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }

        double average = (double) sum / n;

        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value of array elements: " + average);

        sc.close();
    }
}
