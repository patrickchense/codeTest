package uber;

/*
An imaginary city Z has (N <=20) junctions and M=N(N-I )/2) roads connecting these junctions.There are N-2 passengers in total, one in each junction. An uber shuttle currently at junction 1 in the city needs to pick up the N-2 people by going to those junctions and finally reach junction N. You are given the time taken to traverse each of the M roads and the pair of junctions each of them connect. All roads are bidirectional. You can use the same road multiple times ( if required). You can also pickup the people in any order you want, You need to find the minimum time needed to finally reach junction N after picking up everyone, (Your intermediate route can also pass through N, It doesn't affect the
answer). Output this minimum time. If it is not possible to either reach the destination or pick up someone, output -1.

Constraints
1<=N<=20
1<=time taken to traverse each road<=10^5
Nodes are labelled from 1 to N.
Input graph does not contain multi edges, i.e. between any 2 pairs of cities there exists at most one edge.

Input format
First line contains 2 integers N.M as defined in the problem statement,
Next M lines contains 3 integers u v w each representing the 2 junctions the road connects and the time taken to traverse that road respectively.

Output format
Output 1 integer representing the minimum time required to pick up everyone and reach the destination.
Output -1 if the task cannot be completed,

Sample input
55
1 3 20
24 100
2340
2510
4515

Sample output
100
Explanation
In this case, it is optimal to pick up 3,2,4 in that order and going from 2 to 4 through 5. The best route is 1->3->2->5->4->5 and the total time taken on this route is 100.

@phone

 */
public class ShuttleProblem {
}
