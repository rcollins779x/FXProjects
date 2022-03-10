package RestaurantFX.FoodNdrinks;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class FoodOrDrink {
    ArrayList<String> opt = new ArrayList<>();
    String name, description;
    int type = 0;
    double price = 0;

    public FoodOrDrink(String[] line) {
        for (int i = 0; i < line.length; i++)
            switch (i) {
                case 0 -> name = line[i];
                case 1 -> type = line[1].equals("Main") ? 1 : 2;
                case 2 -> price = Double.parseDouble(line[2]);
                case 3 -> description = line[3];
                case 4 -> opt.addAll(Arrays.asList(line).subList(4, line.length));
            }
    }

    public void display() {
        System.out.print("\n" + name);
        System.out.printf(price == 0 ? "" : " for $%.2f", price);
        System.out.print(description != null && !description.equals("") ? ", " + description : "");

        for (String item : opt) System.out.print(item != null ? "\n\t" + item : "");
    }

    @Override
    public String toString() {
        return "FoodOrDrink{" +
                "opt=" + opt +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
