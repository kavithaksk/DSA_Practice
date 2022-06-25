package com.company;

import java.util.Arrays;

public class LongestStringChain {

    public static int longestStrChain() {

        String words[] = new String[] {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        int count = 1;

        for(int i = 0; i < words.length; i++) {
            int min = i;
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].length() < words[min].length())
                    min = j;
            }

            String temp = words[i];
            words[i] = words[min];
            words[min] = temp;

        }

        int i = 0;
        int j = i + 1;

        {
            while (j < words.length)
            {
                if (words[i].length() != words[j].length())
                {
                    int matchingDiff = isPredecessor(words[i], words[j]);
                    if (matchingDiff == 1)
                    {
                        i = j;
                        count++;
                    }
                }
                j++;

            }

        }

        return count;
    }

    private static int isPredecessor(String a, String b)
    {
        int i = 0, j = 0;
        int count = 0;
        while(i < b.length() && j < a.length())
        {
            if (a.charAt(j) == b.charAt(i))
            {
                count++;
                j++;
            }
            i++;
        }

        return b.length() - count;

    }
}
