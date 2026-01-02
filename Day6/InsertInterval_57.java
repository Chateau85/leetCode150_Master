package Day6;
// MEdium

// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

// Note that you don't need to modify intervals in-place. You can make a new array and return it.

// Example 1:

// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

// Constraints:

// 0 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 105
// intervals is sorted by starti in ascending order.
// newInterval.length == 2
// 0 <= start <= end <= 105
import java.util.*;
class InsertInterval_57 {
    public static void main(String[] args) {
        int[][] intervals1 = {
            {1,3},
            {6,9}
        };
        int[] newInterval1 = {2,5};
        int[][] intervals2 = {
            {1,2},
            {3,5},
            {6,7},
            {8,10},
            {12,16}
        };
        int[] newInterval2 = {4,8};
        System.out.println(Arrays.deepToString(insert(intervals1, newInterval1))); // [[
        System.out.println(Arrays.deepToString(insert(intervals2, newInterval2))); // [[1,2],[3,10],[12,16]]
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. 겹치기 전(새 구간 시작보다 현재 구간 끝이 작음)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // 2. 겹치는 구간(새 구간 끝보다 현재 구간 시작이 작음) -> 병합
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // 병합된 새 구간 추가

        // 3. 겹치고 난 후 나머지
        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}

