package com.heicheoa.jiwen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _003_MatrixDiameter {

    // 给一个Matrix, 找出所有radius = k 的sum的三个最大值
    // radius的定义是向上下左右辐射k个距离的菱形
    // Ex. [1, 2, 3, 9, 0,
    //      0, 1, 2, 3, 5,
    //      3, 4, 5, 6, 7]
    // k = 1 的菱形是
    //     2        3        9
    //   0 1 2    1 2 3    2 3 5
    //     4        5        6
    // 求出所有菱形的sum, 返回最大的三个
    //
    // 思路：只从原矩阵的上下左右边界缩减k之后的小矩阵之中遍历，写一个计算菱形和的函数进行计算，结果存在PQ里最后pop3个

    public static List<Integer> findMaxSum(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> result = new ArrayList<>();
        for (int i = k; i < row - k; i++) {
            for (int j = k; j < col - k; j++) {
                int sum = findSum(matrix, i, j, k);
                maxHeap.offer(sum);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (maxHeap.peek() != null) {
                result.add(maxHeap.poll());
            }
        }

        return result;
    }

    private static int findSum(int[][] matrix, int x, int y, int k) {
        // central point is (x, y)
        int sum = 0;
        for (int i = x - k; i <= x + k; i++) {
            sum+= matrix[i][y];
        }
        for (int j = y - k; j <= y + k; j++) {
            sum+= matrix[x][j];
        }
        sum -= matrix[x][y];  // Added twice, need to delete one
        return sum;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 9, 0},
                         {0, 1, 2, 3, 5},
                         {3, 4, 5, 6, 7}};
        System.out.println(findMaxSum(input, 1));
    }
}
