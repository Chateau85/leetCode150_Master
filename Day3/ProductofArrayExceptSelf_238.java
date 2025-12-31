package Day3;
// Medium

// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]
 

// Constraints:

// 2 <= nums.length <= 105
// -30 <= nums[i] <= 30
// The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] answer = new int[l];

        // 1. Left Pass: answer[i]에 i 왼쪽까지의 곱 저장
        answer[0] = 1;
        for (int i = 1; i < l; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        // 2. Right Pass: 오른쪽 곱을 누적하여 answer에 곱해줌
        int right = 1;
        for (int i = l - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i]; // 오른쪽 곱 업데이트
        }
        return answer;
    }
}