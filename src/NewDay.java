import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class NewDay {
    private ArrayList<Integer> waterArr;
    private ArrayList<Integer> caloriesEArr;
    private ArrayList<Integer> stepsArr;
    private ArrayList<Double> caloriesBArr;

    public NewDay() {
        caloriesEArr = new ArrayList<Integer>();
        waterArr = new ArrayList<Integer>();
        stepsArr = new ArrayList<Integer>();
        caloriesBArr = new ArrayList<Double>();
    }

    public boolean canCalculateAvg() {
        if(waterArr.size() == 0) return false;
        return true;
    }

    public ArrayList<Integer> getCaloriesEArr() {
        return caloriesEArr;
    }

    public ArrayList<Integer> getWaterArr() {
        return waterArr;
    }

    public double averageWaterDrank() {
        double avg = 0;
        for(int obj : waterArr) {
            avg += obj;
        }
        return avg / waterArr.size();
    }
    public double averageCaloriesEaten() {
        double avg = 0;
        for(int obj : caloriesEArr) {
            avg += obj;
        }
        return avg / caloriesEArr.size();
    }

    public double averageStepsTaken() {
        double avg = 0;
        for(int obj : stepsArr) {
            avg += obj;
        }
        return avg / stepsArr.size();
    }

    public double averageCaloriesBurned() {
        double avg = 0;
        for(double obj : caloriesBArr) {
            avg += obj;
        }
        return avg / caloriesBArr.size();
    }

    public void addWater(int water) {
        waterArr.add(water);
    }

    public void addCaloriesEaten(int cEaten) {
        caloriesEArr.add(cEaten);
    }

    public void addSteps(int steps) {
        stepsArr.add(steps);
    }
    public void addCaloriesBurned(double cBurned) {
        caloriesBArr.add(cBurned);
    }

    public void resetArrays() {
        if(waterArr.size() > 7 && caloriesEArr.size() > 7) {
            System.out.println("A new week has started!");
            for (int i = 0; i < waterArr.size(); i++) {
                waterArr.remove(i);
                caloriesEArr.remove(i);
                i--;
            }
        }
    }

}
