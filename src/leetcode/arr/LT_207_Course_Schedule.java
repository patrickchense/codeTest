package leetcode.arr;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/course-schedule/

@array
@answered
@review
@DFS

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
public class LT_207_Course_Schedule {
    /*
           input: numCourses = 3
                  pre-req = [
                      [0,1], // 0's prerequisites is 1
                      [0,2], // 0's prerequisites is 2
                      [1,2]  // 1's prerequisites is 2
                  ]
           Basic idea is to use DFS and find out if there are any cycles in the graph
       */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; // ??

        // Index of this list is a course and its values are the dependencies (children)
        List<List<Integer>> courseDependency = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++)
            courseDependency.add(new ArrayList<>());

        /*
        create following courseDependency arraylist for each index (course)
            0: [1,2],
            1: [2],
            2: []
        */
        for (int i = 0; i < prerequisites.length; i++) {
            courseDependency.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // use state int array to represent current status of visiting for each node
        // 0: not visited yet, 1: currently visiting (in recursion stack frame), 2: already visited
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, courseDependency, state)) {
                return false;   // Cycle found
            }
        }

        // no cycle found
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> courseDependency, int[] state) {

        state[course] = 1;  // currently visiting

        List<Integer> dependencies = courseDependency.get(course);

        for (int children: dependencies) {
            if (state[children] == 1)   // If any children is also being currently visiting, then cycle is detected
                return false;

            if (state[children] == 0) { // Not visted yet
                if (!dfs(children, courseDependency, state))
                    return false;
            }
        }

        state[course] = 2;  // done visiting
        return true;        // no cycle, backtrack to caller
    }
}
