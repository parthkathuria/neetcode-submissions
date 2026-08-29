/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals.get(0).end);
        int maxRooms = 1;
        for (int i = 1; i < intervals.size(); i++) {
            Interval currInt = intervals.get(i);
            while (!minHeap.isEmpty() && minHeap.peek() <= currInt.start) {
                minHeap.poll();
            }
            minHeap.add(currInt.end);
            maxRooms = Math.max(maxRooms, minHeap.size());
        }

        return maxRooms;
    }
}
