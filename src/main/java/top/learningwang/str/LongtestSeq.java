package top.learningwang.str;

/**
 * @author wangjingbiao
 * createTime: 2020/5/6 下午3:22
 * desc:
 * 解决问题521号，最长不重复序列
 */
public class LongtestSeq {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLUSlength("aaa", "aaa"));
        System.out.println(solution.findLUSlength("aaaa", "aab"));
    }

    static class Solution {
        public int findLUSlength(String a, String b) {
            if(a.equals(b)) {
                return -1;
            }
            return a.length() > b.length() ? a.length() : b.length();
        }
    }
}
