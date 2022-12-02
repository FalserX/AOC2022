import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path currentDirectoryPath = Paths.get("").toAbsolutePath();
        List<Integer> elfsCaloriesPortable = new ArrayList<>();
        int currentElfCalories = 0;
        int maxElfCalories = 0;
            File inputFile = new File(currentDirectoryPath + "/out/production/Day1/input.txt");
            if (inputFile.exists()) {
                try {
                    Scanner readFile = new Scanner(inputFile);
                    while (readFile.hasNextLine()) {
                        String calorie = readFile.nextLine();
                        if (calorie.trim().isEmpty()) {
                            elfsCaloriesPortable.add(currentElfCalories);
                            currentElfCalories = 0;
                        } else {
                            try {
                                int calorieInt = Integer.parseInt(calorie.trim());
                                currentElfCalories += calorieInt;
                            } catch (NumberFormatException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    for (Integer currentCalorieElf: elfsCaloriesPortable) {
                        if (maxElfCalories < currentCalorieElf) {
                            maxElfCalories = currentCalorieElf;
                        }
                    }
                    System.out.println(maxElfCalories);
                }
                catch (FileNotFoundException fileNotFoundException)
                {
                    throw new RuntimeException(fileNotFoundException);
                }
        }
    }
}