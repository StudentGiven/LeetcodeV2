package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0981_TimeBasedKeyValueStore {

    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */

    class Node {
        String value;
        int timestamp;
        Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Node>> map;

    /** Initialize your data structure here. */
    public _0981_TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList());
        map.get(key).add(new Node(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Node> nodes = map.get(key);
        if (nodes == null) {
            return "";
        }

        int left = 0;
        int right = nodes.size() - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            Node node = nodes.get(mid);
            if (node.timestamp == timestamp) {
                return node.value;
            } else if (node.timestamp < timestamp) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nodes.get(right).timestamp <= timestamp) {
            return nodes.get(right).value;
        } else if (nodes.get(left).timestamp <= timestamp) {
            return nodes.get(left).value;
        }

        return "";
    }
}
