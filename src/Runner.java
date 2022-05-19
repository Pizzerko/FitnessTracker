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

        boolean stop = true;
            while (stop) {
                System.out.println("The fitness tracker's feature will now be displayed.\n-What do you want to do?\n-Set Water Goal\n-Set Calories Eaten Goal\n-Set Calories Burnt Goal\n-Get Info\n-Add Water Drank\n-Add Calories Eaten\n-Add Steps Taken" +
                        "\n-Go To Tomorrow\n-End");
                String response = s.nextLine();
                response = response.toLowerCase();
                if(response.equals("end")) {
                    System.out.println("System shutting down...\nFiles Saving...Saved!");
                    stop = false;
            }
                else if(response.equals("go to tomorrow")) {
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
                else if(response.equals("set water goal")) {
                    System.out.println("What's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
                    wamount = s.nextInt();
                    i.setGoalWater(wamount);
                }
                else if(response.equals("set calories eaten goal")) {
                    System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
                    camount = s.nextInt();
                    i.setGoalCalories(camount);
                }
                else if(response.equals("set calories burnt goal")) {
                    System.out.println("How many calories do you plan to burn today (input just the number)?");
                    samount = s.nextInt();
                    e.setCaloricGoal(samount);
                }
                else if(response.equals("add water drank")) {
                    System.out.println("How many fl oz of water did you drink? ");
                    int water = s.nextInt();
                    System.out.println("At what time? (input, for example, 12am, 5pm) ");
                    String time = s.nextLine();
                    i.addWater(water, time);
                }
                else if(response.equals("add calories eaten")) {
                    System.out.println("How many calories did you eat? ");
                    int calories = s.nextInt();
                    System.out.println("At what time? (input, for example, 12am, 5pm) ");
                    String time = s.nextLine();
                    i.addCalories(calories, time);
                }
                else if(response.equals("add steps taken")) {
                    System.out.println("How many steps did you take? ");
                    int steps = s.nextInt();
                    e.addSteps(steps);
                }
                else if(response.equals("get info")) {
                    System.out.println();
                    System.out.println("What would you like to know?\n-Get Total Water Drank\n-Get Total Calories Eaten\n-Get Water Intake Goal\n-Get Caloric Intake Goal\n-Get Total Steps Taken\n-Get Total Calories Burned\n-Get Caloric Burn Goal");
                    String response1 = s.nextLine();
                    response1 = response1.toLowerCase();
                    if (response1.equals("get total water drank")) {
                        System.out.println(i.getTotalWaterDrank() + " fl oz drank");
                    }
                    else if(response1.equals("get total calories eaten")) {
                        System.out.println(i.getTotalCaloriesEaten() + " calories");
                    }
                    else if(response1.equals("get water intake goal")) {
                        System.out.println(i.getGoalWater() + " fl oz");
                    }
                    else if(response1.equals("get caloric intake goal")) {
                        System.out.println(i.getGoalCalories() + " calories");
                    }
                    else if(response1.equals("get total steps taken")) {
                        System.out.println(e.getTotalStepsTook() + " steps");
                    }
                    else if(response1.equals("get total calories burned")) {
                        System.out.println(e.getTotalCaloriesBurned() + " calories");
                    }
                    else if(response1.equals("get caloric burn goal")) {
                        System.out.println(e.getCaloricGoal() + " calories");
                    }
                    else System.out.println("Invalid Input, going back to page 1.");
                    }
                else System.out.println("Invalid. Re-input your decision.");
                }

        }

    }

