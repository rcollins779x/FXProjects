package RestaurantFX.backend;

import RestaurantFX.Restaurant;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    public static ArrayList<NewUser> settings = new ArrayList<>();

    public static boolean checkCredentials(String name, String password, int title) {
        for (NewUser user : settings)
            if (user.getUserID().equals(name) && user.getPassword().equals(password) && user.getJobTitle() == title) return true;
        return false;
    }

    public static void LoadSettings() {

        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/settings.csv");
            //FileWriter write = new FileWriter(file);
            Scanner scan = new Scanner(file);              //Opens txt for reading

            //System.out.println("The file statistics for file: " + file.getAbsolutePath());
            //write.write("The file statistics for file: " + file.getAbsolutePath() + "\n");

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                //System.out.println("Before: " + Arrays.toString(line));
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").substring(line[i].indexOf('=') + 1));
                System.out.println("After: " + Arrays.toString(line));
                settings.add(new NewUser(line));
            }
            //write.close();
            scan.close();
        } catch (IOException ignored) {
        }
    }

    public static void UpdateSettings(NewUser user) {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/settings.csv");
            //if (file.exists()) System.out.println("Delete current settings: " + file.delete());

            FileWriter write = new FileWriter(file);
            Scanner scan = new Scanner(file);              //Opens txt for reading

            System.out.println("Settings: ");
            for (NewUser setting : settings) {
                write.write(setting + "\n");
                System.out.println(setting);
            }

            System.out.println("Completed updating settings: true");
            write.close();
            scan.close();
        } catch (IOException ignored) {
        }
    }

    public static String getString() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public static int getInt() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static void underMaintenance() {
        System.out.println("Under Maintenance.");
    }
}
