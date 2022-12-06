import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> finalResult = new ArrayList<>();
        List<Integer> finalResult2 = new ArrayList<>();
        Path currentDirectoryPath = Paths.get("").toAbsolutePath();
        List<String> lines;
        try {
            int result;
            int result2;
            lines = Files.readAllLines(
                    Path.of(currentDirectoryPath + "/out/production/Day6/input.txt"),
                    StandardCharsets.UTF_8);
            for (String line: lines) {
                char[] lineChar = line.toCharArray();
                for (int i = 0; i < lineChar.length - 4;i++) {
                    result = getFirstMarkerPositionWith4Characters(lineChar, i);
                    if (result != -1) {
                        finalResult.add(result);
                        break;
                    }
                }
                for (int i = 0; i < lineChar.length - 14;i++) {
                    result2 = getFirstMarkerPositionWith14Characters(lineChar, i);
                    if (result2 != -1) {
                        finalResult2.add(result2);
                        break;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1 : " + finalResult);
        System.out.println("2 : " + finalResult2);
    }
    public static int getFirstMarkerPositionWith4Characters(char[] lineChar, int startPos) {
        char firstPos = lineChar[startPos];
        char secondPos = lineChar[startPos + 1];
        char thirdPos = lineChar[startPos + 2];
        char fourthPos = lineChar[startPos + 3];

        if (firstPos != secondPos && firstPos != thirdPos && firstPos != fourthPos &&
                secondPos != thirdPos && secondPos != fourthPos && thirdPos != fourthPos) {
            return startPos + 4;
        }
        return -1;
    }
    public static int getFirstMarkerPositionWith14Characters(char[] lineChar, int startPos) {
        char firstPos = lineChar[startPos];
        char secondPos = lineChar[startPos + 1];
        char thirdPos = lineChar[startPos + 2];
        char fourthPos = lineChar[startPos + 3];
        char fifthPos = lineChar[startPos + 4];
        char sixthPos = lineChar[startPos + 5];
        char seventhPos = lineChar[startPos + 6];
        char eighthPos = lineChar[startPos + 7];
        char ninthPos = lineChar[startPos + 8];
        char tenthPos = lineChar[startPos + 9];
        char eleventhPos = lineChar[startPos + 10];
        char twelvethPos = lineChar[startPos + 11];
        char thirteenthPos = lineChar[startPos + 12];
        char fourteenthPos = lineChar[startPos + 13];

        if (firstPos != secondPos && firstPos != thirdPos && firstPos != fourthPos && firstPos != fifthPos &&
                firstPos != sixthPos && firstPos != seventhPos && firstPos != eighthPos && firstPos != ninthPos &&
                firstPos != tenthPos && firstPos != eleventhPos && firstPos != twelvethPos && firstPos != thirteenthPos
                && firstPos != fourteenthPos && secondPos != thirdPos && secondPos != fourthPos &&
                secondPos != fifthPos && secondPos != sixthPos && secondPos != seventhPos && secondPos != eighthPos &&
                secondPos != ninthPos && secondPos != tenthPos && secondPos != eleventhPos && secondPos != twelvethPos &&
                secondPos != thirteenthPos && secondPos != fourteenthPos && thirdPos != fourthPos && thirdPos != fifthPos
                && thirdPos != sixthPos && thirdPos != seventhPos && thirdPos != eighthPos && thirdPos != ninthPos &&
                thirdPos != tenthPos && thirdPos != eleventhPos && thirdPos != twelvethPos && thirdPos != thirteenthPos &&
                thirdPos != fourteenthPos && fourthPos != fifthPos && fourthPos != sixthPos && fourthPos != seventhPos &&
                fourthPos != eighthPos && fourthPos != ninthPos && fourthPos != tenthPos && fourthPos != eleventhPos &&
                fourthPos != twelvethPos && fourthPos != thirteenthPos && fourthPos != fourteenthPos &&
                fifthPos != sixthPos && fifthPos != seventhPos && fifthPos != eighthPos && fifthPos != ninthPos &&
                fifthPos != tenthPos && fifthPos != eleventhPos && fifthPos != twelvethPos && fifthPos != thirteenthPos
                && fifthPos != fourteenthPos && sixthPos != seventhPos && sixthPos != eighthPos && sixthPos != ninthPos
                && sixthPos != tenthPos && sixthPos != eleventhPos && sixthPos != twelvethPos && sixthPos != thirteenthPos
                && sixthPos != fourteenthPos && seventhPos != eighthPos && seventhPos != ninthPos && seventhPos != tenthPos
                && seventhPos != eleventhPos && seventhPos != twelvethPos && seventhPos != thirteenthPos &&
                seventhPos != fourteenthPos && eighthPos != ninthPos && eighthPos != tenthPos && eighthPos != eleventhPos
                && eighthPos != twelvethPos && eighthPos != thirteenthPos && eighthPos != fourteenthPos &&
                ninthPos != tenthPos && ninthPos != eleventhPos && ninthPos != twelvethPos && ninthPos != thirteenthPos &&
                ninthPos != fourteenthPos && tenthPos != eleventhPos && tenthPos != twelvethPos && tenthPos != thirteenthPos
                && tenthPos != fourteenthPos && eleventhPos != twelvethPos && eleventhPos != thirteenthPos &&
                eleventhPos != fourteenthPos && twelvethPos != thirteenthPos && twelvethPos != fourteenthPos &&
                thirteenthPos != fourteenthPos) {
            return startPos + 14;
        }
        return -1;
    }
}