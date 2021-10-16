package com.heicheoa.jiwen;

public class _002_StringProblem1 {
    // 根据以下算法处理string：
    // 1） if s.length < 3, return
    // 2)  if s.length > 3, split into multiple substring, each length == 3 (except the last one)
    // 3)  replace every substring with the sum of every digit, continue with 2) until 1)
    // Ex. str = "11122223445"
    //       -> "111" "222" "234" "45"
    //       -> "3"   "6"   "9"   "9"
    //       -> "3699"
    //       -> "369"  "9"
    //       ->  "18"  "9"
    //       return 189

    public static String processString(String input) {
        String current = input;
        while (current.length() > 3) {
            char[] c = current.toCharArray();
            StringBuilder sb = new StringBuilder();
            int temp = 0;
            for (int i = 0; i < c.length; i++) {
                temp += c[i] - '0';
                if (i % 3 == 2 || i == c.length - 1) {
                    sb.append(temp);
                    temp = 0;
                }
            }
            current = sb.toString();
        }

        return current;
    }

    public static void main(String[] args) {
        System.out.println(processString("11122223445"));
    }
}
