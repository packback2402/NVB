import java.util.Scanner;

public class EquationSolver {
    public static void soverLinearEquation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First-degree Equation: ");
        System.out.print("Enter coefficiEnter a : ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b : ");
        double b = scanner.nextDouble();

        if(a==0){
            System.out.println("cofficient 'a' cannot be zero for a  linear equation");
        }else{
            double x = -b/a;
            System.out.printf("The solution is x = %.2f%n", x);
        }
    }

    public static void solveLinearSystem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter  a11 : ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter  a12 : ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter  b1 : ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter  a21 : ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter  a22 : ");
        double a22 = scanner.nextDouble();
        System.err.print("Enter b2 :");
        double b2 = scanner.nextDouble();

        double D=a11 * a22 - a21 * a12;
        double D1=b1 * a22 - b2 * a12;
        double D2=a11 * b2 - a21 * b1;

        if(D==0){
            if(D1==0 & D2==0){
                System.out.println("The system has infinite solutions");
            }else{
                System.out.println("The system has no solution");
            }
            }else{
                double x1=D1/D;
                double x2=D2/D;
                System.out.println("The solution is x1 = "+x1+", x2 = "+x2);
        }      
    }

    public static void solveQuadraticEquation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Second-degree equation : ");
        System.out.print("Enter coefficient a : ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b : ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c : ");
        double c = scanner.nextDouble();

        if(a==0){
            System.out.println("Cofficient 'a' cannot be for a quadratic equation. ");
            return;
        }
        double delta =b*b - 4 * a * c;
        if(delta > 0){
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("The solution are x1 = " + x1 + ", x2 = " + x2);
        }else if(delta == 0){
            double x = -b / (2 * a);
            System.out.println("The solution is x = " + x);
        }else{
            System.out.println("The equation has no real solutions");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose your equation type:");
            System.out.println("1. Linear Equation");
            System.out.println("2. Linear System");
            System.out.println("3. Quadratic Equation");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    soverLinearEquation();
                    break;
                case 2:
                    solveLinearSystem();
                    break;
                case 3:
                    solveQuadraticEquation();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
