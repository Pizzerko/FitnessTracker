import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
public class Runner {
    public static void main(String[] args) {
        /**try {
            File file = new File("src/Info.data");
            Scanner s = new Scanner(file);

        }
        catch (FileNotFoundException e) {

        }
         */
        Intake i = new Intake(100, 2000);
        i.addWater(12, "12pm");
        i.addCalories(200, "9am");
        i.addWater(15, "5pm");
        i.addCalories(500, "6am");
        i.addCalories(1100, "10pm");
        i.history(i.organizeTime());
        System.out.println(i.getTotalCaloriesEaten());
        System.out.println(i.getTotalWaterDrank());
        System.out.println(i.isPassingCaloricGoal());
        System.out.println(i.isPassingWaterGoal());
    }
}
