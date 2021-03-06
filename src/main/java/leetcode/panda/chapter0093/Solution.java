package leetcode.panda.chapter0093;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * <p>
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("010010"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> lst = new ArrayList<>();

        for (int i = 0; i < 3 && i < s.length() - 3; i++) {
            for (int j = i + 1; j < i + 4 && j < s.length() - 2; j++) {
                for (int k = j + 1; k < j + 4 && k < s.length() - 1; k++) {
                    if (isIp(s.substring(0, i + 1)) && isIp(s.substring(i + 1, j + 1)) && isIp(s.substring(j + 1, k + 1)) && isIp(s.substring(k + 1))) {
                        lst.add(s.substring(0, i + 1) + "." + s.substring(i + 1, j + 1) + "." + s.substring(j + 1, k + 1) + "." + s.substring(k + 1));
                    }
                }
            }
        }
        return lst;
    }

    private boolean isIp(String s) {
        if (s.length() == 0 || s.length()>3) {
            return false;
        } else if (s.length() == 1) {
            return true;
        } else {
            int ip = Integer.parseInt(s);
            return ip <= 255 && ip >= Math.pow(10, s.length() - 1);
        }
    }


}