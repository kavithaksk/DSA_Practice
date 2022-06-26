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
//        TrappingWaterProblem.maxArea();
//        TrappingWaterProblem.trap();
//        System.out.println(FindMaxLengthOfSubArray.findMaxLenSubarray());
//        LengthOfLongestNonRepeatingChar.lengthOfLongestNonRepeatingChar();
//        PrintAllSubArrays.printAllSubarrays();
//        System.out.println(GenerateParenthesis.generateParenthesis(3));
//        System.out.println(GenerateParenthesis.isValid("([]){"));
//        ReArrangeWordsInSentence.reArrangeWordsInSentence();
        String expression = "2*3-4*5";

        List<Integer> result2 = DifferentWaysToAddParanthesis.diffWaysToCompute(expression);
        result2.stream().forEach(i -> System.out.println(i));

        //SearchInsert.searchInsert(new int[] {1, 3},2);

        //RemoveDuplicatesInAnArray.removeDuplicates();
       // MaximumSubArray.maxSubArray();
        //System.out.println(RemoveKDigits.removeKdigits("10001", 4));

       // LongestStringChain.longestStrChain();

        AdsConversionRate.getAdsConversionRate();

        FindInvalidUsers.findInvalidUsers();

        StudentCourseShare.printCommonCoursesSharedByStudents();


//
//        int[][] grid = new int[][]{
//            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//
//        //interviewQuestions.MaxAreaIsland(grid, 104);
//        int missingNumber = FindFirstMissingPositiveNumber.findFirstMissingPositive();
//        System.out.println("Missing positive number is : " + missingNumber);
//
//        int[] candidates = new int[] {10,1,2,7,6,1,5};
//        CombinationsSum.CombinationSumII(candidates, 8);
//        int result = interviewQuestions.myAtoi("   -42");
//        System.out.println(result);
//        int longestRepeatingCount = LengthOfLongestNonRepeatingChar.lengthOfLongestNonRepeatingChar();
//        System.out.println("Length of longest substring without repeating char's -->" +longestRepeatingCount);
//
//        int arr[] = new int[] { 142,112,54,69,148,45,63,158,38,60,124,142,130,179,117,36,191,43,89,107,41,143,65,49,47,6,91,130,171,151,7,102,194,149,30,24,85,155,157,41,167,177,132,109,145,40,27,124,138,139,119,83,130,142,34,116,40,59,105,131,178,107,74,187,22,146,125,73,71,30,178,174,98,113};
//        System.out.println(arr.length);
//        List<Integer> result1 = interviewQuestions.findSubArrayWithGivenSum(arr,74, 665 );
//        result1.stream().forEach(System.out::println);
//        Stream.of(result1.toArray()).forEach(System.out::println);
//
//        int input[] = new int[] {0, 1, 2, 99, 13, 23, 4, 6, 8, 3, 5, 8, 9, 11, 10, 12, 13, 16};
//        interviewQuestions.reArrangeEvenAndOdd(input);
//
//        Integer[] inputArray = {-10, -3, 5, 6, -2};
//        List<Integer> maxProduct = interviewQuestions.findMaxiumProductofTwoIntegersInArray(inputArray);

        //interviewQuestions.convertIntegerToBinary(Integer.MAX_VALUE);







    }
}