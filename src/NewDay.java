import java.util.*;
public class NewDay {
    private ArrayList<Intake> intakeDays;
    private ArrayList<Exercise> exerciseDays;

    public NewDay() {
        exerciseDays = new ArrayList<Exercise>();
        intakeDays = new ArrayList<Intake>();
    }

    public boolean canCalculateAvg() {
        if(intakeDays.size() == 0 && exerciseDays.size() == 0) return false;
        return true;
    }

    public ArrayList<Exercise> getExerciseDays() {
        return exerciseDays;
    }

    public ArrayList<Intake> getIntakeDays() {
        return intakeDays;
    }

    public double averageWaterDrank() {
        double avg = 0;
        for(Intake obj : intakeDays) {
            avg += obj.getTotalWaterDrank();
        }
        return avg / intakeDays.size();
    }
    public double averageCaloriesEaten() {
        double avg = 0;
        for(Intake obj : intakeDays) {
            avg += obj.getTotalCaloriesEaten();
        }
        return avg / intakeDays.size();
    }

    public double averageStepsTaken() {
        double avg = 0;
        for(Exercise obj : exerciseDays) {
            avg += obj.getTotalStepsTook();
        }
        return avg / exerciseDays.size();
    }

    public double averageCaloriesBurned() {
        double avg = 0;
        for(Exercise obj : exerciseDays) {
            avg += obj.getTotalCaloriesBurned();
        }
        return avg / exerciseDays.size();
    }

    public void addIntake(Intake obj) {
        intakeDays.add(obj);
    }

    public void addExercise(Exercise obj) {
        exerciseDays.add(obj);
    }

    public void resetArrays() {
        if(intakeDays.size() == 8 && exerciseDays.size() == 8) {
            System.out.println("A new week has started!");
            for (int i = 0; i < intakeDays.size(); i++) {
                intakeDays.remove(i);
                exerciseDays.remove(i);
                i--;
            }
        }
    }

}
