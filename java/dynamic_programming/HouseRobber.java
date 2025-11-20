package dynamic_programming;

/**
 * House robber (problem)
 * Given an array of integers arr where arr[i] represents the amount of money in the house i, you are asked to find the
 * maximum amount of money that a robber can steal knowing that he can't steal two adjacent houses because the security
 * systems would automatically call the police
 *
 * Example:
 * input: arr = [2, 10, 3, 6, 8, 1, 7]
 * output: 25
 * explanation: The greatest amount of money that a robber can get is 25, by the stealing the house 1, 4, and 6
 * (arr[1]+arr[4]+arr[6] = 10+8+7 = 25)
 *
 * Constraints:
 *
 * len(arr) >= 1
 * arr[i] >= 0
 *
 * See <a href="https://www.udemy.com/course/dynamic-programming-x/learn/quiz/5345756#overview">
 * Udemy – House Robber
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] arr = {2, 10, 3, 6, 8, 1 , 7};
        System.out.println(houseRobberMax(arr));
    }

    private static int houseRobberMax(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return arr[0];
        }
        if (n == 2){
            return Math.max(arr[0], arr[1]);
        }

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int take = arr[i] + prev2;
            int skip = prev1;
            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}