package com.company;

import java.util.*;
import java.util.stream.Stream;

public class ReArrangeWordsInSentence {

    public static void reArrangeWordsInSentence()
    {
        String s = "Keep calm and code on";

        String[] tokens = s.split(" ");
        Map<String, Integer> hashMap = new LinkedHashMap<>();

        for (int i = 0; i < tokens.length; i++) {
            int length = tokens[i].length();
            hashMap.put(tokens[i], length);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            //System.out.println("Key-->" + entry.getKey() + " " + "Length of token" + " " + entry.getValue());
            list.add(entry.getValue());
        }
        Collections.sort(list);
        Stream.of(list.toArray()).forEach(System.out::println);

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Integer i : list) {
            String key = " ";
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if (entry.getValue() == i) {
                    key = entry.getKey();
                    sortedMap.put(key, i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        String[] keys = sortedMap.keySet().toArray(new String[0]);
        Arrays.stream(keys).forEach(S -> sb.append(S.toLowerCase() + " "));

        String result = sb.toString();

        int firstCh = result.charAt(0) - 32;
        System.out.println(sb.toString());
        //result.replaceFirst(result.charAt(0) + " "), (char) firstCh + " ");


//       int d = (char) keys[0].charAt(0) - 32;
//       char ch = (char) d;
//       String firstText = keys[0].replace(keys[0].charAt(0), ch);
//       sb.append(firstText + " ");
//       for(int i = 1; i < keys.length - 1; i++)
//           sb.append(keys[i] + " ");
//
//
//        String lastKey =  keys[keys.length - 1];
//
//        d = lastKey.charAt(0);
//        if (d < 97)
//            d = d + 32;
//        ch = (char) d;
//
//        System.out.println(ch);
//
//        String lastText = lastKey.replace(lastKey.charAt(0), ch);
//        System.out.println(lastText);
//
//        sb.append(lastText);


        int i = 0;
//        for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
//
//            String firstKey = entry.getKey();
//            if (i == 0) {
//                int d = (char) firstKey.charAt(0) - 32;
//                char c = (char) d;
//                System.out.println(c);
//                String newString = entry.getKey().replace(firstKey.charAt(0), c);
//                sb.append(newString + " ");
//            }
//            else
//                sb.append(entry.getKey() + " ");
//            i++;
//        }
    }
}

