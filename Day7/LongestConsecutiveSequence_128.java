package Day7;
// Medium

// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

 

// Example 1:

// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:

// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
// Example 3:

// Input: nums = [1,0,1,2]
// Output: 3
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
import java.util.*;
public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int[] nums1 = {100,4,200,1,3,2};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums3 = {1,0,1,2};
        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums2));
        System.out.println(longestConsecutive(nums3));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 0;

        for (int num : set) {
            // 내 앞의 숫자(num-1)가 없어야 내가 시퀀스의 시작점
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }
}
