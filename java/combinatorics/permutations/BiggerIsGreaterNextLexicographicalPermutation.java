package combinatorics.permutations;

import java.util.Arrays;

/**
 * Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another
 * string if it comes later in a lexicographically sorted list.
 *
 * Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
 * - It must be greater than the original word
 * - It must be the smallest word that meets the first condition
 *
 * Example
 * w = abcd
 * The next largest word is abdc.
 *
 * The Next Lexicographical Permutation algorithm:
 * - finds the next permutation in dictionary order by identifying a pivot index,
 * - swapping it with the smallest larger element in the suffix,
 * - then reversing the suffix to make the result minimal but still larger
 *
 * See <a href="https://www.hackerrank.com/challenges/bigger-is-greater/problem">
 * HackerRank – Bigger is Greater Problem
 */
public class BiggerIsGreaterNextLexicographicalPermutation {

    public static void main(String[]args){
        System.out.println(biggerIsGreater("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw").equals("zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgwm"));

        System.out.println(biggerIsGreater("acb").equals("bac"));
        System.out.println(biggerIsGreater("abc").equals("acb"));

        System.out.println(biggerIsGreater("ab").equals("ba"));
        System.out.println(biggerIsGreater("bb").equals("no answer"));
        System.out.println(biggerIsGreater("hefg").equals("hegf"));
        System.out.println(biggerIsGreater("dhck").equals("dhkc"));
        System.out.println(biggerIsGreater("dkhc").equals("hcdk"));
        System.out.println(biggerIsGreater("dcba").equals("no answer"));
        System.out.println(biggerIsGreater("dcbb").equals("no answer"));
        System.out.println(biggerIsGreater("ehxxdsuhoowxpbxiwxjrhe").equals("ehxxdsuhoowxpbxiwxrehj"));
    }


    public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();
        int pivot = findPivot(chars);

        if(pivot == -1) {
            return "no answer";
        }

        int toSwap = findFirstRightMostValueGreaterThanValueFromPivot(chars, pivot);

        char temp = chars[pivot];
        chars[pivot] = chars[toSwap];
        chars[toSwap] = temp;

        Arrays.sort(chars, pivot +1, chars.length);
        return new String(chars);
    }

    private static int findFirstRightMostValueGreaterThanValueFromPivot(char[] chars, int pivot) {
        int toSwap = -1;
        for (int i = chars.length -1; i >= 0; i--) {
            if (chars[i] > chars[pivot]) {
                toSwap = i;
                break;
            }
        }
        return toSwap;
    }

    private static int findPivot(char[] chars) {
        int pivot = -1;
        for (int i = chars.length -2; i >= 0; i--) {
            if (chars[i] < chars[i+1]) {
                pivot = i;
                break;
            }
        }
        return pivot;
    }
}