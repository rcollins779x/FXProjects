package RestaurantFX.frontend;

import RestaurantFX.FoodNdrinks.FoodOrDrink;
import RestaurantFX.backend.NewOrder;

import java.util.ArrayList;

import static RestaurantFX.Restaurant.getInt;
import static RestaurantFX.backend.CartController.cart;
import static RestaurantFX.backend.MenuController.*;

public class OrderEntryPage {

    public OrderEntryPage() {

        NewOrder newOrder = new NewOrder();
        System.out.print("Enter table number: ");
        newOrder.setTable(getInt() - 1);
        System.out.print("Enter seat number: ");
        newOrder.setSeat(getInt() - 1);

        for (int choice = -1; choice != 0; ) {

            //check if any existing orders for this table/seat
            //if not...
            System.out.println("0. Complete Order");
            System.out.println("1. View Current Order");
            System.out.println("2. Beverages");
            System.out.println("3. Appetizers");
            System.out.println("4. Burgers");
            System.out.println("5. Entree");
            System.out.println("6. Salads");
            System.out.println("7. Sandwiches");
            System.out.println("8. Wraps");
            System.out.println("9. Sides");
            choice = getInt();
            ArrayList<FoodOrDrink> food = new ArrayList<>();
            switch (choice) {
                case 0 -> cart[newOrder.getTable()][newOrder.getSeat()] = newOrder;
                case 1 -> newOrder.display();
                case 2 -> Display(food = beverages);
                case 3 -> Display(food = appetizers);
                case 4 -> Display(food = burgers);
                case 5 -> Display(food = entree);
                case 6 -> Display(food = salads);
                case 7 -> Display(food = sandwiches);
                case 8 -> Display(food = wraps);
                case 9 -> Display(food = sides);
                default -> System.out.println("Invalid Entry.  try again.");
            }
            if (choice > 1 && choice < 10) {
                System.out.print("\nEnter item number: ");
                int temp = getInt();
                if (temp != 0) newOrder.addItem(food.get(temp - 1));
            }
        }
    }
}
