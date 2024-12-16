import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Day9 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String fileName = "src/Day9.txt";
        ArrayList<String> codes = new ArrayList<>();

        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String code = "";
                String line = s.nextLine();
                code = line;
                codes.add(code);
                if (!line.equals("")) {

                }
            }
        } catch (FileNotFoundException e) {}

        boolean buffer = true;
        int num = 0;
        String decodedString = "";
        for (String j : codes ) {
            for (int i = 0; i < j.length(); i++) {
                int input = Integer.parseInt(j.substring(i, i + 1));
                buffer = !buffer;
                if (buffer) {
                    for (int x = 0; x < input; x++) {
                        decodedString += ".";
                    }
                } else {
                    for (int x = 0; x < input; x++) {
                        decodedString += num;
                    }
                    num++;
                    if (num == 10) {
                        num = 0;
                    }
                }
            }
        }

        System.out.println(decodedString);

        for (int i = 0; i < decodedString.length(); i++) {
            if (decodedString.substring(i,i+1).equals(".")) {
                boolean replaced = true;
                int j = decodedString.length() - 1;
                while (replaced && j > 0) {
                    System.out.println(j + " " + i);
                    System.out.println(decodedString);
                    System.out.println(decodedString.substring(j-1,j));
                    if (!decodedString.substring(j - 1, j).equals(".")) {
                        System.out.println("wsg");
                        char[] charArray = decodedString.toCharArray();
                        char oldChar = charArray[i];
                        char newChar = charArray[j];
                        charArray[i] = newChar;
                        charArray[j] = oldChar;
                        decodedString = String.valueOf(charArray);
                        replaced = false;
                        // https://www.geeksforgeeks.org/swapping-characters-string-java/
                    }
                    j--;
                }
            }
        }

        System.out.println(decodedString);

    }
}