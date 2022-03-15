import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
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

        System.out.println(list);

        


    }

}
