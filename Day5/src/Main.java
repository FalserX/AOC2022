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
        StringBuilder finalResult2 = new StringBuilder();

        int linePosBetweenSchemeAndInstructs = 0;
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
            Vector<Stack<String>> cratesSchemeUnit = initializeList(linePosBetweenSchemeAndInstructs, lines);
            Vector<Stack<String>> cratesSchemeUpdated = initializeList(linePosBetweenSchemeAndInstructs, lines);

            for (int i = linePosBetweenSchemeAndInstructs+1; i < lines.size(); i++) {
                String[] instructions = lines.get(i).split(" ");
                int nbMoves = Integer.parseInt(instructions[1]);
                int posStart = Integer.parseInt(instructions[3]);
                int posEnd = Integer.parseInt(instructions[5]);
                move(nbMoves, posStart, posEnd, cratesSchemeUnit);
            }
            for (int i = linePosBetweenSchemeAndInstructs+1; i < lines.size(); i++) {
                String[] instructions = lines.get(i).split(" ");
                int nbMoves = Integer.parseInt(instructions[1]);
                int posStart = Integer.parseInt(instructions[3]);
                int posEnd = Integer.parseInt(instructions[5]);
                moveMultiples(nbMoves, posStart, posEnd, cratesSchemeUpdated);
            }
            for (Stack<String> crates: cratesSchemeUnit) {
                finalResult.append(crates.peek());
            }
            for (Stack<String> cratesUpdated: cratesSchemeUpdated) {
                finalResult2.append(cratesUpdated.peek());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("1 : " + finalResult);
        System.out.println("2 : " + finalResult2);
    }

    public static Vector<Stack<String>> initializeList(int linePosBetweenSchemeAndInstructs,
                                                       List<String> lines) {
        List<Integer> indexCol = new ArrayList<>();
        Vector<Stack<String>> cratesScheme = new Vector<>();
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
                        String currentCrate = crates[j].replace("[", "").replace("]", "");
                        cratesScheme.get(j).push(currentCrate);
                        currentIndex++;
                    }
                    for (int j = currentIndex; j < cratesScheme.size();j++) {
                        cratesScheme.get(j).push(" ");
                    }
                } else {
                    for (int j = 0; j < crates.length; j++) {
                        String currentCrate = crates[j].replace("[", "").replace("]", "");
                        cratesScheme.get(j).push(currentCrate);
                    }
                }
            }
        }
        return cratesScheme;
    }

    public static void move(int nbMove, int positionStart, int positionEnd, Vector<Stack<String>> currentCrates) {
        int i = 0;
        while(i < nbMove) {
            if (currentCrates.get(positionEnd-1).size() > 0) {
                while (currentCrates.get(positionEnd - 1).peek().trim().equals("") || currentCrates.get(positionEnd-1).peek().trim().equals(" ")) {
                    currentCrates.get(positionEnd - 1).pop();
                }
            }
            if (currentCrates.get(positionStart - 1).size() > 0) {
                while (currentCrates.get(positionStart - 1).peek().trim().equals("") || currentCrates.get(positionStart - 1).peek().trim().equals(" ")) {
                    currentCrates.get(positionStart - 1).pop();
                }
            }
            currentCrates.get(positionEnd-1).push(currentCrates.get(positionStart-1).pop());
            i++;
        }
    }
    public static void moveMultiples(int nbMove, int positionStart, int positionEnd, Vector<Stack<String>> currentCrates) {
        Stack<String> temp = new Stack<>();
        int i = 0;
        while(i < nbMove) {
            if (currentCrates.get(positionEnd - 1).size() > 0) {
                while (currentCrates.get(positionEnd - 1).peek().trim().equals("") || currentCrates.get(positionEnd - 1).peek().trim().equals(" ")) {
                    currentCrates.get(positionEnd - 1).pop();
                }
            }
            if (currentCrates.get(positionStart - 1).size() > 0) {
                while (currentCrates.get(positionStart - 1).peek().trim().equals("") || currentCrates.get(positionStart - 1).peek().trim().equals(" ")) {
                    currentCrates.get(positionStart - 1).pop();
                }
            }
            temp.push(currentCrates.get(positionStart - 1).pop());
            i++;
        }

        while(!temp.isEmpty()) {
            currentCrates.get(positionEnd - 1).push(temp.pop());
        }
    }
}