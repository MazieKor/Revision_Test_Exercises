package pl.mk.AccentureTest;

import pl.mk.AccentureTest.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestList2 {

    public static void main(String[] args) {

        List<Integer> testList1 = new ArrayList<>(Arrays.asList(2,6,2,-5,1,-5,1,4,2,2,1,12,3,6,12,-34));
        List<Integer> testList2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        List<Integer> testList3 = Collections.emptyList();


        List<Integer> sortedTestList1 = new ArrayList<>(testList1);             //I don't want to change original list for displaying purpose, so I create a copy
        Collections.sort(sortedTestList1);
        System.out.println("Sorted List 1: " + sortedTestList1 + "\n");

        System.out.printf("Number of duplicates: 2: %s %n", Exercise.findDuplicates(testList1,2));
        try{
            System.out.println(Exercise.findDuplicates(testList1,-2));       // Number of duplicates: 0 or negative gives an Exception
        } catch (IllegalArgumentException e){
            System.out.println("Exception: " + e);
        }
        System.out.printf("Number of duplicates: 1: %s %n", Exercise.findDuplicates(testList1,1));
        System.out.printf("Number of duplicates: 3: %s %n", Exercise.findDuplicates(testList1,3));

        System.out.println("\nResults of TestLists no 2 and 3: ");

        System.out.println("List without dupicates - Number of duplicates: 2: " + Exercise.findDuplicates(testList2,2));
        System.out.println("List without dupicates - Number of duplicates: 1: " + Exercise.findDuplicates(testList2,1));
        System.out.println("Result of empty List: " + Exercise.findDuplicates(testList3,2));

    }

}