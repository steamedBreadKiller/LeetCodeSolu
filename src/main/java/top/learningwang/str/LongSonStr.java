package top.learningwang.str;

/**
 * @author wangjingbiao
 * createTime: 2020/5/7 下午6:02
 * desc: 003号问题最长子串
 */
public class LongSonStr {
    public static void main(String[] args) {

    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            long maxLen = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                long currentMaxLen = 1;
                char currentChar = s.charAt(i);
                for (int j = i + 1; j < s.length(); j++) {
                    if(s.charAt(j)!=currentChar){
                        currentMaxLen++;
                    }else{
                        break;
                    }
                }
            }
            return 0;
        }
    }
}
