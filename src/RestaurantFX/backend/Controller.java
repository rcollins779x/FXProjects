package RestaurantFX.backend;

import RestaurantFX.Restaurant;
import RestaurantFX.frontend.HomePage;
import RestaurantFX.frontend.LoginPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    public static ArrayList<NewUser> settings = new ArrayList<>();
    public static ArrayList<Appetizer> appetizers = new ArrayList<>();
    private static ArrayList<Beverage> beverages = new ArrayList<>();
    private static ArrayList<Salad> salads = new ArrayList<>();

    public static void LoadHomePage() {
        new HomePage();
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

    public static void LoadLoginPage() {
        new LoginPage();
    }

    public static void LoadBeverages() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/beverages.csv");
            Scanner scan = new Scanner(file);              //Opens txt for reading

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").replaceAll("_", ",").substring(line[i].indexOf('=') + 1));
                //System.out.println("After: " + Arrays.toString(line));
                beverages.add(new Beverage(line));
            }
            for (Beverage item : beverages) {
                System.out.print("\n" + item.name);
                System.out.printf(item.price == 0 ? "" : " for $%.2f", item.price);
                System.out.print(item.description != null && !item.description.equals("") ? ", " + item.description : "");

                for(int i = 0; i < item.opt.size(); i++)
                    System.out.print(item.opt.get(i) != null ? "\n\t" + item.opt.get(i) : "");
            }

            scan.close();
        } catch (IOException ignored) {
        }
    }

    public static void LoadAppetizers() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/appetizers.csv");
            Scanner scan = new Scanner(file);              //Opens txt for reading

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").replaceAll("_", ",").substring(line[i].indexOf('=') + 1));
                //System.out.println("After: " + Arrays.toString(line));
                appetizers.add(new Appetizer(line));
            }
            for (Appetizer item : appetizers) {
                System.out.print("\n" + item.name);
                System.out.printf(item.price == 0 ? "" : " for $%.2f", item.price);
                System.out.print(item.description != null && !item.description.equals("") ? ", " + item.description : "");

                for(int i = 0; i < item.opt.size(); i++)
                    System.out.print(item.opt.get(i) != null ? "\n\t" + item.opt.get(i) : "");
            }

            scan.close();
        } catch (IOException ignored) {
        }
    }
    public static void LoadSalads() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/salads.csv");
            Scanner scan = new Scanner(file);              //Opens txt for reading

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").replaceAll("_", ",").substring(line[i].indexOf('=') + 1));
                //System.out.println("After: " + Arrays.toString(line));
                salads.add(new Salad(line));
            }
            for (Salad item : salads) {
                System.out.print("\n" + item.name);
                System.out.printf(item.price == 0 ? "" : " for $%.2f", item.price);
                System.out.print(item.description != null && !item.description.equals("") ? ", " + item.description : "");

                for(int i = 0; i < item.opt.size(); i++)
                    System.out.print(item.opt.get(i) != null ? "\n\t" + item.opt.get(i) : "");
            }

            scan.close();
        } catch (IOException ignored) {
        }
    }
}
