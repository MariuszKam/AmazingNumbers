import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Menu {

    long number;
    int multiplication = 1;
    String nameOne = "";
    String nameTwo = "";
    Scanner userInput = new Scanner(System.in);
    List<CanCalculate> calculateList = List.of(
            new EvenNumber(),
            new OddNumber(),
            new BuzzNumber(),
            new DuckNumber(),
            new PalindromicNumber(),
            new GapfulNumber(),
            new SpyNumber(),
            new SquareNumber(),
            new SunnyNumber()
    );
    final String[] properties = {"odd", "even", "buzz", "duck", "palindromic", "gapful", "spy", "sunny", "square"};

    protected void setDefault () {
        number = 0;
        multiplication = 1;
        nameOne = "";
        nameTwo = "";
    }


    protected void printInstructions() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "   * the first parameter represents a starting number;\n" +
                "   * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }

    protected String askRequest(Scanner userInput) {
        System.out.println("Enter a request: ");
        return userInput.nextLine();
    }

    protected void convertRequest() {
        setDefault();
        String command = askRequest(userInput);
        if (command.isEmpty()) {
            printInstructions();
            convertRequest();
            return;
        }

        if ("0".equals(command)) {
            number = 0;
            return;
        }

        ArrayList<String> listCommands = new ArrayList<>(List.of(command.split(" ")));
        if (listCommands.size() == 4) {
            number = Long.parseLong(listCommands.get(0));
            multiplication = Integer.parseInt(listCommands.get(1));
            nameOne = listCommands.get(2).toLowerCase(Locale.ROOT);
            nameTwo = listCommands.get(3).toLowerCase(Locale.ROOT);
            printCalculation(number, multiplication, nameOne, nameTwo);
        } else if (listCommands.size() == 3) {
            number = Long.parseLong(listCommands.get(0));
            multiplication = Integer.parseInt(listCommands.get(1));
            nameOne = listCommands.get(2).toLowerCase(Locale.ROOT);
            printCalculation(number, multiplication, nameOne);
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


    protected boolean catchNumberError() {
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

    protected boolean catchErrorOneName () {
        catchNumberError();
        if (!Arrays.asList(properties).contains(nameOne)) {
            System.out.println("The property [" + nameOne.toUpperCase() +
                    "] is wrong.\n Available properties: " + Arrays.toString(properties).toUpperCase());
            return true;
        }
        return false;
    }

    protected boolean catchErrorTwoNames () {
        catchNumberError();
        if (!Arrays.asList(properties).contains(nameOne)
                && !Arrays.asList(properties).contains(nameTwo) ) {
            System.out.println("The properties [" + nameOne.toUpperCase() + ", " + nameTwo.toUpperCase() +
                    "] are wrong.\n Available properties: " + Arrays.toString(properties).toUpperCase());
            return true;
        }
        if (!Arrays.asList(properties).contains(nameOne)) {
            System.out.println("The property [" + nameOne.toUpperCase() +
                    "] is wrong.\n Available properties: " + Arrays.toString(properties).toUpperCase());
            return true;
        }
        if (!Arrays.asList(properties).contains(nameTwo)) {
            System.out.println("The property [" + nameTwo.toUpperCase() +
                    "] is wrong.\n Available properties: " + Arrays.toString(properties).toUpperCase());
            return true;
        }
        return mutuallyExclusive();
    }

    protected boolean mutuallyExclusive () {
        if ((nameOne.equals("even") && nameTwo.equals("odd")) || (nameOne.equals("odd") && nameTwo.equals("even"))
                || (nameOne.equals("duck") && nameTwo.equals("spy")) || (nameOne.equals("spy") && nameTwo.equals("duck"))
                || (nameOne.equals("sunny") && nameTwo.equals("square")) || (nameOne.equals("square") && nameTwo.equals("sunny"))) {
            System.out.println("The request contains mutually exclusive properties: [" + nameOne.toUpperCase() + ", " +
                    nameTwo.toUpperCase() + "]\nThere are no numbers with these properties.");
            return true;
        }
        return false;
    }

    protected void printNumberLine (long number) {
        List<String> list = calculateList.stream().map(c -> c.getCompatibility(number)).filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(number + " is " + String.join(", ", list));
    }

    protected void printCalculation (long number) {
        if (catchNumberError()) {
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
        if (catchNumberError()) {
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
    protected void printCalculation (long number, int multiplication, String nameOne) {
        if (catchErrorOneName()) {
            convertRequest();
        } else {
            int count = 0;
            while (count != multiplication) {
                for (CanCalculate property : calculateList) {
                    if (nameOne.equals(property.getCompatibility(number))) {
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

    //Overload
    protected void printCalculation (long number, int multiplication, String nameOne, String nameTwo) {
        if (catchErrorTwoNames()) {
            convertRequest();
        } else {
            int count = 0;
            int countTwo = 0;
            while (count != multiplication) {
                for (CanCalculate property : calculateList) {
                    if (nameOne.equals(property.getCompatibility(number))) {
                        countTwo++;
                    }
                    if (nameTwo.equals(property.getCompatibility(number))) {
                        countTwo++;
                    }
                    if (countTwo == 2) {
                        printNumberLine(number);
                        count++;
                        break;
                    }
                }
                countTwo = 0;
                number++;
            }
            System.out.println();
        }
    }

    protected boolean isExit() {
        return number == 0;
    }

}
