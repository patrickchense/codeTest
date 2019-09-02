package amazon;

import java.util.Arrays;

/*
You are on a flight and wanna watch two movies during this flight.
You are given int[] movie_duration which includes all the movie durations.
You are also given the duration of the flight which is d in minutes.
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

e.g.
Input
movie_duration: [90, 85, 75, 60, 120, 150, 125]
d: 250

Output from aonecode.com
[90, 125]
90min + 125min = 215 is the maximum number within 220 (250min - 30min)


@solved
@sort
 */
public class MoviesOnFlight {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(longestDuration(new int[]{90, 85, 75, 60, 120, 150, 125}, 250)));
		// 最大值相同，取longest
		System.out.println(Arrays.toString(longestDuration(new int[]{90, 85, 75, 60, 120, 150, 125, 140}, 250)));
	}

	// O(nlogn) O(1)
	public static int[] longestDuration(int[] ds, int d) {
		int limit = d - 30;
		Arrays.sort(ds);
		int i = 0, j = ds.length - 1;
		int max = 0;
		int[] res = new int[2];
		while (i < j) {
			if (ds[j] + ds[i] <= limit) {
				if (ds[j] + ds[i] > max){
					res[0] = ds[i];
					res[1] = ds[j];
					max = ds[i] + ds[j];
				}
				i++;
			} else if (ds[i] + ds[j] > limit) j--;
		}

		return res;
	}

	// optimize??
}
