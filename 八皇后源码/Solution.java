package com.eh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaasdasdasd";
        int i = s.indexOf("a", 0);
        System.out.println(i);
    }

    HashSet<String> set;
    HashSet<String> visited = new HashSet<>();
    List<String> result = new ArrayList<>();

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        result.add(beginWord);
        visited.add(beginWord);
        set = new HashSet<>(wordList);
        return dfs(beginWord, endWord) ? result : new ArrayList<>();
    }

    public boolean dfs(String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            return true;
        } else {
            char[] chars = beginWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == temp) continue;
                    chars[i] = c;
                    String string = chars.toString();
                    if (set.contains(string) && !visited.contains(string)) {
                        // 如果字典里面包含该字符串
                        visited.add(string);
                        result.add(string);
                        if (dfs(string, endWord)) return true;
                        result.remove(result.size() - 1);
                    }
                }
                chars[i] = temp;
            }
            return false;
        }
    }
}
