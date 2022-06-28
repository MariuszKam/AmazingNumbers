public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n");
        Menu.printInstructions();
        do {
            Menu.askRequest();
            System.out.println();
            if (Menu.multiplication > 1) {
                Menu.printCalculation(Menu.number, Menu.multiplication);
            } else if (Menu.number != 0) {
                Menu.printCalculation(Menu.number);
            }
        } while (!Menu.isExit());
        System.out.print("Goodbye!");

    }
}