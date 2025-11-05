package dynamic_programming;

import java.math.BigInteger;

/**
 * Implement a modified Fibonacci sequence using the following definition:
 *
 *  Given terms:
 *  <pre>
 *   T_{i+2} = T_{i} + (T_{i+1})^2 ,  for i >= 1
 *  </pre>
 *  given the first two terms T1 and T2.
 *
 * See <a href="https://www.hackerrank.com/challenges/fibonacci-modified/problem">
 * HackerRank – Fibonacci Modified
 */
public class FibonacciModified {

    public static void main(String[]args){

        System.out.println(fibonacciModified(0, 1, 20));
    }

    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger curr = BigInteger.ZERO;
        BigInteger before_prev = BigInteger.valueOf(t1);
        BigInteger prev = BigInteger.valueOf(t2);
        for (int i = 2; i <= n - 1; i++) {
            curr = before_prev.add(prev.pow(2));
            before_prev = prev;
            prev = curr;
        }
        return curr;
    }
}