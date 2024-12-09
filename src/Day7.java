import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Day7 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String fileName = "src/Day7.txt";
        ArrayList<ArrayList<Integer>> equations = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();

        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) {
                    String[] levelString = line.split(":");
                    ArrayList<Integer> equation = new ArrayList<>();
                    answers.add(Integer.parseInt(levelString[0]));
                    for (String i : levelString) {
                        equation.add(Integer.parseInt(i));
                    }
                    equations.add(equation);
                }
            }
        } catch (FileNotFoundException e) {}

        int sum = 0;
        for (int i = 0; i  < answers.size(); i++) {
            for (int k = 0; k < Math.pow(2, answers.get(i) - 1); k++) {
                for (int j = 0; j < equations.size(); j++) {
                    if ()
                }
            }
        }
    }
}