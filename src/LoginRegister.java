
import java.io.*;
import java.util.Scanner;

public class LoginRegister {

    Scanner sc = new Scanner(System.in);

    String file = "users.txt";

    // Register
    public void register() throws IOException {

        System.out.println("\n===== REGISTER =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Save account
        FileWriter fw = new FileWriter(file, true);

        fw.write(username + "," + password + "\n");

        fw.close();

        System.out.println("Registration Successful!");
    }

    // Login
    public boolean login() throws IOException {

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        File f = new File(file);

        if (!f.exists()) {

            System.out.println("Please Register First!");

            return false;
        }

        BufferedReader br = new BufferedReader(
            new FileReader(file)
        );

        String line;

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",", 2);

            if (data.length == 2 &&
                data[0].equals(username) &&
                data[1].equals(password)) {

                br.close();

                System.out.println("Login Successful!");

                return true;
            }
        }

        br.close();

        System.out.println("Wrong Username or Password!");

        return false;
    }
}
