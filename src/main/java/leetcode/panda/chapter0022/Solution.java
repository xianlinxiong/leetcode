package leetcode.panda.chapter0022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 进阶：标记位扫描，防止重复循环
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));

    }

    public static List<String> generateParenthesis(int n) {
        if(n <= 0){
            return Collections.emptyList();
        }
        return generate(0, 0, n);
    }

    private static List<String> generate(int left, int right, int total){
        List<String> results = new ArrayList<>();
        if(left == total){
            String s = "";
            while(right < total){
                s += ")";
                right++;
            }
            results.add(s);
            return results;
        }
        if(left == right){
            results = generate(left+1, right, total);
            return results.stream()
                    .map(s -> "("+s)
                    .collect(Collectors.toList());
        }
        List<String> l1 = generate(left+1, right, total)
                .stream()
                .map(s -> "("+s)
                .collect(Collectors.toList());
        List<String> l2 = generate(left, right+1, total)
                .stream()
                .map(s -> ")"+s)
                .collect(Collectors.toList());
        results.addAll(l1);
        results.addAll(l2);
        return results;
    }

}
