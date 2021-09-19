package com.juyingoa.jiwen;

import java.util.List;

public class _005_MaximumLengthOfUniqueChars {

    // Leetcode 1239
    public int maxLength(List<String> arr) {
        int[] result = new int[1];
        dfs(arr, 0, "", result);

        return result[0];
    }

    public void dfs(List<String> arr, int index, String current, int[] result) {
        if (index == arr.size() && uniqueCharCount(current) > result[0]) {
            result[0] = current.length();
            return;
        }

        if (index == arr.size()) {
            return;
        }

        dfs(arr, index + 1, current, result);
        dfs(arr, index + 1, current + arr.get(index), result);
    }

    private int uniqueCharCount(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            if (counts[c - 'a']++ > 0) {
                return -1;
            }
        }

        return s.length();
    }






    /*

    var maxLength = function(arr) {
        let maxLen = 0;
        let listOfStrs = [];
        arr = arr.filter(isUnique);
        let mem = {};
        maxLen = dfs(arr, "", 0, maxLen, mem);

        return maxLen;
    };

    function dfs(arr, path, i, maxLen, mem) {
        if (mem[path]) return mem[path];
        let pathIsUnique = isUnique(path);
        if (pathIsUnique) {
            maxLen = Math.max(path.length, maxLen);
        }
        if (i === arr.length || !pathIsUnique) {
            mem[path] = maxLen;
            return maxLen;
        }
        for (let j = i; j < arr.length; j++) {
            maxLen = dfs(arr, path + arr[j], j + 1, maxLen, mem);
        }


        mem[path] = maxLen;
        return maxLen;
    }

    function isUnique(str) {
    const map = {}
        for (let i = 0; i < str.length; i++) {
            if (map[str[i]]) return false;
            map[str[i]] = 1;
        }

        return true;
    }

    */

}
