// O(n2)  Time limit exceeded...
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null || height.length<2)  return 0;
        int area = 0;
        for(int i=0; i<height.length-1; i++)  {
            for(int j=i+1; j<height.length; j++)  {
                area = Math.max(area, Math.min(height[i],height[j]) * (j-i));
            }
        }
        return area;
    }
}
