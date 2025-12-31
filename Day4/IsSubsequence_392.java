package Day4;
// Easy

// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

// Example 1:

// Input: s = "abc", t = "ahbgdc"
// Output: true
// Example 2:

// Input: s = "axc", t = "ahbgdc"
// Output: false
 

// Constraints:

// 0 <= s.length <= 100
// 0 <= t.length <= 104
// s and t consist only of lowercase English letters.

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sp = 0, tp = 0;

        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++; // 찾았으니 다음 글자 찾으러 이동
            }
            tp++; // t는 무조건 계속 검색
        }
        return sp == s.length(); // s를 끝까지 다 찾았는가?
    }
}