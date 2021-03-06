package leetcode.panda.chapter0767;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(s.reorganizeString("abbabbaaab"));

    }

    public String reorganizeString(String S) {
        char[] result = new char[S.length()];
        int[] conut = new int[26];
        int maxIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            conut[index]++;
            if (conut[maxIndex] < conut[index]) {
                maxIndex = index;
            }
        }
        if (conut[maxIndex] > (S.length() + 1) / 2) {
            return "";
        }

        int index = 0;
        int k = 0;
        while (conut[maxIndex] > 0) {
            result[k] = (char) (maxIndex + 'a');
            conut[maxIndex]--;
            k += 2;
        }
        while (index < conut.length) {
            if (k >= S.length()) {
                k = 1;
            }
            while (index < conut.length && conut[index] <= 0) {
                index++;
            }
            if (index == conut.length) {
                break;
            }
            result[k] = (char) (index + 'a');
            conut[index]--;
            k += 2;
        }
        return new String(result);
    }
}