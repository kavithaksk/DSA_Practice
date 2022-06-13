package com.company;

import java.util.Arrays;

public class findLastStoneWeight {

    public void findLastStoneWeight(Integer[] stones) {

        int count = stones.length;

        while (count > 1) {
            Arrays.sort(stones); // 1, 1, 2, 4, 7, 8 //1,1,1,2,4
            int firstBig = stones[count - 1];
            int nextBig = stones[count - 2];

            if (firstBig == nextBig) {
                count = count - 2;
            } else {
                count = count - 1;
                stones[count - 1] = firstBig - nextBig; // 1,1,2,4,1 //1,1,1,2 //1,1,1
            }
        }
        if (count == 1)
            System.out.println("Last stone weight :" + stones[count - 1]);
    }

}
