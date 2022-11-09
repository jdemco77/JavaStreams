import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamExamples {

    public static void main(String[] args) {

        // Create an Array of Strings
        String[] strs = new String[] { "hello", "james", "welcome to Lists" };

        // Make a list from the string Array
        List<String> strList = Arrays.asList(strs);

        // stream from Collection Interface directly
        Stream<String> strStream = strList.stream();

        // Pass an array to static Stream.of() method
        Stream stream2 = Stream.of(strs);

        // Pass your stream items directly using Stream.of()
        Stream stream4 = Stream.of("hello", "james", "welcome to Lists");

        // .reduce() will aggregate inputs into a single output - here we combine
        // strings into a sentence
        String sentence = strList.stream().reduce("", (str1, str2) -> str1 + " " + str2);

        System.out.println(sentence);

        // .filter can be used to check a condition such as removing Strings not
        // containing "el"
        List<String> strCheck = strList.stream().filter(s -> (s.contains("el"))).collect(Collectors.toList());
        System.out.println(strCheck);

        // print out items in a stream by passing in (System.out::println) to .forEach
        // strStream.forEach(System.out::println);

        // Streams on numbers
        // declare a list of integers
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 12);

        // reduce can be used to find the sum of items in an integer Stream
        int sum = numbers.stream().reduce(0, (num1, num2) -> num1 + num2);
        System.out.println(sum);

        // .filter will remove ints less than 2 or greater than 10
        List<Integer> filteredNums = numbers.stream().filter(n -> (n > 2 && n <= 10)).collect(Collectors.toList());
        System.out.println(filteredNums);

        // parallelStream can be used for faster computation in the event of a large list of integers
        // ordering may vary in the below example, we may see the ints not printed in order
        numbers.parallelStream().forEach(System.out::println);

        // parallel Stream should not be used when preserving order is necessary
        // instead it would appropriate for a reduce funtion where the result is combined
        int parralelSum = numbers.parallelStream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(parralelSum);
    }

}
