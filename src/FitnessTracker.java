import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class FitnessTracker {
    public static void main(String[] args) {
        try {                                            //TRY
           File file = new File("src/intake.data");
           File file2 = new File("src/exercise.data");
           File file3 = new File("src/newDay.data");
           Scanner ss = new Scanner(file);
           Scanner ss2 = new Scanner(file2);
           Scanner ss3 = new Scanner (file3);
           Scanner s = new Scanner(System.in);
           int line = 1;
           int totalWater = 0;
           int totalCaloriesE = 0;
           int waterG = 0;
           int caloricEatenG = 0;
           ArrayList<String> timeArr = new ArrayList<String>();
           int totalSteps = 0;
           int totalCaloriesB = 0;
           int caloricBurnedG = 0;
           NewDay n = new NewDay();
           if(ss.hasNextLine()) {
               while (ss.hasNextLine()) {
                   String data = ss.nextLine();
                   if (line == 1) {
                       String intakeConst[] = data.split("\\|");
                       for (int i = 0; i < intakeConst.length; i++) {
                           int num = Integer.parseInt(intakeConst[i]);
                           if (i == 0) waterG = num;
                           if (i == 1) caloricEatenG = num;
                           if (i == 2) totalWater = num;
                           else totalCaloriesE = num;
                       }
                   }
                   if (line == 2) {
                       String[] time = data.split("\\|");
                       for (int i = 0; i < time.length; i++) {
                           timeArr.add(time[i]);
                       }
                   }
                   line++;
               }
               line = 1;
               while (ss2.hasNextLine()) {
                   String data = ss2.nextLine();
                   if (line == 1) {
                       String exerciseConst[] = data.split("\\|");
                       for (int i = 0; i < exerciseConst.length; i++) {
                           int num = Integer.parseInt(exerciseConst[i]);
                           if (i == 0) caloricBurnedG = num;
                           if (i == 1) totalCaloriesB = num;
                           else totalSteps = num;
                       }
                   }
               }
               line = 1;
               while (ss3.hasNextLine()) {
                   String data = ss3.nextLine();
                   if (line == 1) {
                       String[] water = data.split("\\|");
                       for (int w = 0; w < water.length; w++) {
                           int num = Integer.parseInt(water[w]);
                           n.addWater(num);
                       }
                   }
                   if (line == 2) {
                       String[] caloriesE = data.split("\\|");
                       for (int ce = 0; ce < caloriesE.length; ce++) {
                           int num = Integer.parseInt(caloriesE[ce]);
                           n.addCaloriesEaten(num);
                       }
                   }
                   if (line == 3) {
                       String[] steps = data.split("\\|");
                       for (int step = 0; step < steps.length; step++) {
                           int num = Integer.parseInt(steps[step]);
                           n.addSteps(num);
                       }
                   }
                   if (line == 4) {
                       String[] caloriesB = data.split("\\|");
                       for (int cb = 0; cb < caloriesB.length; cb++) {
                           int num = Integer.parseInt(caloriesB[cb]);
                           n.addCaloriesBurned(num);
                       }
                   }
                   line++;
               }
               ss.close();
               Intake i = new Intake(waterG, caloricEatenG);
               Exercise e = new Exercise(caloricBurnedG);
               System.out.println("What's your name: ");
               String name = s.nextLine();
               System.out.println("Hello " + name + ". Welcome back to your personal fitness tracker.\nThere are many features for you to utilize. Type in word for word on what you'd like to do with the listed commands below.");
               System.out.println("The fitness tracker's feature will be displayed (type just the number, not the phrase).");
               for (int ii = 0; ii < timeArr.size(); ii++) {
                   i.addHistory(timeArr.get(ii));
               }
               i.setWater(totalWater);
               System.out.println(totalWater);
               i.setCaloriesE(totalCaloriesE);
               e.setSteps(totalSteps);
               e.setCaloriesBurned(totalCaloriesB);
               boolean stop = true;

               while (stop) {
                   System.out.println("-What do you want to do?\n1. Set Water Goal\n2. Set Calories Eaten Goal\n3. Set Calories Burnt Goal\n4. Get Info\n5. Add Water Drank\n6. Add Calories Eaten\n7. Add Steps Taken" + "\n8. Find Averages\n9. Passing Goal\n10. Today's History\n11. Go To Tomorrow\n12. End");
                   String response = s.nextLine();
                   response = response.toLowerCase();
                   if (response.equals("12")) {
                       i.save();
                       e.save();
                       n.save();
                       System.out.println("System shutting down...\nFiles Saving...Saved!");
                       stop = false;
                   } else if (response.equals("11")) {
                       n.resetArrays();
                       n.addCaloriesEaten(i.getTotalCaloriesEaten());
                       n.addWater(i.getTotalWaterDrank());
                       n.addSteps(e.getTotalStepsTook());
                       n.addCaloriesBurned(e.getTotalCaloriesBurned());
                       i.reset();
                       e.reset();
                       System.out.println("What's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
                       String wamount = s.nextLine();
                       System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
                       String camount = s.nextLine();
                       System.out.println("Finally, how many calories do you plan to burn today (input just the number)?");
                       String samount = s.nextLine();
                       int wamount1 = Integer.parseInt(wamount);
                       int camount1 = Integer.parseInt(camount);
                       int samount1 = Integer.parseInt(samount);
                       i.setGoalCalories(camount1);
                       i.setGoalWater(wamount1);
                       e.setCaloricGoal(samount1);
                   } else if (response.equals("1")) {
                       System.out.println("What's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
                       String wamount = s.nextLine();
                       int wamount1 = Integer.parseInt(wamount);
                       i.setGoalWater(wamount1);
                       System.out.println("Success.");
                   } else if (response.equals("2")) {
                       System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
                       String camount = s.nextLine();
                       int camount1 = Integer.parseInt(camount);
                       i.setGoalCalories(camount1);
                       System.out.println("Success.");
                   } else if (response.equals("3")) {
                       System.out.println("How many calories do you plan to burn today (input just the number)?");
                       String samount = s.nextLine();
                       int samount1 = Integer.parseInt(samount);
                       e.setCaloricGoal(samount1);
                       System.out.println("Success.");
                   } else if (response.equals("5")) {
                       System.out.println("How many fl oz of water did you drink? ");
                       String water = s.nextLine();
                       int water1 = Integer.parseInt(water);
                       System.out.println("At what time? (input, for example, 12am, 5pm) ");
                       String time = s.nextLine();
                       i.addWater(water1, time);
                   } else if (response.equals("6")) {
                       System.out.println("How many calories did you eat? ");
                       String calories = s.nextLine();
                       int calories1 = Integer.parseInt(calories);
                       System.out.println("At what time? (input, for example, 12am, 5pm) ");
                       String time = s.nextLine();
                       i.addCalories(calories1, time);
                   } else if (response.equals("7")) {
                       System.out.println("How many steps did you take? ");
                       String steps = s.nextLine();
                       int steps1 = Integer.parseInt(steps);
                       e.addSteps(steps1);
                   } else if (response.equals("4")) {
                       System.out.println();
                       System.out.println("What would you like to know?\n1. Get Total Water Drank\n2. Get Total Calories Eaten\n3. Get Water Intake Goal\n4. Get Caloric Intake Goal\n5. Get Total Steps Taken\n6. Get Total Calories Burned\n7. Get Caloric Burn Goal");
                       String response1 = s.nextLine();
                       response1 = response1.toLowerCase();
                       if (response1.equals("1")) {
                           System.out.println(i.getTotalWaterDrank() + " fl oz drank");
                       } else if (response1.equals("2")) {
                           System.out.println(i.getTotalCaloriesEaten() + " calories");
                       } else if (response1.equals("3")) {
                           System.out.println(i.getGoalWater() + " fl oz");
                       } else if (response1.equals("4")) {
                           System.out.println(i.getGoalCalories() + " calories");
                       } else if (response1.equals("5")) {
                           System.out.println(e.getTotalStepsTook() + " steps");
                       } else if (response1.equals("6")) {
                           System.out.println(e.getTotalCaloriesBurned() + " calories");
                       } else if (response1.equals("7")) {
                           System.out.println(e.getCaloricGoal() + " calories");
                       } else System.out.println("Invalid Input, going back to page 1.");
                   } else if (response.equals("8")) {
                       if (n.canCalculateAvg()) {
                           System.out.println();
                           System.out.println("Which averages would you like to know?\n1. Average Water Drank\n2. Average Calories Eaten\n3. Average Steps Taken\n4. Average Calories Burned");
                           String response2 = s.nextLine();
                           if (response2.equals("1")) {
                               System.out.println(n.averageWaterDrank() + " for " + n.getWaterArr().size() + " days");
                           } else if (response2.equals("2")) {
                               System.out.println(n.averageCaloriesEaten() + " for " + n.getWaterArr().size() + " days");
                           } else if (response2.equals("3")) {
                               System.out.println(n.averageStepsTaken() + " for " + n.getCaloriesEArr().size() + " days");
                           } else if (response2.equals("4")) {
                               System.out.println(n.averageCaloriesBurned() + " for " + n.getCaloriesEArr().size() + " days");
                           } else System.out.println("Invalid Input, going back to page 1.");
                       } else System.out.println("Invalid, no inputs yet.");
                   } else if (response.equals("10")) {
                       i.history();
                   } else if (response.equals("9")) {
                       System.out.println("Which do you want to know?\n1. Is Passing Water Goal\n2. Is Passing Caloric Intake Goal\n3. Is Passing Caloric Burn Goal");
                       String response3 = s.nextLine();
                       if (response3.equals("1")) System.out.println(i.isPassingWaterGoal());
                       else if (response3.equals("2")) System.out.println(i.isPassingCaloricGoal());
                       else if (response3.equals("3")) System.out.println(e.isWithinGoal());
                   } else System.out.println("Invalid. Re-input your decision.");
                   System.out.println();
               }
           }
           else {
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
               System.out.println("The fitness tracker's feature will now be displayed (type just the number, not the phrase).");
               boolean stop = true;

               while (stop) {
                   System.out.println("-What do you want to do?\n1. Set Water Goal\n2. Set Calories Eaten Goal\n3. Set Calories Burnt Goal\n4. Get Info\n5. Add Water Drank\n6. Add Calories Eaten\n7. Add Steps Taken" + "\n8. Find Averages\n9. Passing Goal\n10. Today's History\n11. Go To Tomorrow\n12. End");
                   String response = s.nextLine();
                   if (response.equals("12")) {
                       i.save();
                       e.save();
                       n.save();
                       System.out.println("System shutting down...\nFiles Saving...Saved!");
                       stop = false;
                   } else if (response.equals("11")) {
                       n.resetArrays();
                       n.addCaloriesEaten(i.getTotalCaloriesEaten()); //fix into just adding the calories, steps, water, etc into an arraylist (make 2 more)
                       n.addWater(i.getTotalWaterDrank());
                       n.addSteps(e.getTotalStepsTook());
                       n.addCaloriesBurned(e.getTotalCaloriesBurned());
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
                   } else if (response.equals("1")) {
                       System.out.println("What's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
                       wamount = s.nextLine();
                       wamount1 = Integer.parseInt(wamount);
                       i.setGoalWater(wamount1);
                       System.out.println("Success.");
                   } else if (response.equals("2")) {
                       System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
                       camount = s.nextLine();
                       camount1 = Integer.parseInt(camount);
                       i.setGoalCalories(camount1);
                       System.out.println("Success.");
                   } else if (response.equals("3")) {
                       System.out.println("How many calories do you plan to burn today (input just the number)?");
                       samount = s.nextLine();
                       samount1 = Integer.parseInt(samount);
                       e.setCaloricGoal(samount1);
                       System.out.println("Success.");
                   } else if (response.equals("5")) {
                       System.out.println("How many fl oz of water did you drink? ");
                       String water = s.nextLine();
                       int water1 = Integer.parseInt(water);
                       System.out.println("At what time? (input, for example, 12am, 5pm) ");
                       String time = s.nextLine();
                       i.addWater(water1, time);
                   } else if (response.equals("6")) {
                       System.out.println("How many calories did you eat? ");
                       String calories = s.nextLine();
                       int calories1 = Integer.parseInt(calories);
                       System.out.println("At what time? (input, for example, 12am, 5pm) ");
                       String time = s.nextLine();
                       i.addCalories(calories1, time);
                   } else if (response.equals("7")) {
                       System.out.println("How many steps did you take? ");
                       String steps = s.nextLine();
                       int steps1 = Integer.parseInt(steps);
                       e.addSteps(steps1);
                   } else if (response.equals("4")) {
                       System.out.println();
                       System.out.println("What would you like to know?\n1. Get Total Water Drank\n2. Get Total Calories Eaten\n3. Get Water Intake Goal\n4. Get Caloric Intake Goal\n5. Get Total Steps Taken\n6. Get Total Calories Burned\n7. Get Caloric Burn Goal");
                       String response1 = s.nextLine();
                       response1 = response1.toLowerCase();
                       if (response1.equals("1")) {
                           System.out.println(i.getTotalWaterDrank() + " fl oz drank");
                       } else if (response1.equals("2")) {
                           System.out.println(i.getTotalCaloriesEaten() + " calories");
                       } else if (response1.equals("3")) {
                           System.out.println(i.getGoalWater() + " fl oz");
                       } else if (response1.equals("4")) {
                           System.out.println(i.getGoalCalories() + " calories");
                       } else if (response1.equals("5")) {
                           System.out.println(e.getTotalStepsTook() + " steps");
                       } else if (response1.equals("6")) {
                           System.out.println(e.getTotalCaloriesBurned() + " calories");
                       } else if (response1.equals("7")) {
                           System.out.println(e.getCaloricGoal() + " calories");
                       } else System.out.println("Invalid Input, going back to page 1.");
                   } else if (response.equals("8")) {
                       if (n.canCalculateAvg()) {//avgs
                           System.out.println();
                           System.out.println("Which averages would you like to know?\n1. Average Water Drank\n2. Average Calories Eaten\n3. Average Steps Taken\n4. Average Calories Burned");
                           String response2 = s.nextLine();
                           if (response2.equals("1")) {
                               System.out.println(n.averageWaterDrank() + " for " + n.getWaterArr().size() + " days");
                           } else if (response2.equals("2")) {
                               System.out.println(n.averageCaloriesEaten() + " for " + n.getWaterArr().size() + " days");
                           } else if (response2.equals("3")) {
                               System.out.println(n.averageStepsTaken() + " for " + n.getCaloriesEArr().size() + " days");
                           } else if (response2.equals("4")) {
                               System.out.println(n.averageCaloriesBurned() + " for " + n.getCaloriesEArr().size() + " days");
                           } else System.out.println("Invalid Input, going back to page 1.");
                       } else System.out.println("Invalid, no inputs yet.");
                   } else if (response.equals("10")) {
                       i.history();
                   } else if (response.equals("9")) {
                       System.out.println("Which do you want to know?\n1. Is Passing Water Goal\n2. Is Passing Caloric Intake Goal\n3. Is Passing Caloric Burn Goal");
                       String response3 = s.nextLine();
                       if (response3.equals("1")) System.out.println(i.isPassingWaterGoal());
                       else if (response3.equals("2")) System.out.println(i.isPassingCaloricGoal());
                       else if (response3.equals("3")) System.out.println(e.isWithinGoal());
                   } else System.out.println("Invalid. Re-input your decision.");
                   System.out.println();
               }
           }
        }

         catch (FileNotFoundException ee) {             //CATCH
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
                 System.out.println("-What do you want to do?\n1. Set Water Goal\n2. Set Calories Eaten Goal\n3. Set Calories Burnt Goal\n4. Get Info\n5. Add Water Drank\n6. Add Calories Eaten\n7. Add Steps Taken" + "\n8. Find Averages\n9. Passing Goal\n10. Today's History\n11. Go To Tomorrow\n12. End");           //choices
                 String response = s.nextLine();
                 response = response.toLowerCase();
                 if (response.equals("12")) {
                     i.save();
                     e.save();
                     n.save();
                     System.out.println("System shutting down...\nFiles Saving...Saved!");
                     stop = false;
                 } else if (response.equals("11")) {
                     n.resetArrays();
                     n.addCaloriesEaten(i.getTotalCaloriesEaten());
                     n.addWater(i.getTotalWaterDrank());
                     n.addSteps(e.getTotalStepsTook());
                     n.addCaloriesBurned(e.getTotalCaloriesBurned());
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
                 } else if (response.equals("1")) {
                     System.out.println("What's your water intake goal for today (How many fl oz do you plan to drink, input just the number)?");
                     wamount = s.nextLine();
                     wamount1 = Integer.parseInt(wamount);
                     i.setGoalWater(wamount1);
                     System.out.println("Success.");
                 } else if (response.equals("2")) {
                     System.out.println("What's your caloric intake goal for today (How many calories do you plan to consume, input just the number)?");
                     camount = s.nextLine();
                     camount1 = Integer.parseInt(camount);
                     i.setGoalCalories(camount1);
                     System.out.println("Success.");
                 } else if (response.equals("3")) {
                     System.out.println("How many calories do you plan to burn today (input just the number)?");
                     samount = s.nextLine();
                     samount1 = Integer.parseInt(samount);
                     e.setCaloricGoal(samount1);
                     System.out.println("Success.");
                 } else if (response.equals("5")) {
                     System.out.println("How many fl oz of water did you drink? ");
                     String water = s.nextLine();
                     int water1 = Integer.parseInt(water);
                     System.out.println("At what time? (input, for example, 12am, 5pm) ");
                     String time = s.nextLine();
                     i.addWater(water1, time);
                 } else if (response.equals("6")) {
                     System.out.println("How many calories did you eat? ");
                     String calories = s.nextLine();
                     int calories1 = Integer.parseInt(calories);
                     System.out.println("At what time? (input, for example, 12am, 5pm) ");
                     String time = s.nextLine();
                     i.addCalories(calories1, time);
                 } else if (response.equals("7")) {
                     System.out.println("How many steps did you take? ");
                     String steps = s.nextLine();
                     int steps1 = Integer.parseInt(steps);
                     e.addSteps(steps1);
                 } else if (response.equals("4")) {
                     System.out.println();
                     System.out.println("What would you like to know?\n1. Get Total Water Drank\n2. Get Total Calories Eaten\n3. Get Water Intake Goal\n4. Get Caloric Intake Goal\n5. Get Total Steps Taken\n6. Get Total Calories Burned\n7. Get Caloric Burn Goal");
                     String response1 = s.nextLine();
                     response1 = response1.toLowerCase();
                     if (response1.equals("1")) {
                         System.out.println(i.getTotalWaterDrank() + " fl oz drank");
                     } else if (response1.equals("2")) {
                         System.out.println(i.getTotalCaloriesEaten() + " calories");
                     } else if (response1.equals("3")) {
                         System.out.println(i.getGoalWater() + " fl oz");
                     } else if (response1.equals("4")) {
                         System.out.println(i.getGoalCalories() + " calories");
                     } else if (response1.equals("5")) {
                         System.out.println(e.getTotalStepsTook() + " steps");
                     } else if (response1.equals("6")) {
                         System.out.println(e.getTotalCaloriesBurned() + " calories");
                     } else if (response1.equals("7")) {
                         System.out.println(e.getCaloricGoal() + " calories");
                     } else System.out.println("Invalid Input, going back to page 1.");
                 } else if (response.equals("8")) {
                     if (n.canCalculateAvg()) {//avgs
                         System.out.println();
                         System.out.println("Which averages would you like to know?\n1. Average Water Drank\n2. Average Calories Eaten\n3. Average Steps Taken\n4. Average Calories Burned");
                         String response2 = s.nextLine();
                         if (response2.equals("1")) {
                             System.out.println(n.averageWaterDrank() + " for " + n.getWaterArr().size() + " days");
                         } else if (response2.equals("2")) {
                             System.out.println(n.averageCaloriesEaten() + " for " + n.getWaterArr().size() + " days");
                         } else if (response2.equals("3")) {
                             System.out.println(n.averageStepsTaken() + " for " + n.getCaloriesEArr().size() + " days");
                         } else if (response2.equals("4")) {
                             System.out.println(n.averageCaloriesBurned() + " for " + n.getCaloriesEArr().size() + " days");
                         } else System.out.println("Invalid Input, going back to page 1.");
                     } else System.out.println("Invalid, no inputs yet.");
                 } else if (response.equals("10")) {
                     i.history();
                 } else if (response.equals("9")) {
                     System.out.println("Which do you want to know?\n1. Is Passing Water Goal\n2. Is Passing Caloric Intake Goal\n3. Is Passing Caloric Burn Goal");
                     String response3 = s.nextLine();
                     if (response3.equals("1")) System.out.println(i.isPassingWaterGoal());
                     else if (response3.equals("2")) System.out.println(i.isPassingCaloricGoal());
                     else if (response3.equals("3")) System.out.println(e.isWithinGoal());
                 } else System.out.println("Invalid. Re-input your decision.");
                 System.out.println();
             }
         }

    }

}