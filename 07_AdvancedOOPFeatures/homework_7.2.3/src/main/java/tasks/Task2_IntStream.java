package tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Task2_IntStream {

    /**
     * Задача перемножить все числа переданные в список.
     *
     * Метод должен вернуть -1 в 2-х случаях:
     * 1. Если в функцию попадает пустой стрим
     * 2. Если результат умножения превышает 100
     *
     * Примеры:
     *
     *    (2,3) -> 6
     *    (2,2,2) -> 8
     *    () -> -1
     *    (50, 3) -> -1
     *
     * Понадобиться:
     *   - Stream::reduce
     *   - Optional::filter
     *   - Optional::orElse
     *
     * @param linkedListOfNumbers
     * @return
     */
    public static Integer multiply(List<Integer> linkedListOfNumbers) {
       Optional<Integer> res = linkedListOfNumbers.stream()
               .reduce((i1, i2) -> i1 * i2)
               .filter(i -> i <= 100);
       return res.orElse(-1);
    }

    /**
     * Найти среднее чисел в массиве, или вернуть исключение, если массив пустой.
     *
     * см. Стримы для примитивов в https://annimon.com/article/2778
     *
     * Понадобиться:
     *   - IntStream::of
     *   - IntStream::average
     *   - Optional:orElseThrow
     *
     * @param numbers
     * @return
     */
    public static double findAverage(int[] numbers) {
      return Arrays.stream(numbers).average().orElseThrow();
    }

}
