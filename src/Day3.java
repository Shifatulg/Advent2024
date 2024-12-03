import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String fileName = "src/Day3.txt";
        String input = "";

        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            int index = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                input += line;
            }
        } catch (FileNotFoundException _) {}

        ArrayList<String> allMatches = new ArrayList<String>();

        String regex = "mul\\([1-9]?[0-9]?[0-9]?,[1-9]?[0-9]?[0-9]?\\)";
        Matcher m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }

        int sum = 0;

        for (String i : allMatches) {
            String multParentheses = i.substring(4,i.length() - 1);
            String[] numbers = multParentheses.split(",");
            sum += Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
        }
        System.out.println(sum);
    }
}