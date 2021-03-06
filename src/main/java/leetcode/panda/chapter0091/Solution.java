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
        System.out.println(s.numDecodings("123123"));
    }

    public int numDecodings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int cur = 0;
        for (; cur < s.length(); cur++) {
            if (s.charAt(cur) != '0') {
                break;
            }
        }
        if (0 != cur) {
            return 0;
        }
        int l = 1;
        int r = 1;
        cur++;
        for (; cur < s.length(); cur++) {
            int k = s.charAt(cur) - '0';
            int m = s.charAt(cur - 1) - '0';
            if (k > 0) {
                if (m * 10 + k <= 26 && m * 10 + k >10) {
                    int t = r;
                    r += l;
                    l = t;
                } else if(m*10+k <10) {
                    r=l;
                }else{
                    l=r;
                }
            }else{
                r=l;
                if(m!=1 && m !=2){
                    return 0;
                }
            }
        }

        return r;
    }

}