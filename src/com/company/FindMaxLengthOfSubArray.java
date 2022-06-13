package com.company;

import java.util.Arrays;
import java.util.List;

public class FindMaxLengthOfSubArray {

    public static int findMaxLenSubarray()
    {
        // Write your code here...
        List<Integer> nums = Arrays.asList( 5, 6, -5, 5, 3, 5, 3, -2, 0);
        int target = 8;
        int sum = -1;
        int maxLengthSubArray = -1;

        for (int i = 0; i < nums.size(); i++)
        {
            sum = 0;

            for (int j = i; j < nums.size(); j++)
            {
                sum += nums.get(j);

                if (sum > target)
                    break;

                if (sum == target)
                {
                    int length = j - i + 1;
                    maxLengthSubArray = Math.max(length, maxLengthSubArray);
                }
            }
        }
        System.out.println("Max length of the subarray matching the given sum " + target + ":" + maxLengthSubArray);
        return maxLengthSubArray;
    }
}
