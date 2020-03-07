package leetcode.panda.chapter0020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 进阶：标记位扫描，防止重复循环
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};


    }

    public boolean isValid(String s) {
        List<Character> list = new ArrayList<>();

        int length = s.length();
        for(int i = 0; i< length; i++){
            char ch = s.charAt(i);
            if(isBegin(ch)){
                list.add(ch);
            }
            else if(isEnd(ch)){
                if(list.size() <= 0){
                    return false;
                }
                if(!judgeMatch(list.remove(list.size()-1), ch)){
                    return false;
                }
            }
        }
        return list.size()==0;
    }

    private boolean isBegin(char c){
        return "{([".indexOf(c)!=-1;
    }

    private boolean isEnd(char c){
        return "})]".indexOf(c)!=-1;
    }

    private boolean judgeMatch(char begin, char end){
        return (begin == '{' && end == '}') || (begin == '(' && end == ')') || (begin =='[' && end ==']');
    }
}
