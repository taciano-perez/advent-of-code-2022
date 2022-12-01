package org.tacianoperez;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * https://adventofcode.com/2022/day/1
 *
 */
public class Day1 {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    public static int countCalories(final String inputFile) throws IOException {
        Map<Integer,Integer> caloriesPerElf = new TreeMap<>(Collections.reverseOrder());
        int currentElf = 1;
        caloriesPerElf.put(currentElf, 0);
        int maxCalories = 0;
        int maxElf = 1;

        InputStream is = new FileInputStream(inputFile);
        try (Scanner sc = new Scanner(is, StandardCharsets.UTF_8.name())) {
            while (sc.hasNextLine()) {
                final String line = sc.nextLine();
                if ("".equals(line)) {
                    // new elf
                    currentElf++;
                    caloriesPerElf.put(currentElf, 0);
                } else {
                    int currentCalories = caloriesPerElf.get(currentElf);
                    int caloriesToAdd = Integer.valueOf(line);
                    caloriesPerElf.put(currentElf, currentCalories + caloriesToAdd);
                    if (currentCalories + caloriesToAdd > maxCalories) {
                        maxCalories = currentCalories + caloriesToAdd;
                        maxElf = currentElf;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("Elf %d has the most calories %d\n", maxElf, maxCalories);

        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        caloriesPerElf.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
            .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        Iterator it = sortedMap.entrySet().iterator();
        int count = 0;
        int sum = 0;
        while (count < 3 && it.hasNext()) {
            Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>) it.next();
            System.out.printf("Elf %d has %d calories\n", entry.getKey(), entry.getValue());
            sum += entry.getValue();
            count++;
        }
        System.out.printf("Sum is %d.\n", sum);
        return maxCalories;
    }

}
