package Day7;
// Easy

// Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

// Example 1:

// Input: nums = [1,2,3,1], k = 3
// Output: true
// Example 2:

// Input: nums = [1,0,1,1], k = 1
// Output: true
// Example 3:

// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
 

// Constraints:

// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109
// 0 <= k <= 105
import java.util.*;
public class ContainsDuplicateII_219 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int k1 = 3;
        int[] nums2 = {1,0,1,1};
        int k2 = 1;
        int[] nums3 = {1,2,3,1,2,3};
        int k3 = 2;
        System.out.println(containsNearbyDuplicate(nums1, k1));
        System.out.println(containsNearbyDuplicate(nums2, k2));
        System.out.println(containsNearbyDuplicate(nums3, k3));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // 값 -> 인덱스
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // 최신 인덱스로 업데이트(그래야 다음 번에 거리가 최소가 됨)
            map.put(nums[i], i);
        }
        return false;
    }
}
