package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given blocks of dimension 1, 2, 3, 4 find all permutations for the blocks for a given user input length (n).
 */
public class LegoBlocksPermutationsBacktracking {

    private static final List<Integer> blocks = Arrays.asList(1, 2, 3, 4);

    private static void dfs(List<List<Integer>> result, List<Integer> perm, int n) {
        if (sum(perm) == n) {
            result.add(new ArrayList<>(perm));
            return;
        } else if(sum(perm ) > n) {
            return;
        }
        for (int i = 0; i < blocks.size() && (sum(perm) + blocks.get(i) <= n) ; i++) {
            perm.add(blocks.get(i));
            dfs(result, perm, n);
            perm.remove(perm.size()-1);
        }
    }

    private static int sum(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int userInput = getLineLengthFromUserInput();

        dfs(result, new ArrayList<>(), userInput);
        result.forEach(System.out::println);
    }

    private static int getLineLengthFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dimension of the line: ");
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid integer. Please try again.");
            scanner.next();
        }
        int userInput = scanner.nextInt();
        System.out.println("You entered: " + userInput);
        scanner.close();
        return userInput;
    }
}
