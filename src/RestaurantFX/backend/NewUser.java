package RestaurantFX.backend;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewUser {
    private String first, last, password, userID;
    private int jobTitle, id;

    public NewUser(String[] line) {
        first = line[0];
        last = line[1];
        password = line[2];
        userID = line[3];
        jobTitle = Integer.parseInt(line[4]);
        id = Integer.parseInt(line[5]);
    }
}
