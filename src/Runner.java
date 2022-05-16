public class Runner {
    public static void main(String[] args) {
        /**try {
            File file = new File("src/Info.data");
            Scanner s = new Scanner(file);

        }
        catch (FileNotFoundException e) {

        }
         */
        boolean t = false;
        boolean tt = false;
        int count = 0;

        while(!t) {
            count++;
            Intake i = new Intake(100, 2000);
            if(tt) {
                i.addWater(12, "11pm");
                i.addCalories(150, "7am");
                i.addWater(20, "2pm");
                i.addCalories(1000, "10am");
                i.addCalories(1100, "6pm");
            }
            else {
                i.addWater(12, "12pm");
                i.addCalories(200, "9am");
                i.addWater(15, "5pm");
                i.addCalories(500, "6am");
                i.addCalories(1100, "10pm");
            }
            i.history(i.organizeTime());
            System.out.println(i.getTotalCaloriesEaten());
            System.out.println(i.getTotalWaterDrank());
            System.out.println(i.isPassingCaloricGoal());
            System.out.println(i.isPassingWaterGoal());

            String num = "2000";
            double goal = Integer.parseInt(num);
            Exercise en = new Exercise(goal);
            if(tt) {
                en.addSteps(5000);
                en.addSteps(5000);
                en.addSteps(5000);
                en.addSteps(5000);
                en.addSteps(5000);
                System.out.println(en.isWithinGoal());
                System.out.println(en.getTotalCaloriesBurned());
            }
            else {
                System.out.println(en.getCaloricGoal());
                en.addSteps(5000);
                System.out.println(en.getTotalCaloriesBurned());
                System.out.println(en.getTotalStepsTook());
                en.addSteps(10000);
                System.out.println(en.isWithinGoal());
                en.addSteps(20000);
                System.out.println(en.isWithinGoal());
                System.out.println(en.getTotalCaloriesBurned());
                en.addSteps(20000);
                en.addSteps(10000);
                System.out.println(en.isWithinGoal());
            }

                NewDay n = new NewDay(i, en);

            for (Exercise obj : n.getExerciseDays()) {
                System.out.println(obj.getTotalStepsTook());
            }
            for (Intake ob : n.getIntakeDays()) {
                System.out.println(ob.getTotalCaloriesEaten());
            }
            System.out.println(n.getExerciseDays().size() + " " + n.getIntakeDays().size());
            tt = true;
            if(count > 2) t = true;
            System.out.println();
            System.out.println();
        }
    }
}
