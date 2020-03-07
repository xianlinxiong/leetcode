package leetcode.panda.chapter0014;

/**
 * 进阶：水平扫描，垂直扫描，分段查询，最短字符串二分扫描
 */
public class Solution {
    public static void main(String[] args) {

        String[] ss = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(ss));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int size = strs.length;
        if(size == 0){
            return "";
        }
        sb.append(strs[0]);
        for(int i=1; i<size; i++){

            if(sb.length() == 0){
                break;
            }
            int length = Math.min(sb.length(), strs[i].length());
            int j =0;
            for(; j < length; j++){
                if(sb.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }

            sb.delete(j, sb.length());
        }

        return sb.toString();
    }



}
