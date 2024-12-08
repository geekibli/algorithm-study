package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class Leetcode383 {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (magazine == null || magazine.length() == 0 ) return false;

            Map<Character , Integer> map = getMap(magazine);
            for (Character temp : ransomNote.toCharArray()) {
                Integer count = map.get(temp);
                if (count == null || count <= 0) {
                    return false;
                }
                count--;
                map.put(temp ,count);
            }
            return true;
        }

        public Map<Character , Integer> getMap(String s) {
            if (s == null || s.length() == 0) return new HashMap(2);
            Map<Character , Integer> map = new HashMap();
            for (Character temp : s.toCharArray()) {
                Integer count = map.get(temp);
                if (count == null) {
                    map.put(temp ,1);
                }else {
                    count++;
                    map.put(temp , count);
                }
            }
            return map;
        }
    }
}
