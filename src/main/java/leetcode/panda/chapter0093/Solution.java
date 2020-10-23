package leetcode.panda.chapter0093;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 *  
 */

class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> lst = new ArrayList<>();
        doRestore(s, "", 0, 1, lst);
        return lst;

    }

    private void doRestore(String s, String  cur, int begin, int position, List<String> list){
        if(position == 4 ){
            if(s.length()-begin < 4 && isIp(s.substring(begin))){
                list.add(cur+s.substring(begin));
            }
        }else{
            for(int i=1; i <= 3; i++){
                if(isIp(s.substring(begin, begin+i))) {
                    doRestore(s, cur + s.substring(begin, begin+i)+",", begin+i, position + 1, list);
                }
            }
        }
    }

    private boolean isIp(String s){
        int ip = Integer.parseInt(s);
        return ip >=0 && ip <= 255;
    }
}