package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicatesInAnArray {


    public static void removeDuplicates()
    {
        int[] nums = new int[] { 0, 2, 3, 2, 4, 5, 6, 3, 4};
        List<Integer> list = new ArrayList<>();

        int k = 1;
//        for(int i = 0; i < nums.length; i++)
//        if (!list.contains(nums[i]))
//            list.add(nums[i]);
//
//        int[] result = new int[list.size()];
//        for(int i = 0; i < list.size(); i++) {
//            result[i] = list.get(i);
//            System.out.println(result[i]);
//        }

        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++)
        {
            if (nums[i] != nums[i-1])
                nums[k++] = nums[i];
        }
        for (int i = 0; i < k; i++)
            System.out.println(nums[i]);
    }
}
