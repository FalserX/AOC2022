import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        StringBuilder finalResult = new StringBuilder();
        Vector<Stack<String>> cratesScheme = new Vector<>();
        int finalResult2 = 0;
        int linePosBetweenSchemeAndInstructs = 0;
        List<Integer> indexCol = new ArrayList<>();
        Path currentDirectoryPath = Paths.get("").toAbsolutePath();
        List<String> lines;
        try {
            lines = Files.readAllLines(
                    Path.of(currentDirectoryPath + "/out/production/Day5/input.txt"),
                    StandardCharsets.UTF_8);
            for (int i = 0; i < lines.size();i++) {
                if (lines.get(i).trim().equals("")) {
                    linePosBetweenSchemeAndInstructs = i;
                    break;
                }
            }
            String[] indexes = lines.get(linePosBetweenSchemeAndInstructs-1).split(" ");
            for (String index : indexes) {
                if (!index.trim().equals("")) {
                    indexCol.add(Integer.parseInt(index));
                }
            }

            for (int i = linePosBetweenSchemeAndInstructs-2; i >= 0;i--) {
                String currentLine = lines.get(i).replace("    "," ");
                String[] crates = currentLine.split(" ");
                if (linePosBetweenSchemeAndInstructs-2 == i) {
                    for (String crate : crates) {
                        Stack<String> stack1 = new Stack<>();
                        stack1.push(crate.replace("[", "").replace("]", ""));
                        cratesScheme.add(stack1);
                    }
                } else {
                    if (crates.length < cratesScheme.size()) {
                        int currentIndex = 0;
                        for (int j = 0; j < crates.length; j++) {
                            cratesScheme.get(j).push(crates[j].replace("[", "").replace("]", ""));
                            currentIndex++;
                        }
                        for (int j = currentIndex; j < cratesScheme.size();j++) {
                            cratesScheme.get(j).push(" ");
                        }
                    } else {
                        for (int j = 0; j < crates.length; j++) {
                            cratesScheme.get(j).push(crates[j].replace("[", "").replace("]", ""));
                        }
                    }
                }
            }
            for (int i = linePosBetweenSchemeAndInstructs+1; i < lines.size();i++) {
                String[] instructions = lines.get(i).split(" ");
                move(Integer.parseInt(instructions[1]), Integer.parseInt(instructions[3]),
                        Integer.parseInt(instructions[5]),
                        cratesScheme);
            }
            for (Stack<String> crates: cratesScheme) {
                finalResult.append(crates.peek());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      /*  if (inputFile.exists()) {
            try {
                Scanner readFile2 = new Scanner(inputFile);
                while (readFile2.hasNextLine()) {
                    String pair = readFile2.nextLine();

                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }*/

        System.out.println("1 : " + finalResult);
        System.out.println("2 : " + finalResult2);
    }

    public static Vector<Stack<String>> move(int nbMove, int positionStart, int positionEnd, Vector<Stack<String>> currentCrates) {
        int i = 0;
        while( i < nbMove) {
            if (currentCrates.get(positionEnd-1).size() > 0) {
                while (currentCrates.get(positionEnd - 1).peek().trim().equals("") || currentCrates.get(positionEnd-1).peek().trim().equals(" ")) {
                    currentCrates.get(positionEnd - 1).pop();
                }
            }
            while (currentCrates.get(positionStart-1).peek().trim().equals("") || currentCrates.get(positionStart-1).peek().trim().equals(" ")) {
                currentCrates.get(positionStart-1).pop();
            }
            currentCrates.get(positionEnd-1).push(currentCrates.get(positionStart-1).pop());
            i++;
        }
        return currentCrates;
    }
}