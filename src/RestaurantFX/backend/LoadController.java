package RestaurantFX.backend;

import RestaurantFX.FoodNdrinks.*;
import RestaurantFX.Restaurant;
import RestaurantFX.frontend.HomePage;
import RestaurantFX.frontend.LoginPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LoadController {
    public static ArrayList<NewUser> settings = new ArrayList<>();
    private static final ArrayList<Appetizer> appetizers = new ArrayList<>();
    private static final ArrayList<Beverage> beverages = new ArrayList<>();
    private static final ArrayList<Salad> salads = new ArrayList<>();
    private static final ArrayList<Sandwiches> sandwiches = new ArrayList<>();
    private static final ArrayList<Sides> sides = new ArrayList<>();
    private static final ArrayList<Entree> entree = new ArrayList<>();
    private static final ArrayList<Wraps> wraps = new ArrayList<>();
    private static final ArrayList<Burgers> burgers = new ArrayList<>();


    public static void LoadMenu() {
        LoadAppetizers();
        LoadBeverages();
        LoadSalads();
        LoadSides();
        LoadEntree();
        LoadSandwiches();
        LoadWraps();
        LoadBurgers();
    }

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

    public static void UpdateSettings() {
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
            System.out.println("Failed to load settings.csv");
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
            for (var item : beverages) {
                System.out.print("\n" + item.getName());
                System.out.printf(item.getPrice() == 0 ? "" : " for $%.2f", item.getPrice());
                System.out.print(item.getDescription() != null && !item.getDescription().equals("") ? ", " + item.getDescription() : "");

                for (int i = 0; i < item.getOpt().size(); i++)
                    System.out.print(item.getOpt().get(i) != null ? "\n\t" + item.getOpt().get(i) : "");
            }

            scan.close();
        } catch (IOException ignored) {
            System.out.println("Failed to load beverages.csv");
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
            for (var item : appetizers) {
                System.out.print("\n" + item.getName());
                System.out.printf(item.getPrice() == 0 ? "" : " for $%.2f", item.getPrice());
                System.out.print(item.getDescription() != null && !item.getDescription().equals("") ? ", " + item.getDescription() : "");

                for (int i = 0; i < item.getOpt().size(); i++)
                    System.out.print(item.getOpt().get(i) != null ? "\n\t" + item.getOpt().get(i) : "");
            }

            scan.close();
        } catch (IOException ignored) {
            System.out.println("Failed to load appetizers.csv");
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
            for (var item : salads) {
                System.out.print("\n" + item.getName());
                System.out.printf(item.getPrice() == 0 ? "" : " for $%.2f", item.getPrice());
                System.out.print(item.getDescription() != null && !item.getDescription().equals("") ? ", " + item.getDescription() : "");

                for (int i = 0; i < item.getOpt().size(); i++)
                    System.out.print(item.getOpt().get(i) != null ? "\n\t" + item.getOpt().get(i) : "");
            }
            scan.close();
        } catch (IOException ignored) {
            System.out.println("Failed to load salads.csv");
        }
    }

    public static void LoadSandwiches() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/sandwiches.csv");
            Scanner scan = new Scanner(file);              //Opens txt for reading

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").replaceAll("_", ",").substring(line[i].indexOf('=') + 1));
                //System.out.println("After: " + Arrays.toString(line));
                sandwiches.add(new Sandwiches(line));
            }
            for (var item : sandwiches) {
                System.out.print("\n" + item.getName());
                System.out.printf(item.getPrice() == 0 ? "" : " for $%.2f", item.getPrice());
                System.out.print(item.getDescription() != null && !item.getDescription().equals("") ? ", " + item.getDescription() : "");

                for (int i = 0; i < item.getOpt().size(); i++)
                    System.out.print(item.getOpt().get(i) != null ? "\n\t" + item.getOpt().get(i) : "");
            }
            scan.close();
        } catch (IOException ignored) {
            System.out.println("Failed to load sandwiches.csv");
        }
    }

    public static void LoadSides() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/sides.csv");
            Scanner scan = new Scanner(file);              //Opens txt for reading

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").replaceAll("_", ",").substring(line[i].indexOf('=') + 1));
                //System.out.println("After: " + Arrays.toString(line));
                sides.add(new Sides(line));
            }
            for (var item : sides) {
                System.out.print("\n" + item.getName());
                System.out.printf(item.getPrice() == 0 ? "" : " for $%.2f", item.getPrice());
                System.out.print(item.getDescription() != null && !item.getDescription().equals("") ? ", " + item.getDescription() : "");

                for (int i = 0; i < item.getOpt().size(); i++)
                    System.out.print(item.getOpt().get(i) != null ? "\n\t" + item.getOpt().get(i) : "");
            }
            scan.close();
        } catch (IOException ignored) {
            System.out.println("Failed to load sides.csv");
        }
    }
    public static void LoadEntree() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/entree.csv");
            Scanner scan = new Scanner(file);              //Opens txt for reading

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").replaceAll("_", ",").substring(line[i].indexOf('=') + 1));
                //System.out.println("After: " + Arrays.toString(line));
                entree.add(new Entree(line));
            }
            for (var item : entree) {
                System.out.print("\n" + item.getName());
                System.out.printf(item.getPrice() == 0 ? "" : " for $%.2f", item.getPrice());
                System.out.print(item.getDescription() != null && !item.getDescription().equals("") ? ", " + item.getDescription() : "");

                for (int i = 0; i < item.getOpt().size(); i++)
                    System.out.print(item.getOpt().get(i) != null ? "\n\t" + item.getOpt().get(i) : "");
            }
            scan.close();
        } catch (IOException ignored) {
            System.out.println("Failed to load entree.csv");
        }
    }

    public static void LoadWraps() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/wraps.csv");
            Scanner scan = new Scanner(file);              //Opens txt for reading

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").replaceAll("_", ",").substring(line[i].indexOf('=') + 1));
                //System.out.println("After: " + Arrays.toString(line));
                wraps.add(new Wraps(line));
            }
            for (var item : wraps) {
                System.out.print("\n" + item.getName());
                System.out.printf(item.getPrice() == 0 ? "" : " for $%.2f", item.getPrice());
                System.out.print(item.getDescription() != null && !item.getDescription().equals("") ? ", " + item.getDescription() : "");

                for (int i = 0; i < item.getOpt().size(); i++)
                    System.out.print(item.getOpt().get(i) != null ? "\n\t" + item.getOpt().get(i) : "");
            }
            scan.close();
        } catch (IOException ignored) {
            System.out.println("Failed to load wraps.csv");
        }
    }

    public static void LoadBurgers() {
        try {
            String directory = (Restaurant.class.getPackage().getName()).replaceAll("\\.", "/");
            File file = new File("resources/" + directory + "/burgers.csv");
            Scanner scan = new Scanner(file);              //Opens txt for reading

            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(",[ ]*");
                Arrays.setAll(line, i -> line[i].replaceAll("\\)", "").replaceAll("_", ",").substring(line[i].indexOf('=') + 1));
                //System.out.println("After: " + Arrays.toString(line));
                burgers.add(new Burgers(line));
            }
            for (var item : burgers) {
                System.out.print("\n" + item.getName());
                System.out.printf(item.getPrice() == 0 ? "" : " for $%.2f", item.getPrice());
                System.out.print(item.getDescription() != null && !item.getDescription().equals("") ? ", " + item.getDescription() : "");

                for (int i = 0; i < item.getOpt().size(); i++)
                    System.out.print(item.getOpt().get(i) != null ? "\n\t" + item.getOpt().get(i) : "");
            }
            scan.close();
        } catch (IOException ignored) {
            System.out.println("Failed to load wraps.csv");
        }
    }
}
