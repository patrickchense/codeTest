package amazon;

import java.util.*;

/*
Given a map Map<String, List<String>> userMap, where the key is a username and the value is a list of user's songs.
Also given a map Map<String, List<String>> genreMap, where the key is a genre and the value is a list of songs belonging to this genre.
The task is to return a map Map<String, List<String>>, where the key is a username and the value is a list of the user's favorite genres.
 Favorite genre is a genre with the most song.

Example 1:

Input:
userMap = {
   "David": ["song1", "song2", "song3", "song4", "song8"],
   "Emma":  ["song5", "song6", "song7"]
},
genreMap = {
   "Rock":    ["song1", "song3"],
   "Dubstep": ["song7"],
   "Techno":  ["song2", "song4"],
   "Pop":     ["song5", "song6"],
   "Jazz":    ["song8", "song9"]
}

Output: {
   "David": ["Rock", "Techno"],
   "Emma":  ["Pop"]
}

Explanation:
David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre.
Example 2:

Input:
userMap = {
   "David": ["song1", "song2"],
   "Emma":  ["song3", "song4"]
},
genreMap = {}

Output: {
   "David": [],
   "Emma":  []
}
 */
public class FavoriteGenres {

	public static void main(String[] args) {
		Map<String, List<String>> userSongs = new HashMap<>();
		userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
		userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

		Map<String, List<String>> genreMap = new HashMap<>();
		genreMap.put("Rock", Arrays.asList("song1", "song3"));
		genreMap.put("Dubstep", Arrays.asList("song7"));
		genreMap.put("Techno", Arrays.asList("song2", "song4"));
		genreMap.put("Pop", Arrays.asList("song5", "song6"));
		genreMap.put("Jazz", Arrays.asList("song8", "song9"));
		System.out.println(favoriteGenres(userSongs, genreMap));

		userSongs.put("David", Arrays.asList("song1", "song2"));
		userSongs.put("Emma", Arrays.asList("song3", "song4"));
		genreMap = new HashMap<>();

		System.out.println(favoriteGenres(userSongs, genreMap));
	}

	public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> genres) {
		Map<String, List<String>> userGenres = new HashMap<>(userSongs.size());
		Map<String, String> songGenre = new HashMap<>();
		for (Map.Entry<String, List<String>> genre : genres.entrySet()) {
			genre.getValue().forEach(s -> songGenre.put(s, genre.getKey()));
		}
		for (Map.Entry<String, List<String>> user : userSongs.entrySet()) {
			Map<String, Integer> countGenre = new HashMap<>();
			user.getValue().forEach(s -> {
				if (songGenre.containsKey(s)) {
//					System.out.println("s = " + s);
					int val = countGenre.getOrDefault(songGenre.get(s), 0);
					countGenre.put(songGenre.get(s), val + 1);
				}
			});
			if (countGenre.isEmpty()) {
				userGenres.put(user.getKey(), Collections.emptyList());
			} else {
				List<String> faGenres = new ArrayList<>();
				int max = -1;
				for (Map.Entry<String, Integer> count : countGenre.entrySet()) {
					if (count.getValue() > max) {
						faGenres.clear();
						faGenres.add(count.getKey());
						max = count.getValue();
					} else if (count.getValue() == max) {
						faGenres.add(count.getKey());
					}
				}
				userGenres.put(user.getKey(), faGenres);
			}

		}
		return userGenres;
	}
}

