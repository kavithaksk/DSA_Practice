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
























}













