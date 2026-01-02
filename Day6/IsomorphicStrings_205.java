package Day6;
// Easy

// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

// Example 1:

// Input: s = "egg", t = "add"

// Output: true

// Explanation:

// The strings s and t can be made identical by:

// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.
// Example 2:

// Input: s = "foo", t = "bar"

// Output: false

// Explanation:

// The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

// Example 3:

// Input: s = "paper", t = "title"

// Output: true

 

// Constraints:

// 1 <= s.length <= 5 * 104
// t.length == s.length
// s and t consist of any valid ascii character.

public class IsomorphicStrings_205 {
    public static void main(String[] args) {
        String s1 = "egg";
        String t1 = "add";
        String s2 = "foo";
        String t2 = "bar";
        String s3 = "paper";
        String t3 = "title";
        System.out.println(isIsomorphic(s1, t1)); // true
        System.out.println(isIsomorphic(s2, t2)); // false
        System.out.println(isIsomorphic(s3, t3)); // true
    }
    public static boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[200]; // ASCII 커버
        int[] map2 = new int[200];

        for (int i = 0; i < s.length(); i++) {
            // 이전에 기록된 인덱스가 서로 다르면 패턴 불일치
            // (0 초기값과 구분을 위해 i+1 저장)
            if (map1[s.charAt(i)] != map2[t.charAt(i)]) return false;

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
