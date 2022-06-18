import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n\nSupported requests:\n- enter a natural number to know its properties;\n- enter 0 to exit.\n");
        long number;
        do {
            System.out.println("Enter a request: ");
            number = new Scanner(System.in).nextLong();
            if (number > 0) {
                System.out.println("Properties of " + NumberFormat.getInstance(Locale.US).format(number));
                PalindromicNumber numberCase = new PalindromicNumber(number);
                numberCase.isEvenOddNumber();
                numberCase.isBuzzNumber();
                numberCase.isDuck();
                numberCase.isPalindromicNumber();
            } else if (number == 0) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("The first parameter should be a natural number or zero.");
            }
        } while (number != 0);

    }
}