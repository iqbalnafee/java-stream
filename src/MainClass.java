import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
//        String s = "abcdabcdrg";
//        String s2 = "abcdabcrgdklklk";
//        TreeMap<Character, Long> collect =
//                s.chars()
//                        .mapToObj(n -> (char) n)
//                        .collect(Collectors.groupingBy(
//                                Function.identity(),
//                                TreeMap::new,
//                                Collectors.counting()
//                        ));
//
//        TreeMap<Character, Long> collect2 = s2.chars()
//                .mapToObj(n -> (char) n)
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        TreeMap::new,
//                        Collectors.counting()
//                ));
//
//        if (collect.equals(collect2)) {
//            System.out.println("SAME");
//        } else {
//            System.out.println("NOT SAME");
//        }
//
//        System.out.println(collect);
//        int n = 3;
//        List<Integer> coll = new ArrayList<>();
//        while (n != 1) {
//            coll.add(n);
//            if (n % 2 == 0) {
//                n = n / 2;
//            } else {
//                n = 3 * n + 1;
//            }
//        }
//        System.out.println(coll);

        int n = 3;
        List<Integer> collect =
                IntStream.iterate(n, x -> x != 1, x -> x % 2 == 0 ? x / 2 : 3 * x + 1)
                        .boxed()
                        .collect(Collectors.toList());

        //System.out.println("collect "+collect);
        //stream count
        Long listItemCount = collect.stream().count();
        //System.out.println("listItemCount: "+listItemCount);

        //stream dropWhile
        Stream<Integer> stream
                = Stream.of(4, 5, 6, 7, 8, 9, 10);

        // apply dropWhile to drop all the numbers
        // matches passed predicate
        List<Integer> list
                = stream.dropWhile(number -> (number / 4 == 1))
                .collect(Collectors.toList());

        //System.out.println(list);

        //stream empty
        Stream<String> stringStream = Stream.empty();

        //flatMap
        //Stream flatMap make multiple layer of streams into one layer
        // Creating a List of Strings
        List<Integer> primeNumbers = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        List<Integer> oddNumbers = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        List<List<Integer>> listsOfLists = Arrays.asList(primeNumbers, oddNumbers, evenNumbers);
        //System.out.println(listsOfLists);

        List<Integer> map = primeNumbers.
                stream().
                map(singleList -> singleList * 2).
                collect(Collectors.toList());
        //System.out.println("map: "+map);

        List<Integer> flatMap = listsOfLists.stream().
                flatMap(singleList -> singleList.stream()).
                collect(Collectors.toList());
        //System.out.println("flatMap: "+flatMap);

        // flatMap vs map
        // flatMap can works on multiple layer of lists i.e.  [[2, 3], [1, 3, 5], [2, 4]]
        // but map can works on only a single layer of list i.e. [2, 3]

        // flatMap not only works on list of list but also Optional of Optional i.e. Optional<Optional<obj>>
        // which makes it Optional<obj>

        //forEach

        // Creating a Stream of Strings
        Stream<String> stream2 = Stream.of("GFG", "Geeks",
                "for", "GeeksforGeeks");

        // Using forEach(Consumer action) to print
        // Character at index 1 in reverse order
        stream2.sorted(Comparator.reverseOrder())
                .flatMap(str -> Stream.of(str.charAt(1)))
                ;

        //stream generate

        Stream.generate(Math::random).limit(5).forEach(System.out::println);
        // generate requires a supplier. Suppliers are useful when we don’t need to supply any value
        // and obtain a result at the same time, i.e. Supplier<Double> randomValue = () -> Math.random();

    }

    public static int func(int var){
      return var*2;
    }

}
