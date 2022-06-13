package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSum {

    public static List<List<Integer>> CombinationSumII(int[] candidates, int target) {
        /* 10, 1, 2, 7, 6, 1, 5 ,  target = 8.
        /* [1, 7], [2, 6], [1, 1, 6], [2, 1, 5] */
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> interimResults = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            int diff = target - candidates[i];
            if (diff < 0) continue;
            else {
                int searchResult = Arrays.binarySearch(candidates, diff);
                if (searchResult > 0) {
                    if (!interimResults.contains(candidates[i]) && !interimResults.contains(candidates[searchResult])) {
                        interimResults.add(candidates[i]);
                        interimResults.add(candidates[searchResult]);

                        //interimResults.clear();
                    }
                }
            }
            result.add(interimResults);
        }
        for (List<Integer> i : result) {
            System.out.println(i);
        }

//        for(Map.Entry<Integer, Integer> hashMapValues : initalPairMap.entrySet())
//            System.out.println("Key--> " +hashMapValues.getKey() + "Values -->" +hashMapValues.getValue());

        return result;
    }
}
