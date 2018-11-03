import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return intervals;
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.getStart() - b.getStart());
        for(Interval interval: intervals) {
            pq.offer(interval);
        }
        while(!pq.isEmpty()) {
            if(pq.size() == 1) {
                result.add(pq.poll());
                break;
            }
            Interval interval = pq.poll();
            if(interval.getEnd() >= pq.peek().getStart()) {
                interval.setEnd(Math.max(interval.getEnd(), pq.peek().getEnd()));
                pq.poll();
                pq.offer(interval);
            } else result.add(interval);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,9));
        intervals.add(new Interval(4,9));
        intervals.add(new Interval(0,3));
        intervals.add(new Interval(11,15));
        intervals = new Solution().merge(intervals);
        for(Interval interval: intervals) {
            System.out.println(interval.getStart() + "," + interval.getEnd());
        }
    }
}
