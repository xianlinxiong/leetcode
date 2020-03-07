package leetcode.panda.chapter0008;

class Solution {
    //主要判断是否越界
    public int myAtoi(String str) {
        int size = str.length();
        int result =0;
        int k = 1;
        boolean nonStart = true;
        boolean overflow = false;
        int i = 0;
        for(; i< size; i++){
            char ch = str.charAt(i);
            if(ch == ' ' && nonStart){
                continue;
            }
            if(ch == '-' && nonStart){
                k = -1;
                nonStart = false;
                continue;
            }
            if(ch == '+' && nonStart){
                nonStart = false;
                continue;
            }
            if(ch >= '0' && ch <= '9'){
                int t = Integer.parseInt(ch+"");
                if(maxFlow(k*result, t) || minFlow(k*result, t)){
                    overflow = true;
                    break;
                }
                result = result *10 + t;
                nonStart = false;
                continue;
            }
            else{
                break;
            }
        }
        if(overflow){
            return k==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return k * result;

    }

    //最大值越界
    boolean maxFlow(int x, int y){
        int max = Integer.MAX_VALUE/10;
        if(x > max || (x==max && y >7)){
            return true;
        }
        return false;
    }

    //最小值越界
    boolean minFlow(int x, int y){
        int min = Integer.MIN_VALUE/10;
        if(x < min || (x == min && y >8)){
            return true;
        }
        return false;
    }
}