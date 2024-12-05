import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String fileName = "src/Day5.txt";
        ArrayList<Integer> xValues = new ArrayList<>();
        ArrayList<Integer> yValues = new ArrayList<>();
        ArrayList<ArrayList<Integer>> updates = new ArrayList<>();

        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (line.contains("|")) {
                    String[] rule = line.split("|");
                    xValues.add(Integer.parseInt(rule[0]));
                    yValues.add(Integer.parseInt(rule[1]));
                } else if (!line.isEmpty()){
                    String[] rule = line.split(",");
                    ArrayList<Integer> levels = new ArrayList<>();
                    updates.add(levels);
                }
            }
        } catch (FileNotFoundException _) {}

        for (ArrayList<Integer> i : updates) {
            ArrayList<Integer> localXValues = new ArrayList<>();
            ArrayList<Integer> localYValues = new ArrayList<>();
            for (int j = 0;  j < xValues.size(); i++) {
                if (updates.contains(xValues.get(j)) && updates.contains(yValues.get(j))) {

                }
            }
        }
    }
    public boolean validRule(ArrayList<Integer> xValues, ArrayList<Integer> yValues, ArrayList<Integer> updates) {
        return true;
    }
}