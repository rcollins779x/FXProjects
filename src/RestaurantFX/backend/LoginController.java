package RestaurantFX.backend;

import RestaurantFX.Restaurant;
import RestaurantFX.frontend.LoginPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoginController {
    public static ArrayList<NewUser> settings = new ArrayList<>();

    public static void LoadLoginPage() {
        new LoginPage();
    }

    public static boolean checkCredentials(String name, String password, int title) {
        for (NewUser user : settings)
            if (user.getUserID().equals(name) && user.getPassword().equals(password) && user.getJobTitle() == title) return true;
        return false;
    }

    public static void LoadSettings() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/settings.csv");
            Scanner scan = new Scanner(file);              //Opens txt for reading

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                //System.out.println("Before: " + Arrays.toString(line));
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").substring(line[i].indexOf('=') + 1));
                //System.out.println("After: " + Arrays.toString(line));
                settings.add(new NewUser(line));
            }
            scan.close();
        } catch (IOException ignored) {
        }
    }

    public static boolean UpdateSettings() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/settings.csv");

            FileWriter write = new FileWriter(file);
            for (var user : settings) {
                write.write(user + "\n");
                System.out.println(user);
            }
            write.close();
            return true;

        } catch (IOException ignored) {
            System.out.println("Failed to load settings.csv");
            return false;
        }
    }
}
