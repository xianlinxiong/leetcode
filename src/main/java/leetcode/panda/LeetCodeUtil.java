package leetcode.panda;

import java.util.Arrays;

public class LeetCodeUtil {

    public static void outputArray(int[] array){
        System.out.print("[");
        for(int i : array){
            System.out.print(i+",");
        }
        System.out.println("]");
    }

    public static void outputArray(char[][] array){
        System.out.print("[");
        for(char[] i : array){
            System.out.print("[");
            for(char j : i){
                System.out.print(j+",");
            }

            System.out.print("],");
        }
        System.out.println("]");
    }

    public static void outputArray(boolean[][] array){
        System.out.print("[");
        for(boolean[] i : array){
            System.out.print("[");
            for(boolean j : i){
                System.out.print(j+",");
            }

            System.out.println("],");
        }
        System.out.println("]");
    }

    public static boolean equeal(char[] ch, char[] c){
        return Arrays.equals(c,ch);
    }
}
