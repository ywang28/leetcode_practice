public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0)  {
            if(newInterval!=null)  ret.add(newInterval);
            return ret;
        }
        int curr = 0, size = intervals.size();
        while(curr<size)  {
            // find insert start position
            if(newInterval.start <= intervals.get(curr).end)  break;
            // add smaller intervals
            ret.add(intervals.get(curr));
            curr++;
        }
        // newinterval is less than first interval
        if(curr==0 && newInterval.end < intervals.get(curr).start)  {
            ret.add(newInterval);
            ret.addAll(intervals);
            return ret;
        }
        // newinterval is larger than last interval
        if(curr==size)  {
            ret.add(newInterval);
            return ret;
        }
        // start position
        int start = Math.min(newInterval.start, intervals.get(curr).start);
        // find out end position
        while(curr<size && newInterval.end >= intervals.get(curr).start)  curr++;
        ret.add(new Interval(start, Math.max(newInterval.end, intervals.get(curr-1).end)));
        // add remaining intervals
        for(int i=curr; i<size; i++)  {
            ret.add(intervals.get(i));
        }
        return ret;
    }
}
