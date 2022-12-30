public class LC42 {

    public static void main(String[] args) {
        System.out.println(trappingWater(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trappingWater(new int[] {4,2,0,3,2,5}));

    }

    //Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
    //
    //
    //
    //Example 1:
    //
    //
    //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    //Output: 6
    //Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
    //Example 2:
    //
    //Input: height = [4,2,0,3,2,5]
    //Output: 9
    //
    //
    //Constraints:
    //
    //n == height.length
    //1 <= n <= 2 * 104
    //0 <= height[i] <= 105
    //Explantion--
    //Imagine we start from the left and right boundaries of our box, and in our box to get from one end to the other we have
    //to climb over different sized vertical walls
    //between our walls, its possible that water is stuck between them if the height differences allow for it
    //If we want to calculate all the water in our box, we could imagine shrinking the left and right boundaries together until
    //they meet each other while squeezing all the water out at the same time and putting it in a bucket
    //at the end all the water that has been squeezed out and put into our bucket is our result
    //So we create pointers starting from both ends and start shrinking our box and squeezing water out
    // we only calculate what is in front of our pointers, as behind doesnt matter as we update our pointers to the highest walls
    //when our pointers meet, if everything worked well, we will have squeezed all the water out.

    public static int trappingWater(int[] heights){
        int left = 0;
        int right = heights.length - 1;

        int ans = 0;

        int maxLeft = heights[left];
        int maxRight = heights[right];

        while(left < right){
            if(heights[left] >= maxLeft){
                maxLeft = heights[left];
            } else{
                ans += maxLeft - heights[left];
            }

            if(heights[right] >= maxRight){
                maxRight = heights[right];
            }else{
                ans += maxRight - heights[right];
            }

            if(maxLeft > maxRight){
                right--;
            }else{
                left++;
            }
        }
        return ans;
    }
}
