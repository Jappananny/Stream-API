import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Задача 1
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10, 15, 20, 25)).stream();

        findMinMax(
                stream,
                Comparator.naturalOrder(),
                (x, y) -> System.out.printf("min %s, max %s %n%n", x, y)
        );
        stream.close();

        //Задача 2
        Stream<Integer> stream1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10, 16, 18, 25)).stream();
        System.out.println("Количество четных чисел " + countEvenNumber(stream1.collect(Collectors.toList())));
    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }
    public static int countEvenNumber(List<Integer> integers) {
        return (int) integers.stream()
                .filter(i -> i % 2 == 0)
                .peek(System.out::println)
                .count();
    }
}