package leetcode.panda.chapter5637;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半,前一半为 a ,后一半为 b 。
 * <p>
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a','e','i','o','u','A','E','I','O','U'）。注意,s 可能同时含有大写和小写字母。
 * <p>
 * 如果 a 和 b 相似,返回 true ；否则,返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音,b 也有 1 个元音。所以,a 和 b 相似。
 * 示例 2：
 * <p>
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音,b 中有 2 个元音。因此,a 和 b 不相似。
 * 注意,元音 o 在 b 中出现两次,记为 2 个。
 * 示例 3：
 * <p>
 * 输入：s = "MerryChristmas"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "AbCdEfGh"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 1000
 * s.length 是偶数
 * s 由 大写和小写 字母组成
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        int[] arr2 = {1241, 8769, 9151, 3211, 2314, 8007, 3713, 5835, 2176, 8227, 5251, 9229, 904, 1899, 5513, 7878, 8663, 3804, 2685, 3501, 1204, 9742, 2578, 8849, 1120, 4687, 5902, 9929, 6769, 8171, 5150, 1343, 9619, 3973, 3273, 6427, 47, 8701, 2741, 7402, 1412, 2223, 8152, 805, 6726, 9128, 2794, 7137, 6725, 4279, 7200, 5582, 9583, 7443, 6573, 7221, 1423, 4859, 2608, 3772, 7437, 2581, 975, 3893, 9172, 3, 3113, 2978, 9300, 6029, 4958, 229, 4630, 653, 1421, 5512, 5392, 7287, 8643, 4495, 2640, 8047, 7268, 3878, 6010, 8070, 7560, 8931, 76, 6502, 5952, 4871, 5986, 4935, 3015, 8263, 7497, 8153, 384, 1136};
//        System.out.println(s.minOperations(arr2, 894887480));
        System.out.println(s.halvesAreAlike("textbook"));

    }

    public boolean halvesAreAlike(String s) {

        List<Character> boys = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int cnt = 0;
        int k = s.length() / 2;
        for (int i = 0; i < k; i++) {
            if(boys.contains(s.charAt(i))){
                cnt++;
            }
        }

        for (int i = k; i < s.length(); i++) {
            if(boys.contains(s.charAt(i))){
                cnt--;
            }
        }
        return cnt == 0;
    }
}