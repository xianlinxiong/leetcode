package leetcode.panda.chapter0406;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[][] people =
                {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(s.reconstructQueue(people));
    }

    //单调栈
    public int[][] reconstructQueue(int[][] people) {
        int minIndex;
        int start = 0;
        for (int i = 0; i < people.length; i++) {
            minIndex = i;
            int j = i+1;
            for (; j < people.length; j++) {
                if (people[j][1] < people[minIndex][1] || people[j][1] == people[minIndex][1] && people[j][0] < people[minIndex][0]) {
                    minIndex = j;
                }

            }
            swap(people[i], people[minIndex]);
            start =0;
            int cnt = people[i][1];
            for (; start < i; start++) {
                if (people[start][0] < people[i][0]) {
                }else{
                    if(cnt ==0){
                        break;
                    }
                    cnt--;
                }
            }
            for (int k = i; k > start; k--) {
                swap(people[k], people[k - 1]);
            }
        }


        return people;
    }

    private void swap(int[] first, int[] second) {
        int temp = first[0];
        first[0] = second[0];
        second[0] = temp;
        temp = first[1];
        first[1] = second[1];
        second[1] = temp;
    }


}