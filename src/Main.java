public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n");
        Menu menu = new Menu();
        menu.printInstructions();
        do {
            menu.convertRequest();
            System.out.println();
        } while (!menu.isExit());
        System.out.print("Goodbye!");

    }
}