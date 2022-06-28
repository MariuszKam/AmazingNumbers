import java.text.NumberFormat;
import java.util.*;

public class Menu {

    static long number = 1;
    static int multiplication = 1;


    protected static void printInstructions() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "   * the first parameter represents a starting number;\n" +
                "   * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }

    protected static void askRequest() {
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

    protected static boolean catchError() {   //checking with void as return, boolean might be needed
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

    protected static void printCalculation (long number) {
        System.out.println("Properties of " + NumberFormat.getInstance(Locale.US).format(number) +
                "\nbuzz: " + BuzzNumber.isBuzzNumber(number) +
                "\nduck: " + DuckNumbers.isDuck(number) +
                "\npalindromic: " + PalindromicNumber.isPalindromicNumber(number) +
                "\ngapful: " + GapfulNumber.isGapful(number) +
                "\neven: " + EvenOddNumber.isEvenNumber(number) +
                "\nodd: " + EvenOddNumber.isOddNumber(number));
    }
    //Overload
    protected static void printCalculation (long number, int multiplication) {
        ArrayList<ArrayList<String>> numbersList = new ArrayList<>();
        for (int i = 0; i < multiplication; i++) {
            ArrayList<String> numberList = new ArrayList<>();
            numberList.add(Long.toString(number));
            numberList.add(BuzzNumber.getBuzzNumber(number));
            numberList.add(DuckNumbers.getDuck(number));
            numberList.add(PalindromicNumber.getPalindromicNumber(number));   //Practicing Nested ArrayList
            numberList.add(GapfulNumber.getGapful(number));
            numberList.add(EvenOddNumber.getEvenOdd(number));
            numberList.removeIf(Objects::isNull);
            numbersList.add(numberList);
            System.out.print(numbersList.get(i).get(0) + " is ");
            for (int j = 1; j < numbersList.get(i).size(); j++) {
                if (!(j == numbersList.get(i).size() - 1)) {
                    System.out.print(numbersList.get(i).get(j) + ", ");
                } else {
                    System.out.print(numbersList.get(i).get(j));
                }

            }
            System.out.println();
            number++;
        }

    }

    protected static boolean isExit() {
        return number == 0;
    }

}