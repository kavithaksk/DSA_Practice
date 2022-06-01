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


        int[][] grid = new int[][]{
            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        //interviewQuestions.MaxAreaIsland(grid, 104);



        //ZonedDateTime dateTime = ZonedDateTime.now().with(previous(DayOfWeek.SUNDAY)).with(LocalTime.MIDNIGHT).truncatedTo(ChronoUnit.SECONDS);

        //System.out.println(dateTime.getDayOfWeek());

        //System.out.println(("61474?ids=307248557,314671808,305537656,311558272,314102274,314102277,203307747,304362992,307248553,314102278,305537651,310197087,311546042,305133390,311554913,311546040,314379234,311546044,314424379,314671814,206941505,307296866,206941504,310195908,314376193,314521708,311558284,205884196,313340367,302366800,316879034,205543598,205543597,314368580,314376196,314247806,314436346,//rma.homedepot.com/tag88879-eg23520?adkey%253D57d%2526sku%253D301883526%2526pub_ref%253DeyJ0YWdfZXh0IjoiZWcyMzUyMCIsImQiOiJ0aGRhX3BscF90YWJsZXQifQ%25253D%25253D,203183622,304361680,203183620,314424386,301329195,206665620,311558251,314436377,314517211,314517213,203307761,205326359,309820435,311546069,203183614,314379259,311546066,203183610,301224942,316928754,314424399,305537646,311558264,311558261,203307757,305533285,314436366,311225491,203307751,304361669,311554901,311757648,309820446,309820205,203183605,301884113,308150429,203183603,203183601,203182555,301329176,300109062,300109067,303827416,203763394,203763392,203763390,311225482,311546082,311546081,316909827,203182547,314494263,314494261,316909830,316137895,314094997,314030705,314368541,301329184,315287090,205326360,205326361,303827400,205326363,205543551,303827407,205543550,203131109,311546079,317996070,203182575,203182572,206607100,311558291,203131108,203131107,203245396,314494259,301744257,203131106,205326390,304362973,203131105,205326395,316137867,205351551,315287089,205326398,203245393,315287084,203245391,308800377,315287082,//rma.homedepot.com/tag162810-eg23520?adkey%253Da07%2526sku%253D301883526%2526pub_ref%253DeyJ0YWdfZXh0IjoiZWcyMzUyMCIsImQiOiJ0aGRhX2VtYWlsX3VuaXZlcnNhbCJ9,203182568,203183657,203183654,203182566,203182560,203359181,315287070,203245385,207033295,311225458,203245387,205326386,303827427,203683552,315287077,205351564,203683550,205326387,315287075,205351566,311546094,205351565,204705295,311554948,203183648,203182557,315287079,203183688,317996041,314503672,316138131,203183686,203183680,313303569,314106238,303827454,315287067,205392484,314504769,314503673,205392487,314503675,314503660,311396701,207206341,314511047,303827443,311225437,313303333,314106242,305518998,314503666,314503669,314503662,314030070,314504780,205999690,300108793,206819825,205893545,311396708,311396709,314891018,314672045,206819827,205893546,206819826,205893547,314504789,314094991,314031373,305518969,314672289,314504785,309955745,314106229,314504772,314504771,300108784,314031149,316922813,314511063,205893559,206819839,310642513,314891028,206819838,205893558,314504774,314891021,314504776,317996242,203307708,305537219,313305789,317996007,311396735,313305786,305537211,314672020,205895987,301744074,205895984,313305782,314672265,314504728,314504723,314427277,301364626,314026601,301744070,314504721,205893560,301364624,203394780,314511007,314026608,203183476,301884130,311558246,313981908,205999681,311396749,314672031,314504719,313305793,310642534,301744067,203394779,205895999,204337222,314427288,314032294,204337223,314427283,314521280,314494094,206701405,314494092,203307723,316138556,314520190,313979992,314520197,314504744,314503656,314891054,314427295,314672009,314504740,314521048,314504742,314494088,316138561,203307719,203307710,305129214,313305777,314511021,203307712,314511028,305537202,313979986,313975148,313979980,314710236,314522142,314030095,314504732,316143205,316143201,308157752,205390579,207167047,207167048,206701264,206701265,206666298,303827058,309820099,309949230,306305103,205390580,207167035,314521271,207167036,207167037,206819773,206819772,204365714,206819774,305518358,203611740,305518357,313980503,203611742,310205333,205390591,205390598,205940778,314091872,205390599,311546984,205298792,205298793,308157732,203394777,206819542,203394778,203394775,203394776,206819787,206819786,314026181,314428060,313980511,311947504,305656126,311546982,311546979,314091864,311546974,207167058,203394766,203394767,203394764,303827065,314091869,203394765,313302860,313980521,313980527,203140599,314522100,314521253,311546971,306305111,316143400,309621404,31").length());

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