package Day2;

// Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

// According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

 

// Example 1:

// Input: citations = [3,0,6,1,5]
// Output: 3
// Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
// Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
// Example 2:

// Input: citations = [1,3,1]
// Output: 1
 

// Constraints:

// n == citations.length
// 1 <= n <= 5000
// 0 <= citations[i] <= 1000
import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // 0 1 3 5 6
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i; // 나를 포함해 뒤에 남은 논문의 개수
            if (citations[i] >= h) { // 인용 횟수가 남은 개수보다 크거나 같으면
                return h; // 그 개수가 H-Index
            }
        }
        return 0;
    }
}