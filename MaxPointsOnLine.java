// wrong answer
public class MaxPointsOnLine {
    public int maxPoints(Point[] points) {
        if(points==null || points.length==0)  return 0;
        if(points.length==1)  return 1;
        // use ret to record number of points in vertical line. (x1==x2)
        int ret = 0, len = points.length;
        for(int i=0; i<len-1; i++)  {
            // count is number of point in a line containing point[i]
            // duplicates records number of duplicate points with point[i]
            int count = 1, duplicates = 0;
            HashMap<Double,Integer> slopes = new HashMap<Double,Integer>();
            for(int j=i+1; j<len; j++)  {
                if(points[i].x == points[j].x)  {
                    // duplicate point found
                    if(points[i].y == points[j].y)  {
                        duplicates++;
                    }
                    // consider slope infinite case
                    else  {
                        count++;
                    }
                    continue;
                }
                double slope = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                if(slopes.containsKey(slope))  {
                    slopes.put(slope, slopes.get(slope)+1);
                }
                else  {
                    slopes.put(slope,2);
                }
            }
            // fix corner case:  only duplicates exist
            count += duplicates;
            // find max number of points in a line containing i point
            for(int cnt: slopes.values())  {
                count = Math.max(count, cnt + duplicates);
            }
            ret = Math.max(ret, count);
        }
        return ret;
    }
}
