package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an amount and the denominations of coins available, determine how many ways change can be made for amount.
 * There is a limitless supply of each coin type.
 *
 * Example
 * n = 3
 * c = [8,3,1,2]
 *
 * There are 3 ways to make change for n=3 : {1,1,1}, {1,2}, and {3}.
 *
 * See <a href="https://www.hackerrank.com/challenges/coin-change/problem">
 * HackerRank – The Coin Change Problem
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(getWays(10, Arrays.asList(2L, 5L, 3L, 6L)));
    }

    public static long getWays(int n, List<Long> c) {
        long [][] dp = new long[c.size()+1][n+1];
        dp[0][0] = 1;
        List<Long> coins = new ArrayList<>(c);
        coins.add(0, 0L);
        for(int i = 1; i < coins.size(); i++) {
            for(int j = 0; j < n + 1 ; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (j - coins.get(i) >= 0 ) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j- coins.get(i).intValue()];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            printMatrix(dp);
        }
        return dp[coins.size() - 1][n];
    }

    private static void printMatrix(long[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}