public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null || height.length<2)  return 0;
        int max = 0, start  =0, end = height.length-1;
        while(start<end)  {
            // low height will be limiting factor
            if(height[start]<height[end])  {
                max = Math.max(max, height[start] * (end-start));
                start++;
            }
            else  {
                max = Math.max(max, height[end] * (end-start));
                end--;
            }
        }
        return max;
    }
}
