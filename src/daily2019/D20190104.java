package daily2019;

import util.ArrayUtil;

import java.util.*;

/*
We're given a hashmap associating each courseId key with a list of courseIds values, which represents that the prerequisites of courseId are courseIds.
Return a sorted ordering of courses such that we can finish all courses.

Return null if there is no such ordering.

For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300'].

@Airbnb
@solved
@needOptimize

找继承关系？第一个总是value是空的
 */
public class D20190104 {
    public static void main(String[] args) {
        Map<String, List<String>> courseIds = new HashMap<>();
        courseIds.put("CSC300", Arrays.asList("CSC100", "CSC200"));
        courseIds.put("CSC200", Arrays.asList("CSC100"));
        courseIds.put("CSC100", Arrays.asList());
        ArrayUtil.printList(orderedCourses(courseIds));
    }

    public static List<String> orderedCourses(Map<String, List<String>> courseIds) {
        List<String> res = new ArrayList<>();
        // O(n^2) is easy, find first, find second, find third ...
        for (Map.Entry<String, List<String>> course: courseIds.entrySet()) {
            if (course.getValue().isEmpty()) res.add(course.getKey());
        }
        res.forEach(courseIds::remove);
        if (res.isEmpty()) return null;
        while (true) {
            int size = res.size();
            for (Map.Entry<String, List<String>> course: courseIds.entrySet()) {
                if (res.containsAll(course.getValue())) res.add(course.getKey());
            }
            res.forEach(courseIds::remove);
            if (courseIds.isEmpty() || res.size() == size) break;
        }
        if (!courseIds.isEmpty()) return null;
        return res;
    }

    // how to improve?? 其实可以理解为排序，对List<String>,
}
