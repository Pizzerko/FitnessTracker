public class Exercise {
    private int totalStepsTook;
    private double totalCaloriesBurned;
    private double caloricGoal;

    public Exercise(double caloricG) {
        caloricGoal = caloricG;
    }

    public int getTotalStepsTook() {
        return totalStepsTook;
    }

    public double getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public double getCaloricGoal() {
        return caloricGoal;
    }

    public void setCaloricGoal(int caloricGoal) {
        this.caloricGoal = caloricGoal;
    }

    public void addSteps(int steps) {
        totalStepsTook += steps;
        totalCaloriesBurned += calculateCalories(steps);
    }

    private double calculateCalories(int steps) {
        int random = (int)((Math.random() * 11) + 30);
        return (steps / 1000.0) * random;
    }

    public String isWithinGoal() {
        if(totalCaloriesBurned == caloricGoal) {
            return"YOu've burned your goal number of calories! Keep it up!";
        }
        if(totalCaloriesBurned > caloricGoal) {
            return"You're past your caloric goal. You walked a lot didn't you.";
        }
        if(totalCaloriesBurned * 1.1 >= caloricGoal) {
            return"You're close! Walk morea!";

        }
        else return "You're not there, walk more!";
    }

    public void reset() {
        totalStepsTook = 0;
        totalCaloriesBurned = 0;
        caloricGoal = 0;
    }

}
