package collector;

import com.fasterxml.jackson.core.util.BufferRecycler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * custom java collector
 * refer https://medium.com/better-programming/java-stream-collectors-explained-6209a67a4c29
 *
 */
public class Joinector implements Collector<CharSequence, StringJoiner, String> {

    private final CharSequence delimiter;

    public Joinector(CharSequence delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public Supplier<StringJoiner> supplier() {
        // The accumulator object creation.
        return () -> new StringJoiner(this.delimiter);
    }

    @Override
    public BiConsumer<StringJoiner, CharSequence> accumulator() {
        // How to add new stream elements to the accumulator object.
        return StringJoiner::add;
    }

    @Override
    public BinaryOperator<StringJoiner> combiner() {
        // How to merge different accumulator objects together.
        return StringJoiner::merge;
    }

    @Override
    public Function<StringJoiner, String> finisher() {
        // How to extract the final result.
        return StringJoiner::toString;
    }

    @Override
    public Set<Characteristics> characteristics() {
        // Special characteristics of our Collector.
        return Collections.emptySet();
    }

    public static Collector<CharSequence, StringJoiner, String> joinector(CharSequence delimiter) {
        return Collector.of(() -> new StringJoiner(delimiter), // supplier
                StringJoiner::add,                 // accumulator
                StringJoiner::merge,               // combiner
                StringJoiner::toString);           // finisher
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<String> tmp = new ArrayList();
        tmp.add("aaa");
        tmp.add("bbb");
        tmp.add("ccc");

        String a = tmp.stream().collect(Joinector.joinector(";"));
        System.out.println(a);

        String b = tmp.stream().collect(new Joinector(";"));
        System.out.println(b);

        // inject json
        String json = "{\"name\": \"abs\"}";
        // inject reg
        //language=RegExp
        String checkVisa = "^4[0-9]{12}(?:[0-9]{3})?$";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("abc.txt"));


            int i = 0;



            System.out.println("i = " + i);

            System.out.println("Joinector.main");

            System.out.println("args = [" + args + "]");

            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
