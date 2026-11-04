
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

        boolean success = false;

        if (choice == 1) {

            obj.register();

            System.out.println("\nNow Login to continue.");

            success = obj.login();

        } 
        else if (choice == 2) {

            success = obj.login();

        } 
        else {

            System.out.println("Invalid Choice!");
            return;

        }

        // Start Terminal Game
        if (success) {

            System.out.println("\nLogin Successful!");
            System.out.println("Starting Tic Tac Toe...\n");

            TicTacToe.main(new String[0]);

        } 
        else {

            System.out.println("Login Failed!");

        }

        sc.close();
    }
}
