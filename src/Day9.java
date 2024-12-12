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

        for (int i = 0; i < decodedString.length(); i++) {
            if (decodedString.substring(i,i+1).equals(".")) {
                for (int j = decodedString.length(); j > 0; j--) {
                    if (!decodedString.substring(j-1,j).equals(".")) {
                        String fragmentOne = decodedString.substring(0,i-1);
                        String fragmentTwo = decodedString.substring(i+1,j-1);
                        String fragmentThree = decodedString.substring(j) + ".";
                        decodedString = fragmentThree + fragmentTwo + fragmentOne;
                    }
                }
            }
        }
        System.out.println(decodedString);
    }

}