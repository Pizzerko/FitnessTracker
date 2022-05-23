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

    private ArrayList<String> organizeTime() {
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
        for(int a = 0; a < timeArray.size() - countPM; a++) {
            int smallest = Integer.parseInt(timeArray.get(a).substring(0, ind - 2));
            if(smallest == 12) smallest = 0;
            for(int aa = 0; aa < timeArray.size() - countPM; aa++) {
                ind = timeArray.get(aa).indexOf(".");
                int temp = Integer.parseInt(timeArray.get(aa).substring(0, ind - 2));
                if (temp == 12) {
                    temp = 0;
                }
                if (temp < smallest) {
                    smallest = temp;
                    timeArray.add(0, timeArray.remove(aa));
                }
                else {
                    timeArray.add(a + 1, timeArray.remove(aa));
                }
            }
        }

        ind = timeArray.get(timeArray.size() - countPM).indexOf(".");
        for(int p = timeArray.size() - countPM; p < timeArray.size(); p++) {
            int smallest = Integer.parseInt(timeArray.get(timeArray.size() - countPM).substring(0, ind - 2));
            if (smallest == 12) smallest = 0;
            for (int pp = 0; pp < timeArray.size() - countPM; pp++) {
                ind = timeArray.get(pp).indexOf(".");
                int temp = Integer.parseInt(timeArray.get(pp).substring(0, ind - 2));
                if (temp == 12) temp = 0;
                if (temp < smallest) {
                    smallest = temp;
                    timeArray.add(countAM, timeArray.remove(p));
                }
                else {
                    timeArray.add(p + 1, timeArray.remove(pp));
                }
            }
        }
        return timeArray;
    }

    public void history() {
    ArrayList<String> timeArr = organizeTime();
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
        timeArray.remove(i);
        }
    }

}
