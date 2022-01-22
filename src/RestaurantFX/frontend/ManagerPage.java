package RestaurantFX.frontend;

import static RestaurantFX.backend.Controller.getInt;

public class ManagerPage {
    ManagerPage() {
        //assign tables / assign schedule /
        for (int i = -1; i != 0; i = getInt()) {
            System.out.println("Menu\n0. Exit\n1. Display Menu");
            switch(i) {
                case 1 -> new MenuPage();
            }
        }
    }
}
