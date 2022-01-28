package RestaurantFX.backend;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class Beverage {
    ArrayList<String> opt = new ArrayList<>();
    String name, description;
    int type = 0;
    double price = 0;

    Beverage(String[] line) {
        for (int i = 0; i < line.length; i++)
            switch (i) {
                case 0 -> name = line[i];
                case 1 -> type = line[1].equals("Main") ? 1 : 2;
                case 2 -> price = Double.parseDouble(line[2]);
                case 3 -> description = line[3];
                case 4 -> opt.addAll(Arrays.asList(line).subList(4, line.length));
            }
    }
}