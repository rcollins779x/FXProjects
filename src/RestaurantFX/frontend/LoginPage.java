package RestaurantFX.frontend;

import static RestaurantFX.Restaurant.getInt;
import static RestaurantFX.Restaurant.getString;
import static RestaurantFX.backend.LoginController.*;

import RestaurantFX.backend.NewUser;

import java.util.Locale;

import lombok.Data;

@Data
public class LoginPage {
    public LoginPage() {

        for (int choice = -1; choice != 0; ) {
            System.out.println("0. Exit");
            System.out.println("1. Create new user");
            System.out.println("2. Login");
            System.out.println("3. Forgot password");
            choice = getInt();

            switch (choice) {
                case 0 -> System.out.println("Have a nice day!");
                case 1 -> CreateUser();
                case 2 -> LoginPrompt();
                case 3 -> ForgotPassword();
                default -> System.out.println("Invalid Entry.  try again.");
            }
        }
    }

    public void LoginPrompt() {
        System.out.println("What is your position?\n1. Manager\n2. Wait Staff\n3. Cook\n4. Busboy\n5. Hostess\n6. Bartender");
        int title = getInt();

        System.out.print("Enter user name: ");
        String user = getString();

        System.out.print("Enter password: ");
        String password = getString();

        boolean access = checkCredentials(user, password, title);
        System.out.println(access ? "Success!" : "Denied!");

        if (access) switch (title) {
            case 1 -> new ManagerPage();
            case 2 -> new WaitStaffPage();
            case 3 -> new CookPage();
            case 4 -> new BusboyPage();
            case 5 -> new Hostess();
            case 6 -> new BartenderPage();
            default -> System.out.println("Page not found.");
        }
    }

    public void CreateUser() {
        NewUser user = new NewUser();

        System.out.print("Enter first name: ");
        user.setFirst(getString());
        System.out.print("Enter last name: ");
        user.setLast(getString());
        System.out.println("Chose a Job\n1. Manager\n2. Wait Staff\n3. Cook\n4. Busboy\n5. Hostess\n6. Bartender");
        user.setJobTitle(getInt());
        System.out.print("Enter password (no restrictions): ");
        user.setPassword(getString());
        user.setId(settings.size());
        user.setUserID((user.getFirst().charAt(0) + user.getLast() + user.getId()).toLowerCase(Locale.ROOT));

        settings.add(user);
        if(UpdateSettings())
            System.out.println("Your username is " + user.getUserID());
    }

    private void ForgotPassword() {
        System.out.println("If you don't know your username, please ask your manager");
        System.out.println("Enter your username:");
        String userID = getString();

        if (settings.size() == 0) System.out.println("Settings is empty. Please let your manager know.");
        for (NewUser user : settings) {
            if (user.getUserID().equals(userID)) {
                System.out.println("1. Retrieve current password.\n2. Enter new password.");

                switch (getInt()) {
                    case 1 -> System.out.println("Current password: " + user.getPassword());
                    case 2 -> {
                        System.out.print("Enter password (no restrictions): ");
                        user.setPassword(getString());
                        UpdateSettings();
                    }
                }
                return;
            }

        }
        System.out.println("Username not found.");
    }

}
