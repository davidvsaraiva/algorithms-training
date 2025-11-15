package backtracking;

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
 * See <a href="https://www.hackerrank.com/challenges/bigger-is-greater/problem">
 * HackerRank – Bigger is Greater Problem
 */
public class BiggerIsGreater {

    public static void main(String[]args){
        System.out.println(biggerIsGreater("acb").equals("bac"));
        System.out.println(biggerIsGreater("abc").equals("acb"));

        System.out.println(biggerIsGreater("ab").equals("ba"));
        System.out.println(biggerIsGreater("bb").equals("no answer"));
        System.out.println(biggerIsGreater("hefg").equals("hegf"));
        System.out.println(biggerIsGreater("dhck").equals("dhkc"));
        System.out.println(biggerIsGreater("dkhc").equals("hcdk"));
    }

    public static String biggerIsGreater(String w) {
        String result = dfs(w, new StringBuilder(w), new StringBuilder(), "");
        return result.isEmpty() ? "no answer" : result;
    }

    private static String dfs(String orig, StringBuilder remainder, StringBuilder newWord, String best) {
        if (newWord.length() == orig.length() ) {
            String candidate = newWord.toString();
            if(candidate.compareTo(orig) > 0 && (best.isEmpty() || candidate.compareTo(best) < 0)) {
                return candidate;
            } else {
                return best;
            }
        }
        for(int i = 0; i < remainder.length(); i++) {
            char c = remainder.charAt(i);

            newWord.append(c);
            remainder.deleteCharAt(i);

            best = dfs(orig, remainder, newWord, best);

            newWord.deleteCharAt(newWord.length()-1);
            remainder.insert(i, c);
        }
        return best;
    }
}