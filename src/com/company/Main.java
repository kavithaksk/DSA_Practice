package com.company;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.security.spec.RSAOtherPrimeInfo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.lang.Math.*;
import static java.time.temporal.TemporalAdjusters.previous;

public class Main {


    public static void main(String[] args) throws ParseException {
        // write your code here

        InterviewQuestions interviewQuestions = new InterviewQuestions();

        //int[] input = new int[] { 1,8,6,2,5,4,8,3,7};
        int[] input = new int[] { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
       // int area = interviewQuestions.trap(input);
        //System.out.println("Area of the container : "  +area);

        List<Integer> nums = Arrays.asList( 5, 6, -5, 5, 3, 5, 3, -2, 0);

        int target = 8;
        System.out.println("Max length of the subarray matching the given sum " + target + ":" + interviewQuestions.findMaxLenSubarray(nums,target));



//
//        double d = 2.5;
//        long v = (long) (d * 2000000L);
//        System.out.println(v);

        //interviewQuestions.LengthOfLongestNonRepeatingChar("GEEKSFORGEEKS");
        //int[] nums = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

       // interviewQuestions.printAllSubarrays(nums);
        System.out.println(GenerateParenthesis.generateParenthesis(3));

        String s= "(()(()))";

        int openN = 0;
        int closedN = 0;
        int score = 0;
        Stack<Object> st = new Stack<>();

        for(int i = 0; i < s.length() ; i++)

        {
            char ch = s.charAt(i);
            if (ch == ')')
            {
                st.pop();
                score++;
                st.push(score);
            }
            else
            st.push(ch);
        }

        if (st.size() == 1)
        {
            score *= 2;
        }
        System.out.println(score);

        System.out.println(GenerateParenthesis.isValid("([]){"));

        int[][] grid = new int[][]{
            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        interviewQuestions.MaxAreaIsland(grid, 104);

        //int height[] =  {1,8,6,2,5,4,8,3,7};
        //int area = interviewQuestions.maxArea(height, height.length);
        //System.out.println("Max area" + area);
//
//        int[] nums = {3, 4, -1, 1};
//        int missingNumber = interviewQuestions.findFirstMissingPositive(nums);
//        System.out.println("Missing positive number is : " + missingNumber);

        int[] candidates = new int[] {10,1,2,7,6,1,5};
        //interviewQuestions.CombinationSumII(candidates, 8);


        //int result = interviewQuestions.myAtoi("   -42");
        //System.out.println(result);
//        int longestRepeatingCount = interviewQuestions.LengthOfLongestNonRepeatingChar("GEEKSFORGEEKS");
//        System.out.println("Length of longest substring without repeating char's -->" +longestRepeatingCount);

//        int arr[] = new int[] { 142,112,54,69,148,45,63,158,38,60,124,142,130,179,117,36,191,43,89,107,41,143,65,49,47,6,91,130,171,151,7,102,194,149,30,24,85,155,157,41,167,177,132,109,145,40,27,124,138,139,119,83,130,142,34,116,40,59,105,131,178,107,74,187,22,146,125,73,71,30,178,174,98,113};
//        System.out.println(arr.length);
//        List<Integer> result = interviewQuestions.findSubArrayWithGivenSum(arr,74, 665 );
//        result.stream().forEach(System.out::println);
//        Stream.of(result.toArray()).forEach(System.out::println);

        //int input[] = new int[] {0, 1, 2, 99, 13, 23, 4, 6, 8, 3, 5, 8, 9, 11, 10, 12, 13, 16};
        //interviewQuestions.reArrangeEvenAndOdd(input);

        String text = "Keep calm and code on";
        //interviewQuestions.reArrangeWordsInSentence(text);
        Integer[] inputArray = {-10, -3, 5, 6, -2};
        //List<Integer> maxProduct = interviewQuestions.findMaxiumProductofTwoIntegersInArray(inputArray);

        //interviewQuestions.convertIntegerToBinary(Integer.MAX_VALUE);







    }
}