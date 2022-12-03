import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        int finalResult = 0;
        int finalResult2 = 0;
        List<Character> priorityLetters = addPriorityLettersToList();
        List<Character> commonCharacters = new ArrayList<>();

        Path currentDirectoryPath = Paths.get("").toAbsolutePath();
        File inputFile = new File(currentDirectoryPath + "/out/production/Day3/input.txt");
        if (inputFile.exists()) {
            try {
                Scanner readFile = new Scanner(inputFile);
                while (readFile.hasNextLine()) {
                    String sack = readFile.nextLine();
                    String firstCompartment = sack.substring(0, sack.length()/2);
                    String secondCompartment = sack.substring(sack.length()/2);
                    commonCharacters.addAll(lettersCompare(firstCompartment, secondCompartment));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
   /*     if (inputFile.exists()) {
            try {
                Scanner readFile2 = new Scanner(inputFile);
                while (readFile2.hasNextLine()) {
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }*/
        for (Character c : commonCharacters) {
          finalResult += (priorityLetters.indexOf(c) + 1);
        }

        System.out.println("1 : " + finalResult);
        System.out.println("2 : " + finalResult2);

    }
    public static List<Character> lettersCompare(String s1, String s2) {
        List<Character> characters = new ArrayList<>();
        char[] characters1 = s1.toCharArray();
        char[] characters2 = s2.toCharArray();
        for (Character c1: characters1) {
            for(Character c2: characters2) {
                if (c1.equals(c2) && !characters.contains(c1)) {
                    characters.add(c1);
                }
            }
        }
        return characters;
    }

    public static List<Character> addPriorityLettersToList() {
        List<Character> priorityLetter = new ArrayList<>();
        priorityLetter.add('a');
        priorityLetter.add('b');
        priorityLetter.add('c');
        priorityLetter.add('d');
        priorityLetter.add('e');
        priorityLetter.add('f');
        priorityLetter.add('g');
        priorityLetter.add('h');
        priorityLetter.add('i');
        priorityLetter.add('j');
        priorityLetter.add('k');
        priorityLetter.add('l');
        priorityLetter.add('m');
        priorityLetter.add('n');
        priorityLetter.add('o');
        priorityLetter.add('p');
        priorityLetter.add('q');
        priorityLetter.add('r');
        priorityLetter.add('s');
        priorityLetter.add('t');
        priorityLetter.add('u');
        priorityLetter.add('v');
        priorityLetter.add('w');
        priorityLetter.add('x');
        priorityLetter.add('y');
        priorityLetter.add('z');
        priorityLetter.add('A');
        priorityLetter.add('B');
        priorityLetter.add('C');
        priorityLetter.add('D');
        priorityLetter.add('E');
        priorityLetter.add('F');
        priorityLetter.add('G');
        priorityLetter.add('H');
        priorityLetter.add('I');
        priorityLetter.add('J');
        priorityLetter.add('K');
        priorityLetter.add('L');
        priorityLetter.add('M');
        priorityLetter.add('N');
        priorityLetter.add('O');
        priorityLetter.add('P');
        priorityLetter.add('Q');
        priorityLetter.add('R');
        priorityLetter.add('S');
        priorityLetter.add('T');
        priorityLetter.add('U');
        priorityLetter.add('V');
        priorityLetter.add('W');
        priorityLetter.add('X');
        priorityLetter.add('Y');
        priorityLetter.add('Z');
        return priorityLetter;
    }
}