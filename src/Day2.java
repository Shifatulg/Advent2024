import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String fileName = "src/Day2.txt";
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) {
                    String[] levelString = line.split(" ");
                    ArrayList<Integer> level = new ArrayList<>();
                    for (String i : levelString) {
                        level.add(Integer.parseInt(i));
                    }
                    levels.add(level);
                }
            }
        } catch (FileNotFoundException _) {}

        int safeLevels = 0;

        for (ArrayList<Integer> level : levels) {
            boolean safe = true;
            for (int i = 0; i < level.size() - 1; i++) {
                boolean increasing = (level.get(0) - level.get(1) < 0);
                int firstInt = level.get(i);
                int secondInt = level.get(i + 1);
                int removeLevel = -1;
                if (i + 2 < level.size() - 1) {
                    removeLevel = level.get(i + 2) - firstInt;
                }
                int difference = secondInt - firstInt;
                if ((difference < 1 || difference > 3) && increasing) {
                    safe = false;
                    if (removeLevel != -1) {
                        if ((removeLevel < 1 || removeLevel > 3)) {
                            safe = true;
                        }
                    }
                }
                if ((difference > -1 || difference < -3) && !increasing) {
                    safe = false;
                    if (removeLevel != -1) {
                        if ((removeLevel > -1 || removeLevel < -3)) {
                            safe = true;
                        }
                    }
                }
            }
            if (safe) {
                safeLevels++;
            }
        }
        System.out.println(safeLevels);
    }
}