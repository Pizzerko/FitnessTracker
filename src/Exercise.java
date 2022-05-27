import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Exercise {
    private int totalStepsTook;
    private int totalCaloriesBurned;
    private int caloricGoal;

    public Exercise(int caloricG) {
        caloricGoal = caloricG;
    }

    public int getTotalStepsTook() {
        return totalStepsTook;
    }

    public int getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public int getCaloricGoal() {
        return caloricGoal;
    }

    public void setCaloricGoal(int caloricGoal) {
        this.caloricGoal = caloricGoal;
    }

    public void setSteps(int steps) {
        totalStepsTook = steps;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        totalCaloriesBurned = caloriesBurned;
    }

    public void addSteps(int steps) {
        totalStepsTook += steps;
        totalCaloriesBurned += calculateCalories(steps);
    }

    private int calculateCalories(int steps) {
        int random = (int)((Math.random() * 11) + 30);
        return (int) (steps / 1000.0) * random;
    }

    public String isWithinGoal() {
        if(totalCaloriesBurned == caloricGoal) {
            return"YOu've burned your goal number of calories! Keep it up!";
        }
        if(totalCaloriesBurned > caloricGoal) {
            return"You're past your caloric goal. You walked a lot didn't you.";
        }
        if((int) (totalCaloriesBurned * 1.1) >= caloricGoal) {
            return"You're close! Walk more!";

        }
        else return "You're not there, walk more!";
    }

    public void reset() {
        totalStepsTook = 0;
        totalCaloriesBurned = 0;
        caloricGoal = 0;
    }

    public void save() {
        try {
            File f = new File("src/exercise.data");
            f.createNewFile();
            FileWriter ff = new FileWriter("src/exercise.data");
            ff.write(caloricGoal + "|");
            ff.write(totalCaloriesBurned + "|");
            ff.write(totalStepsTook + "\n");
            ff.close();
        }
        catch (IOException e) {
            System.out.println("This file isn't a thing.");
            e.printStackTrace();
        }
    }
}
