import by.Constants;
import by.gsu.epamlab.beans.ExtraTrial;
import by.gsu.epamlab.beans.LightTrial;
import by.gsu.epamlab.beans.StrongTrial;
import by.gsu.epamlab.beans.Trial;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        //1. Create an ArrayList implementation for 9 entities
        List<Trial> trials = Arrays.asList(new Trial("Petrov", 80, 70),
                new Trial("Pechkin", 71, 75),
                new Trial("Putin", 75, 85),
                new LightTrial("Vasin", 25, 84),
                new LightTrial("Ivanov", 34, 96),
                new StrongTrial("Sidorov", 84, 70),
                new StrongTrial("Kravtsov", 81, 94),
                new ExtraTrial("Bloh", 75, 45, 25),
                new ExtraTrial("Litvinenko", 99, 99,99));

        //2. Print the collection content (one element per line).
        trials.forEach(System.out::println);

        //3. Print the number of passed trials.
        System.out.println(trials.stream()
                .filter(Trial::isPassed)
                .count());

        //4. Sort the collection by the sum of first and second marks.
        ToIntFunction <Trial> sumMark = n -> n.getMark1() + n.getMark2();

        trials.sort(Comparator.comparingInt(sumMark));

        //5. Print sums of first and second marks from the collection (one sum per line).
        trials.stream()
                .mapToInt(sumMark)
                .forEach(System.out::println);

        //6. Create a new collection from unpassed trials, clear all marks and print
        // this collection. Check whether all trials are failed (the result type is boolean).
        List <Trial> nonPassed = trials.stream()
                .filter(n -> !n.isPassed())
                .map(Trial::getCopy)
                .peek(Trial::clearAllResults)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println( nonPassed.stream()
                .noneMatch(Trial::isPassed));

        //7. Create a numeric array from sums of first and second marks of
        // sorted collection (see item 4) and print it in the format:
        //sum[0], sum[1], … , sum[sum.length - 1]
        int [] sums =trials.stream()
                .mapToInt(sumMark)
                .toArray();

        System.out.println(Arrays.stream(sums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(Constants.OUT_ARRAY_DELIMITER)));
    }
}
