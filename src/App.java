
import java.io.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        LoginRegister obj = new LoginRegister();

        System.out.println("===== TIC TAC TOE =====");
        System.out.println("1. Register");
        System.out.println("2. Login");

        System.out.print("Choose: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            // Register first
            obj.register();

            // Then Login
            boolean success = obj.login();

            // Start game
            if (success) {

                TicTacToe game = new TicTacToe();

            }

        } else if (choice == 2) {

            // Login directly
            boolean success = obj.login();

            if (success) {

                TicTacToe game = new TicTacToe();

            }

        } else {

            System.out.println("Invalid Choice!");

        }
    }
}
