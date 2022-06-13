package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SquaresOfASortedArray {

    int[] nums = new int[] {-4,-1,0,3,10};

    public int[] sortedSquares(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            result.add(nums[i] * nums[i]);
        }
        Collections.sort(result);
        int[] result1 = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
        {
            result1[i] = result.get(i);
        }
        return result1;

    }
}
