package leetcode.panda.chapter0005;

public class Solution {
    //以每个位置点作为中心或者对称起点寻找回文
    public static String longestPalindrome(String s) {
        String result ="";
        int size = s.length();
        for(int i = 0; i < size; i++){
            String ss = indexMiddle(s, i);
            if(result.length() < ss.length()){
                result = ss;
            }
            ss = inMiddle(s, i);
            if(result.length() < ss.length()){
                result = ss;
            }
        }
        return result;
    }

    //以当前位置为中心寻找回文
    static String indexMiddle(String s, int index){
        int begin = index -1;
        int end = index + 1;
        while(begin >= 0 && end <s.length()){
            if(s.charAt(begin) == s.charAt(end)){
                begin--;
                end++;
            }
            else{
                break;
            }
        }
        begin++;
        return s.substring(begin, end);
    }

    //以当前位置和下一位置对称作为匹配
    static String inMiddle(String s, int index){
        int begin = index;
        int end = index + 1;
        while(begin >= 0 && end <s.length()){
            if(s.charAt(begin) == s.charAt(end)){
                begin--;
                end++;
            }
            else{
                break;
            }
        }
        if(begin < index){
            begin++;
        }
        return s.substring(begin, end);
    }
}
