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

        System.out.println("The fitness tracker's feature will now be displayed.\n-What do you want to do?\n-Set Water Goal\n-Set Calories Eaten Goal\n-Set Calories Eaten Goal\n-Add Water Drank\n-Add Calories Eaten\n-Add Steps Taken" +
                "\n-Go To Tomorrow\n-End\n");

    }
}
