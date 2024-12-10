import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Day9 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String fileName = "src/Day9.txt";
        String code = "";
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                code = line;
                if (!line.equals("")) {

                }
            }
        } catch (FileNotFoundException e) {}

        boolean buffer = true;
        int num = 0;
        String decodedString = "";
        for (int i = 0; i < code.length(); i++) {
            int input = Integer.parseInt(code.substring(i,i+1));
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
            }
        }
        System.out.println(decodedString);
    }

}