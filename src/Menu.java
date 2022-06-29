import java.text.NumberFormat;
import java.util.*;

public class Menu {

    long number = 1;
    int multiplication = 1;
    List<CanCalculate> calculateList = List.of(
            new EvenNumber(),
            new OddNumber(),
            new BuzzNumber(),
            new DuckNumbers(),
            new PalindromicNumber(),
            new GapfulNumber(),
            new SpyNumber()
    );


    protected void printInstructions() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "   * the first parameter represents a starting number;\n" +
                "   * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }

    protected void askRequest() {
        System.out.println("Enter a request: ");
        String[] command = new Scanner(System.in).nextLine().split(" ");
        if ("".equals(command[0])) {
            printInstructions();
            askRequest();
        } else {
            try {
                number = Long.parseLong(command[0]);
                multiplication = Integer.parseInt(command[1]);
            } catch (ArrayIndexOutOfBoundsException oneNumber) {
                number = Long.parseLong(command[0]);
            } catch (NumberFormatException noNumber) {
                number = -1;
            }
            if (isExit()) {
                multiplication = 1;
            } else if (catchError()) {
                askRequest();
            }
        }
    }

    protected boolean catchError() {
        if (number < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return true;
        }
        if (multiplication < 1) {
            System.out.println("The second parameter should be a natural number.");
            return true;
        }
        return false;
    }

    protected void printCalculation (long number) {
        System.out.println("Properties of " + NumberFormat.getInstance(Locale.US).format(number));
        for (CanCalculate calculate : calculateList) {
            System.out.println(calculate.getName() + ": " + calculate.isCompatible(number));
        }
        System.out.println();
    }

    //Overload
    protected void printCalculation (long number, int multiplication) {
        for (int i = 0; i < multiplication; i++) {
            System.out.print(number + " is ");
            for (CanCalculate calculate : calculateList) {
                if (calculate.getCompatibility(number) != null) {
                    System.out.print(calculate.getCompatibility(number) + ", ");
                }
            }
            System.out.print("\b\b\n"); //remover of last blank space and comma + starting new line.
            number++;
        }
        System.out.println();
    }

    protected boolean isExit() {
        return number == 0;
    }

}