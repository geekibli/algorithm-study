package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Leetcode49 {

    public static void main(String[] args) {
        String[] ss = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.err.println(Solution3.groupAnagrams(ss));
    }

    /**
     * 由于互为字母异位词的两个字符串包含的字母相同，因此两个字符串中的相同字母出现的次数一定是相同的，故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
     * <p>
     * 由于字符串只包含小写字母，因此对于每个字符串，可以使用长度为 26 的数组记录每个字母出现的次数。需要注意的是，在使用数组作为哈希表的键时，不同语言的支持程度不同，因此不同语言的实现方式也不同。
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/group-anagrams/solutions/520469/zi-mu-yi-wei-ci-fen-zu-by-leetcode-solut-gyoc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 最终map: {a1b1t1=[bat], a1n1t1=[tan, nat], a1e1t1=[eat, tea, ate]}
     */
    static class Solution3 {
        public static List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for (String str : strs) {
                int[] counts = new int[26];
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    counts[str.charAt(i) - 'a']++;
                }
                // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 26; i++) {
                    if (counts[i] != 0) {
                        sb.append((char) ('a' + i));
                        sb.append(counts[i]);
                    }
                }
                String key = sb.toString();
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                map.put(key, list);
            }

            // {a1b1t1=[bat], a1n1t1=[tan, nat], a1e1t1=[eat, tea, ate]}
            return new ArrayList<List<String>>(map.values());
        }
    }


    /**
     * 还是排序的思路 打败了 59%
     */
    class Solution_2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String key = new String(array);
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<List<String>>(map.values());
        }
    }


    /**
     * 暴力解法 竟然成功了 啊哈哈哈哈 ～～～～
     * 打败了 5% 。。。。。。
     */
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();


            for (String str : strs) {

                if (map.isEmpty()) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(str, list);
                } else {
                    boolean find = false;
                    for (String key : map.keySet()) {
                        if (isAnagram(key, str)) {
                            map.get(key).add(str);
                            find = true;
                        }
                    }
                    if (!find) {
                        ArrayList<String> list = new ArrayList<>();
                        list.add(str);
                        map.put(str, list);
                    }
                }
            }

            return new ArrayList<>(map.values());

        }


        public boolean isAnagram(String s, String t) {
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
