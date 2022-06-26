package com.company;
import java.util.*;

public class StudentCourseShare {

    public static String[][] studentCoursePairs1 = new String[][]
            {
                    {"58", "Linear Algebra"},
                    {"94", "Art History"},
                    {"94", "Operating Systems"},
                    {"17", "Software Design"},
                    {"58", "Mechanics"},
                    {"58", "Economics"},
                    {"17", "Linear Algebra"},
                    {"17", "Political Science"},
                    {"94", "Economics"},
                    {"25", "Economics"},
                    {"58", "Software Design"}
            };

    public static void printCommonCoursesSharedByStudents() {
        HashMap<Integer, List<String>> studentCoursesMap = new HashMap<Integer, List<String>>();
        for (int i = 0; i < studentCoursePairs1.length; i++) {
            String[] studentCoursePair = studentCoursePairs1[i];
            Integer studentId = Integer.parseInt(studentCoursePair[0]);
            String courseName = studentCoursePair[1];

            if (!studentCoursesMap.containsKey(studentId)) {
                List<String> courses = new ArrayList<>();
                courses.add(courseName);
                studentCoursesMap.put(studentId, courses);
            } else {
                List<String> updatedCourses = studentCoursesMap.get(studentId);
                updatedCourses.add(courseName);
                studentCoursesMap.put(studentId, updatedCourses);
            }
        }
        for (Map.Entry<Integer, List<String>> kv : studentCoursesMap.entrySet()) {
            int id = kv.getKey();
            List<String> courses = kv.getValue();
            System.out.print("Student Id: " + id + "  ");
            courses.stream().forEach(s -> System.out.print(s + ","));
            System.out.println();
        }

        HashMap<List<Integer>, List<String>>  finalList = new HashMap<>();
        for (int id : studentCoursesMap.keySet()) {
            List<String> studentCourseList = studentCoursesMap.get(id);
            for(int currentId : studentCoursesMap.keySet()) {
                List<Integer> studentIdsForCommonCourses = new ArrayList<>();
                List<String> currentCourseList = studentCoursesMap.get(currentId);
                if (id != currentId ) {
                    List<String> commonCourses = findCommonCourses(currentCourseList, studentCourseList);
                    studentIdsForCommonCourses.add(currentId);
                    studentIdsForCommonCourses.add(id);
                    Collections.sort(studentIdsForCommonCourses);
                    if (!finalList.containsKey(studentIdsForCommonCourses))
                        finalList.put(studentIdsForCommonCourses, commonCourses);
                }
            }
        }

        for(Map.Entry<List<Integer>, List<String>> kv : finalList.entrySet())
        {
            List<Integer> key = kv.getKey();
            List<String> value = kv.getValue();
            System.out.print("[");
            for(int i : key)
            {
                System.out.print(i + " ");
            }
            System.out.print("]");
            System.out.print("[");
            for(String s : value)
            {
                System.out.print(s + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static List<String> findCommonCourses(List<String> currentCourses, List<String> allCourses)
    {
        List<String> commonList = new ArrayList<>();
        for(String s : allCourses)
        {
            if (currentCourses.contains(s))
                commonList.add(s);
        }

        return  commonList;

    }

}





