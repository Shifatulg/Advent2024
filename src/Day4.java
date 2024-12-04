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
                if (character.equals("X")) {
                    boolean vertical = c >= 3 && c <= 136;
                    boolean horizontal = r >= 3 && r <= 136;
                    if (vertical) {
                        if ((wordSearch[r][c] + wordSearch[r][c + 1] + wordSearch[r][c + 2] + wordSearch[r][c + 3]).equals("XMAS")) {
                            sum++;
                        }
                        if ((wordSearch[r][c + 3] + wordSearch[r][c + 2] + wordSearch[r][c + 1] + wordSearch[r][c]).equals("XMAS")) {
                            System.out.println(sum);
                        }
                    }
                    if (horizontal) {
                        if ((wordSearch[r][c] + wordSearch[r + 1][c] + wordSearch[r + 2][c] + wordSearch[r + 3][c]).equals("XMAS")) {
                            sum++;
                        }
                        if ((wordSearch[r + 3][c] + wordSearch[r + 2][c] + wordSearch[r + 1][c] + wordSearch[r][c]).equals("XMAS")) {
                            sum++;
                        }
                    }
                    boolean up = c >= 3;
                    boolean down = c <= 136;
                    boolean left = r >= 3;
                    boolean right = r <= 136;
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
                    if (down && left) {
                        if ((wordSearch[r][c] + wordSearch[r + 1][c + 1] + wordSearch[r + 2][c + 2] + wordSearch[r + 3][c + 3]).equals("XMAS")) {
                            sum++;
                        }
                    }
                }
            }
        }


        System.out.println(sum);
        System.out.println(wordSearch.length + " " + wordSearch[0].length);
    }
}