import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int finalResult = 0;
        int finalResult2 = 0;
        /*
            A, X => Rock (1),                       ____|   X   |   Y   |   Z   |
            B, Y => Paper (2),                      A   |  1+3  |  2+6  |  0+3  |
            C, Z => Scissors (3)                    B   |  1+0  |  2+3  |  3+6  |
                                                    C   |  1+6  |  2+0  |  3+3  |
         */
        HashMap<String, Integer> outcomesFirst = new HashMap<>();
        outcomesFirst.put("A Y", 2 + 6);
        outcomesFirst.put("A X", 1 + 3);
        outcomesFirst.put("A Z", 3);
        outcomesFirst.put("B X", 1);
        outcomesFirst.put("B Y", 2 + 3);
        outcomesFirst.put("B Z", 3 + 6);
        outcomesFirst.put("C X", 1 + 6);
        outcomesFirst.put("C Y", 2);
        outcomesFirst.put("C Z", 3 + 3);

        /*
        *   ____|   X   |   Y   |   Z   |
        *   A   |  0+3  |  3+1  |  6+2  |
        *   B   |  0+1  |  3+2  |  6+3  |
        *   C   |  0+2  |  3+3  |  6+1  |
        * */
        HashMap<String, Integer> outcomesSecond = new HashMap<>();
        outcomesSecond.put("A Y", 3 + 1);
        outcomesSecond.put("A X", 3);
        outcomesSecond.put("A Z", 6 + 2);
        outcomesSecond.put("B X", 1);
        outcomesSecond.put("B Y", 3 + 2);
        outcomesSecond.put("B Z", 6 + 3);
        outcomesSecond.put("C X", 2);
        outcomesSecond.put("C Y", 3 + 3);
        outcomesSecond.put("C Z", 6 + 1);
        Path currentDirectoryPath = Paths.get("").toAbsolutePath();
        File inputFile = new File(currentDirectoryPath + "/out/production/Day2/input.txt");
        if (inputFile.exists()) {
            try {
                Scanner readFile = new Scanner(inputFile);
                while (readFile.hasNextLine()) {
                    finalResult += outcomesFirst.get(readFile.nextLine());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (inputFile.exists()) {
            try {
                Scanner readFile2 = new Scanner(inputFile);
                while (readFile2.hasNextLine()) {
                    finalResult2 += outcomesSecond.get(readFile2.nextLine());
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("1 : " + finalResult);
        System.out.println("2 : " + finalResult2);
    }
}