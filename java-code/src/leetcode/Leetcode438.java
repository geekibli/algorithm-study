package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 */
public class Leetcode438 {

    static class Solution {
        static public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList();
            int len = p.length();
            for (int i = 0; i < s.length() - len ; i++) {
                int endIndex = i + len;
                String subString = s.substring(i , endIndex);
                if (isAnagram(subString , p)) {
                    result.add(i);
                }
            }
            return result;
        }

        static public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] table = new int[26];
            for (int i = 0; i < s.length(); i++) {
                table[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                table[t.charAt(i) - 'a']--;
                if (table[t.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }



    }


}
