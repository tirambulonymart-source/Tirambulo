import java.util.Scanner;

public class LoginSystem {
    static String[][] accounts = new String[3][2]; // [username, password]
    static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    register(scanner);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    static void register(Scanner scanner) {
        if (userCount >= accounts.length) {
            System.out.println("User limit reached.");
            return;
        }

        System.out.print("nymart: ");
        String user = scanner.nextLine();

        System.out.print("nymart123: ");
        String pass = scanner.nextLine();

        System.out.print("nymart123: ");
        String confirm = scanner.nextLine();

        if (!pass.equals(confirm)) {
            System.out.println("Passwords do not match.");
            return;
        }

        accounts[userCount][0] = user;
        accounts[userCount][1] = pass;
        userCount++;

        System.out.println("User registered successfully.");
    }

    static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String user = scanner.nextLine();

        System.out.print("Enter password: ");
        String pass = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (accounts[i][0].equals(user) && accounts[i][1].equals(pass)) {
                System.out.println("Hello, " + user + "!");
                return;
            }
        }

        System.out.println("Login failed. Wrong username or password.");
    }
}
