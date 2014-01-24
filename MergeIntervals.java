// wrong answer first trial
public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Interval> ret = new ArrayList<Interval>();
        if(intervals==null)  return ret;
        if(intervals.size()<2)  return intervals;
        // sort by start value
        sort(intervals);
        Interval first = intervals.get(0);
        // get first interval
        int start = first.start, end = first.end;
        for(int i=1; i<intervals.size(); i++)  {
            Interval curr = intervals.get(i);
            // no overlapping
            if(end < curr.start)  {
                ret.add(new Interval(start,end));
                start = curr.start;
                end = curr.end;
            }
            // find new end point
            else  {
                end = Math.max(end,curr.end);
            }
        }
        // add last interval
        ret.add(new Interval(start,end));
        return ret;
    }
    // n2 sort
    public void sort(ArrayList<Interval> intervals)  {
        int size = intervals.size();
        for(int i=0; i<size; i++)  {
            for(int j=i+1; j<size; j++)  {
                // swap required
                if(intervals.get(j).start<intervals.get(i).start)  {
                    Interval tmp = intervals.get(j);
                    intervals.set(j, intervals.get(i));
                    intervals.set(i, tmp);
                }
            }
        }
    }
}
