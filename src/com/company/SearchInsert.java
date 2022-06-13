package com.company;

public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        int mid = 0;

        while (low < high)
        {
            mid = low + (high - low) / 2;

            if (nums[mid] == target)
            {
                index = mid;
                break;
            }

            if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;

        }

        if (index != -1)
            return index;

        else
        {

            if (target < nums[mid])
                index = mid;
            else
                index = mid + 1;
        }
        return index;



    }
}
