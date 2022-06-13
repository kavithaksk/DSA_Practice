package com.company;

import java.util.Arrays;

public class FindFirstMissingPositiveNumber {

    public static int findFirstMissingPositive() {

        int[] nums = {3, 4, -1, 1};

        int missingNum = 0;
        int firstPostiveNumberIndexInArray = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                firstPostiveNumberIndexInArray = i;
                break;
            }
        }
        int count = 0;
        if (nums[firstPostiveNumberIndexInArray] != 1)
            missingNum = 1;
        else {
            for (int i = firstPostiveNumberIndexInArray; i < nums.length - 1; i++) {
                int diff = Math.abs(nums[i + 1] - nums[i]);
                if (diff > 1) {
                    missingNum = nums[i] + 1;
                    break;
                }
                count++;
            }
            if (count == nums.length - firstPostiveNumberIndexInArray - 1)
                missingNum = nums[nums.length - 1] + 1;
        }
        return missingNum;
    }
}
