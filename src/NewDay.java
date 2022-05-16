import java.util.*;
public class NewDay {
    private ArrayList<Intake> intakeDays;
    private ArrayList<Exercise> exerciseDays;

    public NewDay(Intake obj, Exercise objj) {
        exerciseDays = new ArrayList<Exercise>();
        intakeDays = new ArrayList<Intake>();
        if(intakeDays.size() == 7 && exerciseDays.size() == 7) resetArrays();
        intakeDays.add(obj);
        exerciseDays.add(objj);
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
        avg /= intakeDays.size();
        return avg;
    }
    public double averageCaloriesEaten() {
        double avg = 0;
        for(Intake obj : intakeDays) {
            avg += obj.getTotalCaloriesEaten();
        }
        avg /= intakeDays.size();
        return avg;
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

    private void resetArrays() {
            System.out.println("A new week has started!");
            for(int i = 0; i < intakeDays.size(); i++) {
                intakeDays.remove(i);
                exerciseDays.remove(i);
                i--;
            }
    }

}
