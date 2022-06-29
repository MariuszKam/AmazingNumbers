public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n");
        Menu menu = new Menu();
        menu.printInstructions();
        do {
            menu.askRequest();
            System.out.println();
            if (menu.multiplication > 1) {
                menu.printCalculation(menu.number, menu.multiplication);
            } else if (menu.number != 0) {
                menu.printCalculation(menu.number);
            }
        } while (!menu.isExit());
        System.out.print("Goodbye!");

    }
}