import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        /**try {
            File file = new File("src/Info.data");
            Scanner s = new Scanner(file);

        }
        catch (FileNotFoundException e) {

        }
         */
        Scanner s = new Scanner(System.in);
        System.out.println("What's your name: ");
        String name = s.nextLine();
        System.out.println("Hello " + name + ". Welcome to your personal fitness tracker.\nThere are many features for you to utilize. Type in word for word on what you'd like to do with the listed commands below.");
        System.out.println("Before we start, what's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
        int wamount = s.nextInt();
        System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
        int camount = s.nextInt();
        System.out.println("Finally, how many calories do you plan to burn today (input just the number)?");
        int samount = s.nextInt();
        Intake i = new Intake(wamount, camount);
        Exercise e = new Exercise(samount);
        NewDay n = new NewDay();

        System.out.println("The fitness tracker's feature will now be displayed.\n-What do you want to do?\n-Set Water Goal\n-Set Calories Eaten Goal\n-Set Calories Burnt Goal\n-Add Water Drank\n-Add Calories Eaten\n-Add Steps Taken" +
                "\n-Go To Tomorrow\n-End\n");
        String response = s.nextLine();
            while (response.equals("Set Water Goal") || response.equals("Set Calories Eaten Goal") || response.equals("Set Calories Burnt Goal") || response.equals("Add Water Drank")
                    || response.equals("Add Calories Eaten") || response.equals("Add Steps Taken") || response.equals("Go To Tomorrow") || response.equals("End")) {
                if(response.equals("End")) {
                    System.out.println("System shutting down...\nFiles Saving...Saved!");
                    break;
            }
                else if(response.equals("Go To Tomorrow")) {
                    n.addExercise(e);
                    n.addIntake(i);
                    n.resetArrays();
                    i.reset();
                    e.reset();
                    System.out.println("What's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
                    wamount = s.nextInt();
                    System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
                    camount = s.nextInt();
                    System.out.println("Finally, how many calories do you plan to burn today (input just the number)?");
                    samount = s.nextInt();
                    i.setGoalCalories(camount);
                    i.setGoalWater(wamount);
                    e.setCaloricGoal(samount);
                }
                else if(response.equals("Set Water Goal")) {
                    System.out.println("What's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
                    wamount = s.nextInt();
                    i.setGoalWater(wamount);
                }
                else if(response.equals("Set Calories Eaten Goal")) {
                    System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
                    camount = s.nextInt();
                    i.setGoalCalories(camount);
                }
                else if(response.equals("Set Calories Burnt Goal")) {
                    System.out.println("How many calories do you plan to burn today (input just the number)?");
                    samount = s.nextInt();
                    e.setCaloricGoal(samount);
                }
                else if(response.equals("Add Water Drank")) {
                    System.out.println("How many fl oz of water did you drink? ");
                    int water = s.nextInt();
                    System.out.println("At what time? (input, for example, 12am, 5pm) ");
                    String time = s.nextLine();
                    i.addWater(water, time);
                }
        }

    }
}
