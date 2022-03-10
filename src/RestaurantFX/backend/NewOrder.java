package RestaurantFX.backend;

import RestaurantFX.FoodNdrinks.FoodOrDrink;
import lombok.Data;

import java.util.ArrayList;

import static RestaurantFX.backend.MenuController.beverages;
import static RestaurantFX.backend.MenuController.sandwiches;

@Data
public class NewOrder {
    ArrayList<FoodOrDrink> items = new ArrayList<>();
    int table;
    int seat;

    public NewOrder(String[] line) {

    }

    public NewOrder(FoodOrDrink line) {
    }

    public NewOrder() {

    }

    public void addItem(FoodOrDrink item) {
        items.add(item);
    }

    public void display() {
        System.out.println("T: " + (table + 1) + ", S: " + (seat + 1));
        for (var item : items) {
            System.out.println(item.getName() + "\t$" + item.getPrice());

            System.out.println(item.getOpt());

        }
    }
}
