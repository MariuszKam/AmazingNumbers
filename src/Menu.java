import java.text.NumberFormat;
import java.util.*;

public class Menu {

    long number;
    int multiplication = 1;
    String name = "";
    List<CanCalculate> calculateList = List.of(
            new EvenNumber(),
            new OddNumber(),
            new BuzzNumber(),
            new DuckNumbers(),
            new PalindromicNumber(),
            new GapfulNumber(),
            new SpyNumber()
    );
    final String[] properties = {"odd", "even", "buzz", "duck", "palindromic", "gapful", "spy"};

    protected void setDefault () {
        number = 0;
        multiplication = 1;
        name = "";
    }


    protected void printInstructions() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "   * the first parameter represents a starting number;\n" +
                "   * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }

    protected String askRequest() {
        System.out.println("Enter a request: ");
        return new Scanner(System.in).nextLine();
    }

    protected void convertRequest() {
        setDefault();
        String command = askRequest();
        if ("".equals(command)) {
            printInstructions();
            convertRequest();
        } else {
            if ("0".equals(command)) {
                number = 0;
            } else {
                ArrayList<String> listCommands = new ArrayList<>(List.of(command.split(" ")));
                if (listCommands.size() == 3) {
                    number = Long.parseLong(listCommands.get(0));
                    multiplication = Integer.parseInt(listCommands.get(1));
                    name = listCommands.get(2).toLowerCase(Locale.ROOT);
                    printCalculation(number, multiplication, name);
                } else if (listCommands.size() == 2) {
                    number = Long.parseLong(listCommands.get(0));
                    multiplication = Integer.parseInt(listCommands.get(1));
                    printCalculation(number, multiplication);
                } else {
                    number = Long.parseLong(listCommands.get(0));
                    printCalculation(number);
                }
                listCommands.clear();
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
        if (Arrays.stream(properties).noneMatch(name::contains) && !"".equals(name)) {
            System.out.println("The property [" + name.toUpperCase() + "] is wrong.\n Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY]");
            return true;
        }
        return false;
    }

    protected void printNumberLine (long number) {
        System.out.print(number + " is ");
        for (CanCalculate calculate : calculateList) {
            if (calculate.getCompatibility(number) != null) {
                System.out.print(calculate.getCompatibility(number) + ", ");
            }
        }
        System.out.print("\b\b\n"); //remover of last blank space and comma + starting new line.
        System.out.println();
    }

    protected void printCalculation (long number) {
        if (catchError()) {
            convertRequest();
        } else {
            System.out.println("Properties of " + NumberFormat.getInstance(Locale.US).format(number));
            for (CanCalculate calculate : calculateList) {
                System.out.println(calculate.getName() + ": " + calculate.isCompatible(number));
            }
            System.out.println();
        }
    }

    //Overload
    protected void printCalculation (long number, int multiplication) {
        if (catchError()) {
            convertRequest();
        } else {
            for (int i = 0; i < multiplication; i++) {
                printNumberLine(number);
                number++;
            }
            System.out.println();
        }
    }

    //Overload
    protected void printCalculation (long number, int multiplication, String name) {
        if (catchError()) {
            convertRequest();
        } else {
            int count = 0;
            while (count != multiplication) {
                for (CanCalculate property: calculateList) {
                    if (name.equals(property.getCompatibility(number))) {
                        printNumberLine(number);
                        count++;
                        break;
                    }
                }
                number++;
            }
            System.out.println();
        }
    }

    protected boolean isExit() {
        return number == 0;
    }

}