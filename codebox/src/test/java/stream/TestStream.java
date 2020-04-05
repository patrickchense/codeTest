package stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * https://stackify.com/streams-guide-java-8/
 */
public class TestStream {

    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };

    private static List<Employee> empList = Arrays.asList(arrayOfEmps);

    @Test
    public void whenApplySumOnIntStream_thenGetSum() {

        Double avgSal = empList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(NoSuchElementException::new);

        assertEquals(avgSal, new Double(200000));
    }

    @Test
    public void whenFindFirst_thenGetFirstEmployeeInStream() {

        Employee employee = Stream.of(arrayOfEmps)
                .filter(e -> e != null)
                .filter(e -> e.getSalary() > 100000)
                .findFirst()
                .orElse(null);

        assertEquals(employee.getSalary(), new Double(200000));
    }

    @Test
    public void whenIncrementSalaryUsingPeek_thenApplyNewSalary() {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        empList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());

        assertThat(empList, contains(
                hasProperty("salary", equalTo(100010.0)),
                hasProperty("salary", equalTo(200010.0)),
                hasProperty("salary", equalTo(300010.0))
        ));
    }

    @Test
    public void whenApplyMatch_thenReturnBoolean() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);

        assertEquals(allEven, false);
        assertEquals(oneEven, true);
        assertEquals(noneMultipleOfThree, false);
    }

    @Test
    public void whenApplyReduceOnStream_thenGetValue() {
        Double sumSal = empList.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

        assertEquals(sumSal, new Double(600000));
    }

    @Test
    public void whenApplySummarizing_thenGetBasicStats() {
        DoubleSummaryStatistics stats = empList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        assertEquals(stats.getCount(), 3);
        assertEquals(stats.getSum(), 600000.0, 0);
        assertEquals(stats.getMin(), 100000.0, 0);
        assertEquals(stats.getMax(), 300000.0, 0);
        assertEquals(stats.getAverage(), 200000.0, 0);
    }

    @Test
    public void whenApplySummaryStatistics_thenGetBasicStats() {
        DoubleSummaryStatistics stats = empList.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();

        assertEquals(stats.getCount(), 3);
        assertEquals(stats.getSum(), 600000.0, 0);
        assertEquals(stats.getMin(), 100000.0, 0);
        assertEquals(stats.getMax(), 300000.0, 0);
        assertEquals(stats.getAverage(), 200000.0, 0);
    }

    @Test
    public void whenStreamPartition_thenGetMap() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));

        assertEquals(isEven.get(true).size(), 4);
        assertEquals(isEven.get(false).size(), 1);
    }

    @Test
    public void whenStreamGroupingBy_thenGetMap() {
        Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));

        assertEquals(groupByAlphabet.get('B').get(0).getName(), "Bill Gates");
        assertEquals(groupByAlphabet.get('J').get(0).getName(), "Jeff Bezos");
        assertEquals(groupByAlphabet.get('M').get(0).getName(), "Mark Zuckerberg");
    }

    @Test
    public void whenStreamReducing_thenGetValue() {
        Double percentage = 10.0;
        Double salIncrOverhead = empList.stream().collect(Collectors.reducing(
                0.0, e -> e.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));

        assertEquals(salIncrOverhead, 60000.0, 0);
    }

}
