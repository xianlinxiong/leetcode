package leetcode.panda.chapter0605;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 0, 1, 0, 1, 0, 1};
        System.out.println(s.canPlaceFlowers(nums, 2));

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            return n > 1 ? false : flowerbed[0] == 0 || n == 0;
        }
        int i = 1;
        if (flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
            i++;
            n--;
        }
        int len = flowerbed.length - 1;
        for (; i < len && n > 0; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                i++;
                n--;
            }
        }
        if (i == len && flowerbed[len - 1] == 0 && flowerbed[len] == 0) {
            n--;
        }

        return n <= 0;

    }
}