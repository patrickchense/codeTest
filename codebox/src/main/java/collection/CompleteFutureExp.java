package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class CompleteFutureExp {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(10);

		List<Integer> results = IntStream.range(0, 10).boxed()
				.map(i -> CompletableFuture.supplyAsync(() -> process(i), executor))
				.map(CompletableFuture::join)
				.collect(toList());

		System.out.println(results);

		List<Integer> results1 = IntStream.range(0, 10).boxed()
				.map(i -> CompletableFuture.supplyAsync(() -> process(i), executor))
				.collect(collectingAndThen(toList(), list -> list.stream()
						.map(CompletableFuture::join)
						.collect(toList())));

		System.out.println(results1);
	}

	private static int process(Integer i) {
		return i * 10;
	}
}
