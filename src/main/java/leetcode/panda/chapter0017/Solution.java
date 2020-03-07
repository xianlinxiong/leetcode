package leetcode.panda.chapter0017;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 进阶：水平扫描，垂直扫描，分段查询，最短字符串二分扫描
 */
public class Solution {
    public static void main(String[] args) {

        String[] ss = {"dog", "racecar", "car"};
        int[] ii ={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        char[][] dd = {
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        List<StringBuilder> list = new ArrayList<>();
        int size = digits.length();
        for(int i = 0; i< size; i++){
            char[] c = dd[Integer.parseInt(digits.substring(i, i+1))];
            List<StringBuilder> temp = new ArrayList<>();
            for(int j =0; j<c.length; j++){
                if(list.size() == 0){
                    StringBuilder nb = new StringBuilder();
                    nb.append(c[j]);
                    temp.add(nb);
                    continue;
                }
                for(int k =0; k< list.size(); k++){
                    StringBuilder nb = new StringBuilder();
                    StringBuilder sb =list.get(k);
                    nb.append(sb).append(c[j]);
                    temp.add(nb);
                }
            }
            list = temp;
        }
        return list.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }
}
