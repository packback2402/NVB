import java.util.Scanner;

public class calcutator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String strNum1 = scanner.nextLine();
        System.out.print("Enter the second number: ");
        String strNum2 = scanner.nextLine();
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        System.out.printf("Sum: %.2f%n", sum);
        System.out.printf("Difference: %.2f%n", difference);
        System.out.printf("Product: %.2f%n", product);

        if(num2 !=0){
            double quotient = num1 / num2;
            System.out.printf("Quotient: %.2f%n", quotient);
        }else{
            System.out.println("Error: Division by zero");
        }
        scanner.close();
    }
}
