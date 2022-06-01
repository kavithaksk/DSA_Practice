package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class InterviewQuestions {

    int totalElements = 0;
    int numRows = 0;
    int numCols = 0;



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

    public ArrayList<Integer> findSubArrayWithGivenSum(int arr[], int n, int sum)
    {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            int j = i;
            int diff = sum;
            while (diff > 0 && j < n)
            {
                diff -= arr[j];
                j++;
            }
            if (diff == 0) {
                result.add(i + 1);
                result.add(j+1);
                System.out.println("first position " +i + "second position" + j);
                break;
            }

        }
        if (result.size() == 0)
            result.add(-1);
        return result;
    }

    // GEEKSFORGEEKS

    public int LengthOfLongestNonRepeatingChar(String s) {

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

    public static void reverse(int[] array) {

        // Length of the array
        int n = array.length;

        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }

    int findIndex(int num, int[] a) {
        int pos = -1;
        for (int i = 0; i < a.length; i++) {
            if (num == a[i]) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static int trap(int[] heights)
    {
        // maintain two pointers left and right, pointing to the leftmost and
        // rightmost index of the input array
        int left = 0, right = heights.length - 1, water = 0;

        int maxLeft = heights[left];
        int maxRight = heights[right];

       // { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 }
        while (left < right)
        {
            if (heights[left] <= heights[right])
            {
                left++;
                maxLeft = Integer.max(maxLeft, heights[left]);
                water += (maxLeft - heights[left]);
            }
            else {
                right--;
                maxRight = Integer.max(maxRight, heights[right]);
                water += (maxRight - heights[right]);
            }
        }

        return water;
    }

    /* container with most water */
    public int maxArea(int[] A, int len) {
        int l = 0;
        int r = len - 1;
        int area = 0;

        while (l < r) {
            int base = Math.min(A[l], A[r]) * (r - l);
            System.out.println(base);
            // Calculating the max area
            area = Math.max(area, base);

            if (A[l] < A[r])
                l += 1;

            else
                r -= 1;
        }
        return area;
    }

    public int findFirstMissingPositive(int[] nums) {
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

    public List<List<Integer>> CombinationSumII(int[] candidates, int target) {
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

    //"4235"
    public int myAtoi(String inpString) {

        int result = 0, digit = 0;
        int product;
        boolean negative = false;


        String input = inpString.trim();
        if (input.charAt(0) == '-')
            negative = true;

        //for(int i = 0; i < s.length(); i++)
        {
            String[] s1 = input.split(" ");
            for (String s : s1) {
                int length = s.length() - 1;
                for(int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    if (ch >= '0' && ch <= '9') {
                        digit = ch - '0';
                        product = (int) (digit * Math.pow(10, length - i));
                        result += product;
                    }
                }
            }
            if (negative)
                result = result * -1;
            return result;

        }
    }


    // Rearrange even and odd numbers in linear time such that even no's comes before odd numbers
    // Input a[] = {2, 3, 5, 8, 9, 11, 10, 12, 13, 16 }

    public  void reArrangeEvenAndOdd(int[] A)
    {
        int length = A.length;
        int j = 0;

        for (int i = 0; i < A.length; i++)
        {
            if (A[i] % 2 == 0) {
                int saveCurrentPosEle = A[i];

                for(int k = i; k > j; k--)
                {
                    A[k] = A[k - 1];
                }
                A[j++] = saveCurrentPosEle;
            }
        }

        for (int i = 0; i < A.length; i++)
            System.out.println(A[i]);
    }

    public void reArrangeWordsInSentence(String s)
    {
        String[] tokens = s.split(" ");
        Map<String , Integer> hashMap = new LinkedHashMap<>();

        for(int i = 0; i < tokens.length; i++)
        {
            int length = tokens[i].length();
            hashMap.put(tokens[i], length);
        }
        List<Integer> list = new ArrayList<>();
       for(Map.Entry<String, Integer> entry : hashMap.entrySet())
       {
           //System.out.println("Key-->" + entry.getKey() + " " + "Length of token" + " " + entry.getValue());
           list.add(entry.getValue());
       }
       Collections.sort(list);
       Stream.of(list.toArray()).forEach(System.out::println);

       Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
       for(Integer i : list)
       {
           String key = " ";
           for(Map.Entry<String, Integer> entry : hashMap.entrySet())
           {
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

    public List<Integer> findMaxiumProductofTwoIntegersInArray(Integer[] a)
    {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(a, Collections.reverseOrder());
        int length = a.length;
        int lastElement = a[length - 1];
        int lastElementBefore = a[length - 2];

        int firstProd = a[0] * a[1];
        int secondProd = 0;
        if (lastElement < 0 && lastElementBefore < 0)
            secondProd = lastElement * lastElementBefore;

        if (firstProd < secondProd)
        {
            result.add(lastElement);
            result.add(lastElementBefore);
        }
        else if (firstProd > secondProd)
        {
            result.add(a[0]);
            result.add(a[1]);
        }
        else
        {
            result.add(a[0]);
            result.add(a[1]);
            result.add(lastElement);
            result.add(lastElementBefore);
        }
        Stream.of(result).forEach(System.out::println);
        return  result;
    }


    public void convertIntegerToBinary(int n)
    {
        int rem = 0;
        StringBuilder sb = new StringBuilder();
        while (n != 0)
        {
            rem = n % 2;
            sb.append(rem);
            n = n / 2;
        }
        sb.reverse();
        String binaryValue = sb.toString();
        int lPos = 0, rPos = 0, diff = -1;
        for(int i = 1; i < binaryValue.length(); i++)
        {
            while (i  < binaryValue.length() && binaryValue.charAt(i) != '1') i++;
            rPos = i;
            if (rPos != binaryValue.length())
            diff = Math.max((rPos - lPos - 1), diff);
            lPos = rPos;
        }

        System.out.println(diff);

    }


    public void MaxAreaIsland(int[][] grid, int totalEle)
    {

        numRows = grid.length;
        numCols = grid[0].length;
        totalElements = numRows * numCols;

        int maxArea = 0;

        for(int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numCols; j++)
            {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, depthFirstSearch(i, j, grid));
                    System.out.println(maxArea);
                }
            }

        }


    }

    public  int depthFirstSearch(int x, int y, int[][] grid)
    {
        int trackCellsWithOnes = 1;
        if (x < 0 || y < 0 || x == numRows  || y == numCols ) return trackCellsWithOnes;

        if (grid[x][y] == 0) return trackCellsWithOnes;
        if (grid[x][y] == 1 && x > 0 && x < numRows && y >0 && y < numCols)
        {
            trackCellsWithOnes += depthFirstSearch(x, y-1, grid);
            trackCellsWithOnes += depthFirstSearch (x, y, grid);
            trackCellsWithOnes += depthFirstSearch(x, y, grid);
            trackCellsWithOnes += depthFirstSearch(x-1, y, grid);

        }

        return trackCellsWithOnes;

    }

    public int findContainerWithMostWater(int[] height)
    {
        int[] input = new int[height.length];

        for (int i = 0; i < height.length; i++)
            input[i] = height[i];




        int n = input.length;

        for(int i = 0; i < height.length; i++)
            System.out.print(height[i] + "   ");

        Arrays.sort(height);
        System.out.println();

        for(int i = 0; i < height.length; i++)
        System.out.print(height[i] + "   ");

        System.out.println();


        int firstMaxElement = height[height.length - 1];
        System.out.println(firstMaxElement);
        int firstMaxElementIndex = findIndex(firstMaxElement, input);
        System.out.println("firstMaxElementIndex --> " + firstMaxElementIndex);



        int secondMaxElement = firstMaxElement;
        System.out.println(secondMaxElement);

        int secondMaxElementIndex = -1;
        int width = 1;
        for(int i = n - 1; i >0; i--)
        {
            if (height[i] != height[i - 1])
            {
                secondMaxElement = height[i - 1];
                break;
            }
        }

        if (firstMaxElementIndex == 0)
        {
            for (int i = 0; i < n - 1; i++)
                if (input[i] > input[i + 1])
                    width++;

             return width * firstMaxElement;
        }

        if (secondMaxElement !=  firstMaxElement)
        {
             secondMaxElementIndex = findIndex(secondMaxElement, input);
            System.out.println(secondMaxElementIndex);

            if (secondMaxElementIndex > firstMaxElementIndex)
            {
                width = secondMaxElementIndex - firstMaxElementIndex;
                System.out.println("Width --> " + width);
            }

            return width * secondMaxElement;

        }



        return 1;






    }


    private static<K, V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        // if the key is seen for the first time, initialize the list
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }

    // Function to print all subarrays with a zero-sum in a given array
    public void printAllSubarrays(int[] nums)
    {
        // create an empty multimap to store the ending index of all
        // subarrays having the same sum
        Map<Integer, List<Integer>> hashMap = new HashMap<>();

        // insert (0, -1) pair into the map to handle the case when
        // subarray with zero-sum starts from index 0
        insert(hashMap, 0, -1);

        int sum = 0;

        // traverse the given array
        for (int i = 0; i < nums.length; i++)
        {
            // sum of elements so far
            sum += nums[i];

            // if the sum is seen before, there exists at least one
            // subarray with zero-sum
            if (hashMap.containsKey(sum))
            {
                List<Integer> list = hashMap.get(sum);

                // find all subarrays with the same sum
                for (Integer value: list)
                {
                    System.out.println("Subarray [" + (value + 1) + "…" +
                            i + "]");
                }
            }

            // insert (sum so far, current index) pair into the multimap
            insert(hashMap, sum, i);
        }
    }

    public int findMaxLenSubarray(List<Integer> nums, int target)
    {
        // Write your code here...

        int sum = -1;
        int maxLengthSubArray = -1;

        for (int i = 0; i < nums.size(); i++)
        {
            sum = 0;

            for (int j = i; j < nums.size(); j++)
            {
                sum += nums.get(j);

                if (sum > target)
                    break;

                if (sum == target)
                {
                    int length = j - i + 1;
                    maxLengthSubArray = Math.max(length, maxLengthSubArray);


                }
            }

        }
        return maxLengthSubArray;

    }























}













