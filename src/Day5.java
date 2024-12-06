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
                    String[] rule = line.split("\\|");
                    xValues.add(Integer.parseInt(rule[0]));
                    yValues.add(Integer.parseInt(rule[1]));
                } else if (!line.isEmpty()){
                    String[] rule = line.split(",");
                    ArrayList<Integer> levels = new ArrayList<>();
                    for (String i : rule) {
                        levels.add(Integer.parseInt(i));
                    }
                    updates.add(levels);
                }
            }
        } catch (FileNotFoundException _) {}

        ArrayList<Integer> middleValue = new ArrayList<>();

        for (ArrayList<Integer> i : updates) {
            ArrayList<Integer> validXPages = new ArrayList<>();
            ArrayList<Integer> validYPages = new ArrayList<>();
            for (int j = 0;  j < xValues.size(); j++) {

                if (i.contains(xValues.get(j)) && i.contains(yValues.get(j))) {
                    validXPages.add(xValues.get(j));
                    validYPages.add(yValues.get(j));
                }
            }
            if (validRule(validXPages, validYPages, i)) {
                middleValue.add(i.get(i.size() / 2));
            }
        }

        int sum = 0;
        for (int i : middleValue) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static boolean validRule(ArrayList<Integer> xValues, ArrayList<Integer> yValues, ArrayList<Integer> updates) {
        for (int j = 0; j < xValues.size(); j++) {
            for (int i = 0; i < updates.size(); i++) {
                for (int k = i; k < updates.size(); k++) {
                    if (updates.get(k) == xValues.get(j) && updates.get(i) == yValues.get(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}