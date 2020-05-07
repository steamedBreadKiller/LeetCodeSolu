package top.learningwang.str;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangjingbiao
 * createTime: 2020/5/7 下午6:02
 * desc: 003号问题最长子串
 */
public class LongSonStr {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring(" "));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || "".equals(s)) {
                return 0;
            }
            Set<Character> hashSet = new HashSet<Character>();
            int maxLen = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                int currentMaxLen = 1;
                char currentChar = s.charAt(i);
                hashSet.add(currentChar);
                for (int j = i + 1; j < s.length(); j++) {
                    if (hashSet.contains(s.charAt(j))) {
                        hashSet.clear();
                        break;
                    }
                    hashSet.add(s.charAt(j));
                    currentMaxLen++;
                }
                maxLen = Math.max(maxLen, currentMaxLen);
            }
            return maxLen;
        }
    }
}
