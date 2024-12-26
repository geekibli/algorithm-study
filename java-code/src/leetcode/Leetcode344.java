package leetcode;

/**
 * 反转字符串
 */
public class Leetcode344 {

    class Solution {
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            char tmp ;
            while (left < right){
                tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                right--;
                left++;
            }

        }
    }

    public static void reverseString(char[] s) {

        int index = 0;

        for(int i = s.length - 1; i >= 0 && index <= i; i--){
            char temp = s[index];
            s[index] = s[i];
            s[i] = temp;
            index++;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);

        System.err.println(s);
    }

}
