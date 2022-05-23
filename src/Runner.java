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
        String wamount = s.nextLine();
        int wamount1 = Integer.parseInt(wamount);
        System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
        String camount = s.nextLine();
        int camount1 = Integer.parseInt(camount);
        System.out.println("Finally, how many calories do you plan to burn today (input just the number)?");
        String samount = s.nextLine();
        int samount1 = Integer.parseInt(samount);
        Intake i = new Intake(wamount1, camount1);
        Exercise e = new Exercise(samount1);
        NewDay n = new NewDay();
        System.out.println("The fitness tracker's feature will now be displayed (type just the number, not the phrase).");
        boolean stop = true;

            while (stop) {
                System.out.println("-What do you want to do?\n1. Set Water Goal\n2. Set Calories Eaten Goal\n3. Set Calories Burnt Goal\n4. Get Info\n5. Add Water Drank\n6. Add Calories Eaten\n7. Add Steps Taken" +
                        "\n8. Find Averages\n9. Passing Goal\n10. Today's History\n11. Go To Tomorrow\n12. End");           //choices
                String response = s.nextLine();
                response = response.toLowerCase();
                if(response.equals("12")) {
                    System.out.println("System shutting down...\nFiles Saving...Saved!");
                    stop = false;
            }
                else if(response.equals("11")) {
                    n.addExercise(e);
                    n.addIntake(i);
                    n.resetArrays();
                    i.reset();
                    e.reset();
                    System.out.println("What's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
                    wamount = s.nextLine();
                    System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
                    camount = s.nextLine();
                    System.out.println("Finally, how many calories do you plan to burn today (input just the number)?");
                    samount = s.nextLine();
                    wamount1 = Integer.parseInt(wamount);
                    camount1 = Integer.parseInt(camount);
                    samount1 = Integer.parseInt(samount);
                    i.setGoalCalories(camount1);
                    i.setGoalWater(wamount1);
                    e.setCaloricGoal(samount1);
                }
                else if(response.equals("1")) {
                    System.out.println("What's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
                    wamount = s.nextLine();
                    wamount1 = Integer.parseInt(wamount);
                    i.setGoalWater(wamount1);
                    System.out.println("Success.");
                }
                else if(response.equals("2")) {
                    System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
                    camount = s.nextLine();
                    camount1 = Integer.parseInt(camount);
                    i.setGoalCalories(camount1);
                    System.out.println("Success.");
                }
                else if(response.equals("3")) {
                    System.out.println("How many calories do you plan to burn today (input just the number)?");
                    samount = s.nextLine();
                    samount1 = Integer.parseInt(samount);
                    e.setCaloricGoal(samount1);
                    System.out.println("Success.");
                }
                else if(response.equals("5")) {
                    System.out.println("How many fl oz of water did you drink? ");
                    String water = s.nextLine();
                    int water1 = Integer.parseInt(water);
                    System.out.println("At what time? (input, for example, 12am, 5pm) ");
                    String time = s.nextLine();
                    i.addWater(water1, time);
                }
                else if(response.equals("6")) {
                    System.out.println("How many calories did you eat? ");
                    String calories = s.nextLine();
                    int calories1 = Integer.parseInt(calories);
                    System.out.println("At what time? (input, for example, 12am, 5pm) ");
                    String time = s.nextLine();
                    i.addCalories(calories1, time);
                }
                else if(response.equals("7")) {
                    System.out.println("How many steps did you take? ");
                    String steps = s.nextLine();
                    int steps1 = Integer.parseInt(steps);
                    e.addSteps(steps1);
                }
                else if(response.equals("4")) {  //info
                    System.out.println();
                    System.out.println("What would you like to know?\n1. Get Total Water Drank\n2. Get Total Calories Eaten\n3. Get Water Intake Goal\n4. Get Caloric Intake Goal\n5. Get Total Steps Taken\n6. Get Total Calories Burned\n7. Get Caloric Burn Goal");
                    String response1 = s.nextLine();
                    response1 = response1.toLowerCase();
                    if (response1.equals("1")) {
                        System.out.println(i.getTotalWaterDrank() + " fl oz drank");
                    }
                    else if(response1.equals("2")) {
                        System.out.println(i.getTotalCaloriesEaten() + " calories");
                    }
                    else if(response1.equals("3")) {
                        System.out.println(i.getGoalWater() + " fl oz");
                    }
                    else if(response1.equals("4")) {
                        System.out.println(i.getGoalCalories() + " calories");
                    }
                    else if(response1.equals("5")) {
                        System.out.println(e.getTotalStepsTook() + " steps");
                    }
                    else if(response1.equals("6")) {
                        System.out.println(e.getTotalCaloriesBurned() + " calories");
                    }
                    else if(response1.equals("7")) {
                        System.out.println(e.getCaloricGoal() + " calories");
                    }
                    else System.out.println("Invalid Input, going back to page 1.");
                    }
                else if(response.equals("8")) {
                    if (n.canCalculateAvg()) {//avgs
                        System.out.println();
                        System.out.println("Which averages would you like to know?\n1. Average Water Drank\n2. Average Calories Eaten\n3. Average Steps Taken\n4. Average Calories Burned");
                        String response2 = s.nextLine();
                        if (response2.equals("1")) {
                            System.out.println(n.averageWaterDrank() + "for " + n.getIntakeDays().size() + " days");
                        } else if (response2.equals("2")) {
                            System.out.println(n.averageCaloriesEaten() + "for " + n.getIntakeDays().size() + " days");
                        } else if (response2.equals("3")) {
                            System.out.println(n.averageStepsTaken() + "for " + n.getExerciseDays().size() + " days");
                        } else if (response2.equals("4")) {
                            System.out.println(n.averageCaloriesBurned() + "for " + n.getExerciseDays().size() + " days");
                        } else System.out.println("Invalid Input, going back to page 1.");
                    }
                    else System.out.println("Invalid, no inputs yet.");
                    }
                else if(response.equals("10")) {
                    i.history();
                }
                else if(response.equals("9")) {
                    System.out.println("Which do you want to know?\n1. Is Passing Water Goal\n2. Is Passing Caloric Intake Goal\n3. Is Passing Caloric Burn Goal");
                    String response3 = s.nextLine();
                    if(response3.equals("1")) System.out.println(i.isPassingWaterGoal());
                    else if(response3.equals("2")) System.out.println(i.isPassingCaloricGoal());
                    else if(response3.equals("3")) System.out.println(e.isWithinGoal());
                }

                else System.out.println("Invalid. Re-input your decision.");
                System.out.println();
                }

        }

    }

