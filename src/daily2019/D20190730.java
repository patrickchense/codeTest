package daily2019;

import java.util.*;

/*
On election day, a voting machine writes data in the form (voter_id, candidate_id) to a text file.
 Write a program that reads this file as a stream and returns the top 3 candidates at any given time. If you find a voter voting more than once, report this as fraud.

@Uber
@easy
@solved

@priorityqueue

 */
public class D20190730 {

	public static void main(String[] args) {
		handel(1, 1);
		handel(2, 2);
		handel(3, 2);
		handel(4, 2);
		handel(5, 3);
		handel(6, 3);
		handel(7, 4);
		handel(8, 4);

		System.out.println(topThree(3));
	}

	static class Vote {
		int candidateId;
		int count;

		void addCount() {
			this.count++;
		}

		public int getCount() {
			return this.count;
		}
	}
	static PriorityQueue<Vote> topThree = new PriorityQueue<>(3, Comparator.comparingInt(Vote::getCount).reversed());

	static Map<Integer, Vote> candiates = new HashMap<>();

	static Set<Integer> voters = new HashSet<>();

	public static void handel(int voterId, int candidateId) {
		if (voters.contains(voterId)) {
			//report
			throw new RuntimeException("fraud");
		}
		if (candiates.containsKey(candidateId)) {
			topThree.remove(candiates.get(candidateId));
		}
		Vote v = candiates.getOrDefault(candidateId, new Vote());
		v.addCount();
		v.candidateId = candidateId;
		candiates.put(candidateId, v);
		topThree.add(v);
		voters.add(voterId);
	}

	public static List<Integer> topThree(int topN) {
		List<Integer> top = new ArrayList<>(topN);
		int count = 0;
		Iterator<Vote> ite = topThree.iterator();
		while(ite.hasNext() && count < topN) {
			top.add(((Vote)ite.next()).candidateId);
			count++;
		}
		return top;
	}
}
