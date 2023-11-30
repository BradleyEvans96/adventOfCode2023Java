package adventOfCode;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) throws IOException {
        int day =1;
        String stringDay = "One";
        DataReader reader = new DataReader(day);
        String[] exampleData = reader.getExampleData();
        String [] testData = reader.getTestData();

        String part1Example = null;
        String part1Answer= null;
        String part2Example= null;
        String part2Answer= null;

        // Dynamically import and get answer;
        part1Example = getAnswerFromDynamicClass(stringDay, 1, exampleData);
//        part1Answer = getAnswerFromDynamicClass(stringDay, 1, testData);
//        part2Example = getAnswerFromDynamicClass(stringDay,2,exampleData);
//        part2Answer = getAnswerFromDynamicClass(stringDay,2,testData);

        printOutAdventOfCode(day, part1Example,part1Answer,part2Example,part2Answer);
    }

    static String getAnswerFromDynamicClass (String day, int partNumber, String[] data) {
        try {

            Class<?> SolutionsClass = Class.forName("adventOfCode.solutions.Day"+ day);
            Object SolutionsInstance = SolutionsClass.getDeclaredConstructor().newInstance();

            if(partNumber == 1) {
                Method m = SolutionsClass.getDeclaredMethod("solvePartOne",new Class[]{data.getClass()});
                return (String) m.invoke(SolutionsInstance,new Object[]{data});
            } else {
                Method m = SolutionsClass.getDeclaredMethod("solvePartTwo",new Class[]{data.getClass()});
                return (String) m.invoke(SolutionsInstance,new Object[]{data});
            }
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        return "";
    }

    static void printOutAdventOfCode(int dayNumber,String Part1Example, String Part1Answer, String Part2Example, String Part2Answer) {
        System.out.print("🎄 Advent of Code 2023 - Java Style 🎁 \n");
        if(Part1Example != null) {
            System.out.print("Part 1 Example: " + Part1Example + "\n");
        }
        if(Part1Answer != null) {
            System.out.print("Part 1 Answer: " + Part1Answer + "\n");
        }
        if(Part2Example != null) {
            System.out.print("Part 2 Example: " + Part2Example + "\n");
        }
        if(Part2Answer != null) {
            System.out.print("Part 2 Answer: " + Part2Answer + "\n");
        }

    }
}