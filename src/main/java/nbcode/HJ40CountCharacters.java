package nbcode;

import java.util.Scanner;

/**
 * @author zcl
 * @date 2022/4/12 10:47
 */
public class HJ40CountCharacters {
    static class Main {
        public void main() {
            Scanner scanner = new Scanner(System.in);
            int numberCount = 0;
            int spaceCount = 0;
            int aphabetCount = 0;
            int othersCount = 0;
            String s = scanner.nextLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ((c <= ('z') && c >= 'a') || (c <= 'Z' && c >= 'A')) {
                    aphabetCount++;
                } else if (c == ' ') {
                    spaceCount++;
                } else if (c <= '9' && c >= '0') {
                    numberCount++;
                } else {
                    othersCount++;
                }
            }
            System.out.println(aphabetCount);
            System.out.println(spaceCount);
            System.out.println(numberCount);
            System.out.println(othersCount);

        }

        public static void main(String[] args) {
            HJ40CountCharacters.Main main = new HJ40CountCharacters.Main();
            main.main();
        }
    }
}
