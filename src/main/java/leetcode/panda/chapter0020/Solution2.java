package leetcode.panda.chapter0020;

import java.util.Stack;

class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch =='(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.empty()){
                    return false;
                }
                Character c = stack.pop();
                if(!judge(c, ch)){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private boolean judge(Character ch, char c){
        if(ch == null){
            return false;
        }
        return (ch == '{' && c =='}') || (ch == '(' && c ==')') ||(ch == '[' && c ==']');
    }
}
