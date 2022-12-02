import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int finalResult = 0;
        /*
            A, X => Rock (1),                       ____|   X   |   Y   |   Z   |
            B, Y => Paper (2),                      A   |  1+3  |  2+6  |  0+3  |
            C, Z => Scissors (3)                    B   |  1+0  |  2+3  |  3+6  |
                                                    C   |  1+6  |  2+0  |  3+3  |
         */
        HashMap<String, Integer> outcomes = new HashMap<>();
        outcomes.put("A Y", 2 + 6);
        outcomes.put("A X", 1 + 3);
        outcomes.put("A Z", 3);
        outcomes.put("B X", 1);
        outcomes.put("B Y", 2 + 3);
        outcomes.put("B Z", 3 + 6);
        outcomes.put("C X", 1 + 6);
        outcomes.put("C Y", 2);
        outcomes.put("C Z", 3 + 3);

        Path currentDirectoryPath = Paths.get("").toAbsolutePath();
        File inputFile = new File(currentDirectoryPath + "/out/production/Day2/input.txt");
        if (inputFile.exists()) {
            try {
                Scanner readFile = new Scanner(inputFile);
                while (readFile.hasNextLine()) {
                    finalResult += outcomes.get(readFile.nextLine());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("1 : " + finalResult);
    }
}