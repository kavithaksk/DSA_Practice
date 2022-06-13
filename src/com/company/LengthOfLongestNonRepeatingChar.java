package com.company;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestNonRepeatingChar {

    public static  int lengthOfLongestNonRepeatingChar() {

        String s = "GEEKSFORGEEKS";

        Set<Character> hashSet = new HashSet<>();
        int nonRepeatingCharCount = 0;
        int longestRepeatingCount = 0;
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            nonRepeatingCharCount = 0;
            hashSet.clear();
            for (int j = i; j < s.length(); j++) {
                Character ch = s.charAt(j);
                if (!hashSet.contains(ch)) {
                    hashSet.add(ch);
                    nonRepeatingCharCount++;
                } else {
                    startIndex = i;
                    endIndex = j - 1;
                    break;
                }
            }
            if (longestRepeatingCount < nonRepeatingCharCount) {
                longestRepeatingCount = nonRepeatingCharCount;

            }
        }
        System.out.println("start Index --> " + startIndex + "emd index-->" + endIndex);
        System.out.println(longestRepeatingCount);
        System.out.println("Longest substring between start index & end index:" + s.substring(startIndex, endIndex));
        return longestRepeatingCount;
    }

}
