import java.util.ArrayList;

public class Intake {
    private int totalWaterDrank;
    private int totalCaloriesEaten;
    private int goalWater;
    private int goalCalories;
    private ArrayList<String> timeArray;

    public Intake(int goalW, int goalC) {
        goalWater = goalW;
        goalCalories = goalC;
        timeArray = new ArrayList<String>();
    }


    public int getGoalWater() {
        return goalWater;
    }

    public int getTotalCaloriesEaten() {
        return totalCaloriesEaten;
    }

    public int getTotalWaterDrank() {
        return totalWaterDrank;
    }

    public int getGoalCalories() {
        return goalCalories;
    }

    public void setGoalCalories(int goalCalories) {
        this.goalCalories = goalCalories;
    }

    public void setGoalWater(int goalWater) {
        this.goalWater = goalWater;
    }

    public void addWater(int water, String time) {
        totalWaterDrank += water;
        timeArray.add(time + "." + water + "w");
    }
    public void addCalories(int calories, String time) {
        totalCaloriesEaten += calories;
        timeArray.add(time + "." + calories + "c");
    }

    public String isPassingWaterGoal() {
        if(totalWaterDrank == goalWater) {
            return "Well done, you drank up to your goal!";
        }
        else if(totalWaterDrank > goalWater) {
            return "Superb! You drank more than your goal!";
        }
        else if(totalWaterDrank * 1.1 >= goalWater) {
            return "Keep going! You're almost at your goal!";
        }
        else return "You still haven't reached your goal yet! DRINK MORE!";
    }
    public String isPassingCaloricGoal() {
        if(totalCaloriesEaten == goalCalories) {
            return "Well done, you've reached your caloric threshold!";
        }
        else if (totalCaloriesEaten > goalCalories) {
            return "You passed your goal! Are you sure you want to keep eating...?";
        }
        else if(totalCaloriesEaten * 1.1 >= goalCalories) {
            return "You're almost at your caloric goal! Just a bit more food!";
        }
        else return "You're not there yet. Keep eating!";
    }

    public ArrayList<String> organizeTime() {
        int countAM = 0;
        int countPM = 0;
        for(int i = 0; i < timeArray.size(); i++) {
                timeArray.set(i,timeArray.get(i).toLowerCase());
                if (timeArray.get(i).indexOf("am") > -1) {
                    countAM++;
                    timeArray.add(0,timeArray.remove(i));
                }
            }
        countPM = timeArray.size() - countAM;
        int ind = timeArray.get(0).indexOf(".");
        int smallest = Integer.parseInt(timeArray.get(0).substring(0, ind - 2));
        for(int a = 1; a < timeArray.size() - countPM; a++) {
            ind = timeArray.get(a).indexOf(".");
            int temp = Integer.parseInt(timeArray.get(a).substring(0, ind - 2));
            if(temp < smallest) {
                timeArray.add(0, timeArray.remove(a));
            }
        }

        ind = timeArray.get(timeArray.size() - countPM).indexOf(".");
        smallest = Integer.parseInt(timeArray.get(timeArray.size() - countPM).substring(0, ind - 2));
        for(int p = timeArray.size() - countPM + 1; p < timeArray.size(); p++) {
            ind = timeArray.get(p).indexOf(".");
            int temp = Integer.parseInt(timeArray.get(p).substring(0, ind - 2));
            if(temp > smallest) {
                timeArray.add(timeArray.size() - countPM, timeArray.remove(p));
            }
        }
        return timeArray;
    }

    public void history(ArrayList<String> timeArr) {
    for(int i = 0; i < timeArr.size(); i++) {
        int ind = timeArr.get(i).indexOf(".");
        if(timeArr.get(i).substring(timeArr.get(i).length() - 1).equals("w")) {
            System.out.println("You drank: " + timeArr.get(i).substring(ind + 1, timeArr.get(i).length() - 1) + " fl oz at " + timeArr.get(i).substring(0, ind));
        }
        else {
            System.out.println("You ate: " + timeArr.get(i).substring(ind + 1, timeArr.get(i).length() - 1) + " calories at " + timeArr.get(i).substring(0, ind));
        }
    }
    }

    public void reset() {
        totalWaterDrank = 0;
        totalCaloriesEaten = 0;
        goalCalories = 0;
        goalWater = 0;
        for(int i = timeArray.size() - 1; i >= 0; i--) {
        timeArray.remove(1);
        }
    }

}
