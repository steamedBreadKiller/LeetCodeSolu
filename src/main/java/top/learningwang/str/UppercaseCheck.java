package top.learningwang.str;



/**
 * @author wangjingbiao
 * createTime: 2020/5/6 下午2:42
 * desc:
 * 解决问题520号
 */
public class UppercaseCheck {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse("ABC"));
        System.out.println(solution.detectCapitalUseWithPattern("ABC"));

        System.out.println(solution.detectCapitalUse("AbC"));
        System.out.println(solution.detectCapitalUseWithPattern("AbC"));

        System.out.println(solution.detectCapitalUse("Abc"));
        System.out.println(solution.detectCapitalUseWithPattern("Abc"));

        System.out.println(solution.detectCapitalUse("aBc"));
        System.out.println(solution.detectCapitalUseWithPattern("aBc"));

        System.out.println(solution.detectCapitalUse("abc"));
        System.out.println(solution.detectCapitalUseWithPattern("abc"));

        System.out.println(solution.detectCapitalUse(""));
        System.out.println(solution.detectCapitalUseWithPattern(""));

    }

    static class Solution {

        public boolean detectCapitalUse(String word) {
            // 字符串为空，直接返回错误信息
            if (word == null || word.isEmpty()) {
                return false;
            }
            int upperCharNum = 0;
            int lowerCharNum = 0;
            for (int i = 0; i < word.length(); i++) {
                int asciiValue = word.charAt(i);
                if (asciiValue >= 'A' && asciiValue <= 'Z') {
                    upperCharNum++;
                } else if (asciiValue >= 'a' && asciiValue <= 'z') {
                    lowerCharNum++;
                } else {
                    // 包含其他字符，直接返回false
                    return false;
                }
            }

            // 如果是大写字母开头，大写字母长度应该为1或者等于总长度
            if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
                return upperCharNum == 1 || upperCharNum == word.length();
            }
            // 如果是小写字母开头，小写字母长度应该等于总长度
            if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
                return lowerCharNum == word.length();
            }
            // 其他字符开头，直接返回false，理论上不会出现，遍历时已处理
            return false;
        }

        // 正则解法
        public boolean detectCapitalUseWithPattern(String word) {
            if(word == null|| word.isEmpty()){
                return false;
            }
            return java.util.regex.Pattern.matches("[A-Z]*$", word)
                    || java.util.regex.Pattern.matches("[A-Z][a-z]*$", word)
                    || java.util.regex.Pattern.matches("[a-z]*$", word);
        }
    }
}


