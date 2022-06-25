package com.company;

public class MaximumSubArray {

    public static int maxSubArray() {

        int[] nums = new int[] {5,4,-1,7,8};
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        System.out.println(maxSum);
        return maxSum;



    }
}
