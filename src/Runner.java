import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        try {
            File file = new File("src/Info.data");
            Scanner s = new Scanner(file);

        }
        catch (FileNotFoundException e) {

        }
    }
}
