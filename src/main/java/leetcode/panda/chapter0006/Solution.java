package leetcode.panda.chapter0006;

class Solution {
    //粗暴简单的使用多个sb接收
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sbs[i] = new StringBuilder();
        }
        int i = 0, size = s.length();
        while(i<size){
            for(int m =0; m < numRows && i < size; m++){
                sbs[m].append(s.charAt(i));
                i++;
            }
            for(int n = numRows -2; n >0 && i < size; n--){
                sbs[n].append(s.charAt(i));
                i++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : sbs){
            result.append(sb);
        }
        return result.toString();
    }
}