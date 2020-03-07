package leetcode.panda.chapter0028;

/**
 * 进阶:双重for循环， kmp（待进阶）
 *
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(strStr("hello", "hello"));
    }
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() ==0){
            return 0;
        }
        if(haystack == null || haystack.length() == 0 || haystack.length() < needle.length()){
            return -1;
        }
        int length = haystack.length() - needle.length()+1;
        int index = -1;
        for(int i = 0; i< length; i++){
            int j = 0;
            for(int k =i; j< needle.length(); k++,j++){
                if(haystack.charAt(k)!= needle.charAt(j)){
                    break;
                }
            }
            if(j == needle.length()){
                index = i;
                break;
            }

        }

        return index;
    }
}
