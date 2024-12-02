import java.util.Scanner;

public class dayinmonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = getYear(scanner);
        int month = getMonth(scanner);
        
        int days = calculateDaysInMonth(month, year);
        
        System.out.println("The month " + month + " in year " + year + " has " + days + " days.");
        scanner.close();
    }

    public static int getYear(Scanner scanner) {
        int year;
        do {
            System.out.print("Enter year: ");
            year = scanner.nextInt();
            if (year < 0) {
                System.out.println("Invalid year! Please enter a non-negative integer.");
            }
        } while (year < 0);
        return year;
    }
    public static int getMonth(Scanner scanner) {
        int month;
        do {
            System.out.print("Enter month: ");
            month = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Invalid month! Please enter a value between 1 and 12.");
            }
        } while (month < 1 || month > 12);
        return month;
    }
    public static int calculateDaysInMonth(int month, int year) {
        int days = 0;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = (isLeapYear(year)) ? 29 : 28;
                break;
        }
        return days;
    }
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
