package com.company;

public class TrappingWaterProblem {

    public static int trap()
    {
        /* { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5} */
        int[] heights = new int[] { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        // maintain two pointers left and right, pointing to the leftmost and
        // rightmost index of the input array
        int left = 0, right = heights.length - 1, water = 0;

        int maxLeft = heights[left];
        int maxRight = heights[right];

        // { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 }
        while (left < right)
        {
            if (heights[left] <= heights[right])
            {
                left++;
                maxLeft = Integer.max(maxLeft, heights[left]);
                water += (maxLeft - heights[left]);
            }
            else {
                right--;
                maxRight = Integer.max(maxRight, heights[right]);
                water += (maxRight - heights[right]);
            }
        }

        System.out.println("Area of the container : "  +water);
        return water;
    }

    /* container with most water */
    public static int maxArea() {

        int A[] =  new int[] { 1,8,6,2,5,4,8,3,7};
        int l = 0;
        int r = A.length- 1;
        int area = 0;

        while (l < r) {
            int base = Math.min(A[l], A[r]) * (r - l);
            System.out.println(base);
            // Calculating the max area
            area = Math.max(area, base);

            if (A[l] < A[r])
                l += 1;

            else
                r -= 1;
        }
        System.out.println("Max area is " +area);
        return area;
    }
}
