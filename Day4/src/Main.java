import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int finalResult = 0;
        int finalResult2 = 0;

        Path currentDirectoryPath = Paths.get("").toAbsolutePath();
        File inputFile = new File(currentDirectoryPath + "/out/production/Day4/input.txt");
        if (inputFile.exists()) {
            try {
                Scanner readFile = new Scanner(inputFile);
                while (readFile.hasNextLine()) {
                    String pair = readFile.nextLine();
                    String firstElf = pair.split(",")[0];
                    String secondElf = pair.split(",")[1];
                    if (compareZonesElves(firstElf, secondElf)) {
                        finalResult++;
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (inputFile.exists()) {
            try {
                Scanner readFile2 = new Scanner(inputFile);
                while (readFile2.hasNextLine()) {
                  readFile2.nextLine();
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("1 : " + finalResult);
        System.out.println("2 : " + finalResult2);
    }

    public static boolean compareZonesElves(String zonesElf1, String zonesElf2) {
        try {
            int startZoneElf1 = Integer.parseInt(zonesElf1.split("-")[0]);
            int endZoneElf1 = Integer.parseInt(zonesElf1.split("-")[1]);
            int startZoneElf2 = Integer.parseInt(zonesElf2.split("-")[0]);
            int endZoneElf2 = Integer.parseInt(zonesElf2.split("-")[1]);
            List<Integer> zonesIntElf1 = zones(startZoneElf1, endZoneElf1);
            List<Integer> zonesIntElf2 = zones(startZoneElf2, endZoneElf2);

            return new HashSet<>(zonesIntElf1).containsAll(zonesIntElf2) || new HashSet<>(zonesIntElf2).containsAll(zonesIntElf1);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<Integer> zones(int startZone, int endZone) {
        List<Integer> zones = new ArrayList<>();
        int currentZone = startZone;
        while (currentZone <= endZone) {
            zones.add(currentZone);
            currentZone++;
        }
        return zones;
    }

}