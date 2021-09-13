package com.leetcode.jiwen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1348_TweetCountsPerFrequency {

    private final Map<String, List<Integer>> map;
    private final static Map<String, Integer> freqMap = new HashMap<String, Integer>() {{
        put("minute", 60);
        put("hour", 3600);
        put("day", 86400);
    }};

    public _1348_TweetCountsPerFrequency() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        List<Integer> currentList;

        if (map.containsKey(tweetName)) {
            currentList = map.get(tweetName);
            int index = binarySearch(currentList, time);
            currentList.add(index, time);
        } else {
            currentList = new ArrayList<>();
            currentList.add(time);
            map.put(tweetName, currentList);
        }

    }


    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> result = new ArrayList<>();
        List<Integer> timeline = map.get(tweetName);
        
        if (timeline == null) {
            return result;
        }
        
        List<Integer> intervalPoints = getIntervalPoints(freq, startTime, endTime);

        for (int i = 0; i < intervalPoints.size() - 1; i = i + 2) {
            int startIndex = binarySearch(timeline, intervalPoints.get(i));
            int endIndex = binarySearch(timeline, intervalPoints.get(i + 1));
            result.add(endIndex - startIndex);
        }
        
        return result;

    }

    private List<Integer> getIntervalPoints(String freq, int startTime, int endTime) {
        List<Integer> result = new ArrayList<>();
        result.add(startTime);

        int interval = freqMap.get(freq);
        int intervalEnd = startTime + interval - 1;
        int intervalStart = intervalEnd + 1;

        while (intervalEnd < endTime) {
            result.add(intervalEnd);
            result.add(intervalStart);
            intervalEnd += interval;
            intervalStart = intervalEnd + 1;
        }

        result.add(endTime);
        return result;
    }

    private int binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (target <= list.get(start)) {
            return start;
        } 
        
        if (target > list.get(start) && target <= list.get(end)) {
            return end;
        }
        
        return end + 1;

    }

}
