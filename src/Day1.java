import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String fileName = "src/Day1.txt";

        ArrayList<Integer> leftValues = new ArrayList<Integer>();
        ArrayList<Integer> rightValues = new ArrayList<Integer>();

        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals("")) {
                    String[] values = line.split("   ");
                    leftValues.add(Integer.parseInt(values[0]));
                    rightValues.add(Integer.parseInt(values[1]));
                }
            }
        } catch (FileNotFoundException e) {}

        int sum = 0;
        for (int i = 0; i < leftValues.size(); i++) {
            int instances = 0;
            for (int x = 0; x < rightValues.size(); x++) {
                if (Objects.equals(leftValues.get(i), rightValues.get(x))) {
                    instances++;
                }
            }
            int distance = leftValues.get(i) * instances;
            sum += distance;
        }

        System.out.println(sum);
    }
}