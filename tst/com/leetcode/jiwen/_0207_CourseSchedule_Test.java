package com.leetcode.jiwen;

public class _0207_CourseSchedule_Test {


    public static void main(String[] args) {
        _0207_CourseSchedule myClass = new _0207_CourseSchedule();
        int numberCourses = 8;
        int[][] prerequisites = new int[][]
                {
                        {1, 0},
                        {2, 6},
                        {1, 7},
                        {5, 1},
                        {6, 4},
                        {7, 0},
                        {0, 5},

                };

        System.out.println(myClass.canFinish2(numberCourses, prerequisites));
    }

}
