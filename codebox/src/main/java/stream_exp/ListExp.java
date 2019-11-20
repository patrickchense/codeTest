package stream_exp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * example about lists api for stream
 * replaceAll
 * sort
 * spliterator
 * 		forEachRemaining
 * 		tryAdvance
 * 		estimateSize
 * 		getExactSizeIfKnown  TODO what's the diff between estimateSize & getExactSizeIfKnown
 * 		characteristics  shows the spliterator characters like SORTED, DISTINCT, ORDERED, SIZED, NONNULL, etc TODO how this calculated?
 *
 */
public class ListExp {

	public static void main(String[] args) {

		List<Integer>  list = Arrays.asList(1,5,3,6,10,2,9,123);
		// sort
		// reverse
		List<Integer> sortedList = list.stream().sorted(Comparator.comparing(i -> i, Comparator.reverseOrder())).collect(Collectors.toList());
		System.out.println("list sort reverse:" + sortedList);

		//spliterator
		System.out.println("=============list spliterator ==================");
		Spliterator<Integer> listIte = list.spliterator();
		System.out.println("list spliterator estimate size: " + listIte.estimateSize());
		System.out.println("list spliterator extract size: " + listIte.getExactSizeIfKnown());
		listIte.forEachRemaining(integer -> System.out.println("list spliterator foreachremaining:" + integer));

		System.out.println("list spliterator estimate size: " + listIte.estimateSize());
		System.out.println("list spliterator extract size: " + listIte.getExactSizeIfKnown());

		Spliterator<Integer> listTryIte = list.spliterator();
		// only one item consumed
		System.out.println("list characteristics: " + listTryIte.characteristics());
		listTryIte.tryAdvance(item -> System.out.println("list spliterator tryAdvance:" + item));
		System.out.println("list spliterator estimate size: " + listIte.estimateSize());
		System.out.println("list spliterator extract size: " + listIte.getExactSizeIfKnown());

		System.out.println("list characteristics after not changed: " + listTryIte.characteristics());

		System.out.println("list hasCharacteristics SORTED: " + listIte.hasCharacteristics(Spliterator.SORTED));
		System.out.println("list hasCharacteristics DISTINCT: " + listIte.hasCharacteristics(Spliterator.DISTINCT));
		System.out.println("=============end list spliterator ==================");

	}

	/**
	 * collections api
	 *
	 * unmodifiableNavigableSet
	 * unmodifiableNavigableMap
	 * synchronizedNavigableSet
	 * synchronizedNavigableMap
	 * checkedQueue
	 * checkedNavigableSet
	 * checkedNavigableMap
	 * emptySortedSet
	 * emptyNavigableSet
	 * emptySortedMap
	 * emptyNavigableMap
	 *
	 */
	public void collections() {

	}

	/**
	 * Arrays api
	 * parallelSort
	 * parallelPrefix
	 *
	 * setAll
	 * parallelSetAll
	 *
	 * spliterator
	 *
	 */
	public void arrays() {

	}

	/**
	 * of
	 *
	 *
	 * stream exp
	 * findFirst
	 * count
	 * findAny
	 * flatMap
	 * generate
	 * limit
	 * reduce
	 *
	 *
	 * peek
	 * filter
	 * contact
	 * distinct
	 * empty
	 * max
	 * min
	 * noneMatch
	 * skip
	 * sorted
	 *
	 *
	 */
	public void stream() {

	}
}
