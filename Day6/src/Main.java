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
        int finalResult2 = 0;
        Path currentDirectoryPath = Paths.get("").toAbsolutePath();
        List<String> lines;
        try {
            int result;
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
}