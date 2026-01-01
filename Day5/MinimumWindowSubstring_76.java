package Day5;
// Hard

// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

 

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
 

// Constraints:

// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.

import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) target.put(c, target.getOrDefault(c, 0) + 1);

        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int matched = 0; // 유효한 문자 개수(t의 unique 문자 수와 비교)

        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            // 필요한 문자의 개수를 정확히 맞췄을 때 matched 증가
            if (target.containsKey(rightChar) && window.get(rightChar).intValue() == target.get(rightChar).intValue()) {
                matched++;
            }

            // 모든 문자가 충족되면, left를 줄여가며 최소화 시도
            while (matched == target.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                // left 문자를 뺄 때 조건이 깨지는지 확인
                if (target.containsKey(leftChar)) {
                    if (window.get(leftChar).intValue() == target.get(leftChar).intValue()) {
                        matched--;
                    }
                }
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}