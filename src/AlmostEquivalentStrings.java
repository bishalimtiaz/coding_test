/**
 * <a href="https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/description/">...</a>
 */

public class AlmostEquivalentStrings {

    public static boolean checkAlmostEquivalent(String word1, String word2) {

        int[] freq = new int[26];

        for (char c : word1.toCharArray()) freq[c - 'a']++;
        for (char c : word2.toCharArray()) freq[c - 'a']--;
        for (int val : freq) {
            if (Math.abs(val) > 3) return false;
        }

        return true;

    }

    public static void main(String[] args) {
        String word1 = "zzzyyy";
        String word2 = "iiiiii";
        System.out.println(checkAlmostEquivalent(word1, word2));
    }
}
