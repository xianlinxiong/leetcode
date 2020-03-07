package leetcode.panda.chapter0091;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.numDecodings("01"));
    }

    public int numDecodings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int last = 0;
        int second = 0;
        int cur = s.length() - 1;
        if (s.charAt(cur) != '0') {
            second = 1;
        }
        cur--;
        while (cur >= 0) {
            int tmp = 0;

            int x = Integer.parseInt(s.substring(cur, cur + 2));
            if (s.charAt(cur) == '0') {
                if (x == 0) {
                    return 0;
                }
                tmp = last;
            } else {
                tmp += second;
                if (x < 27 && x >= 10) {
                    tmp += last == 0 ? 1 : last;
                }
            }

            last = second;
            second = tmp;
            cur--;
        }
        return second;
    }

    public int numDecodings2(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        return doDecoding(s, 0);
    }

    private int doDecoding(String s, int start) {
        if (start == s.length()) {
            return 1;
        }
        if (start == s.length() + 1 || s.charAt(start) == '0') {
            return 0;
        }
        int r = doDecoding(s, start + 1);
        if (start + 1 < s.length() && Integer.parseInt(s.substring(start, start + 2)) < 27) {
            r += doDecoding(s, start + 2);
        }
        return r;

    }

}