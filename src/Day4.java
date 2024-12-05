import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String fileName = "src/Day4.txt";
        ArrayList<String> fileData = new ArrayList<>();

        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData.add(line);
            }
        } catch (FileNotFoundException _) {}


        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] wordSearch = new String[rows][columns];

        for (int r = 0; r < wordSearch.length; r++) {
            for (int c = 0; c < wordSearch[0].length; c++) {
                wordSearch[r][c] = fileData.get(r).substring(c, c+1);
                System.out.print(wordSearch[r][c] + " ");
            }
            System.out.println();
        }

        int sum = 0;

        for (int r = 0; r < wordSearch.length; r++) {
            for (int c = 0; c < wordSearch[r].length; c++) {
                String character = wordSearch[r][c];
                boolean up = r >= 3;
                boolean down = r <= 136;
                boolean left = c >= 3;
                boolean right = c <= 136;
                if (up) {
                    if ((wordSearch[r][c] + wordSearch[r - 1][c] + wordSearch[r - 2][c] + wordSearch[r - 3][c]).equals("XMAS")) {
                        sum++;
                    }
                }
                if (down) {
                    if ((wordSearch[r][c] + wordSearch[r + 1][c] + wordSearch[r + 2][c] + wordSearch[r + 3][c]).equals("XMAS")) {
                        sum++;
                    }
                }
                if (left) {
                    if ((wordSearch[r][c] + wordSearch[r][c - 1] + wordSearch[r][c - 2] + wordSearch[r][c - 3]).equals("XMAS")) {
                        sum++;
                    }
                }
                if (right) {
                    if ((wordSearch[r][c] + wordSearch[r][c + 1] + wordSearch[r][c + 2] + wordSearch[r][c + 3]).equals("XMAS")) {
                        sum++;
                    }
                }
                if (up && left) {
                    if ((wordSearch[r][c] + wordSearch[r - 1][c - 1] + wordSearch[r - 2][c - 2] + wordSearch[r - 3][c - 3]).equals("XMAS")) {
                        sum++;
                    }
                }
                if (down && left) {
                    if ((wordSearch[r][c] + wordSearch[r + 1][c - 1] + wordSearch[r + 2][c - 2] + wordSearch[r + 3][c - 3]).equals("XMAS")) {
                        sum++;
                    }
                }
                if (up && right) {
                    if ((wordSearch[r][c] + wordSearch[r - 1][c + 1] + wordSearch[r - 2][c + 2] + wordSearch[r - 3][c + 3]).equals("XMAS")) {
                        sum++;
                    }
                }
                if (down && right) {
                    if ((wordSearch[r][c] + wordSearch[r + 1][c + 1] + wordSearch[r + 2][c + 2] + wordSearch[r + 3][c + 3]).equals("XMAS")) {
                        sum++;
                     }
                }
            }
        }
    System.out.println(sum);
    System.out.println(wordSearch.length + " " + wordSearch[0].length);
    }
}