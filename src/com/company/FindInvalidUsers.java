package com.company;

import java.util.*;

public class FindInvalidUsers {

    public static String[][]  badge_records =   new String[][]
            {
                    { "Martha", "exit"},
                    { "Paul", "enter"},
                    { "Martha", "enter"},
                    { "Martha", "exit"},
                    { "Jennifer", "enter"},
                    { "Paul", "enter"},
                    { "Curtis", "enter"},
                    { "Paul", "exit"},
                    { "Martha", "enter"},
                    { "Martha", "exit"},
                    { "Jennifer", "exit"},
            };

    public static void findInvalidUsers()
    {
        /* create a map to store the entry and exit values.
           When there is entry, set it to 1.
           when there is exit, then set it to 0 */
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> noEntryMap = new HashSet<>();
        HashSet<String> noExitMap = new HashSet<>();
        for (int i  = 0; i < badge_records.length; i++)
        {
            String[] s = badge_records[i];
            if (s[1].equals("exit"))
            {
                int count = map.getOrDefault(s[0], 0);
                if (count != 1)
                    noEntryMap.add(s[0]);
                else
                {
                    map.put(s[0], 0);
                }
            }
            else
            {
                int count = map.getOrDefault(s[0], 0);
                if (count != 1)
                    map.put(s[0], 1);
                else
                    noExitMap.add(s[0]);
            }
       }

        for (Map.Entry<String, Integer> kv : map.entrySet())
        {
            if (kv.getValue() != 0) {
                if (!noExitMap.contains(kv.getKey()))
                    noExitMap.add(kv.getKey());
            }
        }

        List<List<String>> invalidEntries = new ArrayList<>();
        List<String> invalidExitValues = new ArrayList<>(noExitMap);
        List<String> invalidEntryValues = new ArrayList<>(noEntryMap);

        invalidEntries.add(invalidExitValues);
        invalidEntries.add(invalidEntryValues);
        invalidEntries.stream().forEach(s-> System.out.println(s));
    }



}
