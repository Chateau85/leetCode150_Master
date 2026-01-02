package Day6;
// Medium

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// Example 3:

// Input: intervals = [[4,7],[1,4]]
// Output: [[1,7]]
// Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
import java.util.*;
class Solution_56 {
    public static void main(String[] args) {
        int[][] intervals1 = {
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };
        int[][] intervals2 = {
            {1,4},
            {4,5}
        };
        int[][] intervals3 = {
            {4,7},
            {1,4}
        };
        System.out.println(Arrays.deepToString(merge(intervals1))); // [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(merge(intervals2))); // [[1,5]]
        System.out.println(Arrays.deepToString(merge(intervals3))); // [[1,7]]
    }
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // 1. 시작점 기준 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int[] interval : intervals) {
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) { // 겹침 -> 합치기
                current[1] = Math.max(currentEnd, nextEnd);
            } else { // 안 겹침 -> 새로 등록
                current = interval;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
