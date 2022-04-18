package nbcode;

import java.util.*;

/**
 * @author zcl
 * @date 2022/4/12 10:47
 */
public class HJ70MartrixMultilplyCountEvaluate {
    static class Main {
        public void main() {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int sum = 0;
            int[][] martrixInfo = new int[n][2];
            for (int i = 0; i < n; i++) {
                int row = scanner.nextInt();
                int column = scanner.nextInt();
                martrixInfo[i][0] = row;
                martrixInfo[i][1] = column;
            }
            Stack<Character> characterStack = new Stack<>();
            String calculateOrder = scanner.next();
            for (int i = 0; i < calculateOrder.length(); i++) {
                char c = calculateOrder.charAt(i);
                if (c == ')') {
                    StringBuilder builder = new StringBuilder();
                    while (!characterStack.isEmpty() && characterStack.peek() != '(') {
                        Character pop = characterStack.pop();
                        builder.append(pop);
                    }

                    for (int j = builder.length() - 1; j > 0; j--) {
                        int predRow = martrixInfo[builder.charAt(j) - 'A'][0];
                        int predColumn = martrixInfo[builder.charAt(j) - 'A'][1];
                        int sucColumn = martrixInfo[builder.charAt(j) - 'A' + 1][1];
                        sum = sum + (predRow * predColumn * sucColumn);
                    }
                    if (!characterStack.isEmpty() && characterStack.peek() == '(') {
                        characterStack.pop();
                    }
                } else {
                    characterStack.push(c);
                }
            }
            System.out.println(sum);
        }

        public static void main(String[] args) {
            HJ70MartrixMultilplyCountEvaluate.Main main = new HJ70MartrixMultilplyCountEvaluate.Main();
            main.main();
        }
    }
}
