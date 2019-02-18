package amazon;

import java.util.*;

public class ShorestDelivery {

    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        // WRITE YOUR CODE HERE
        // validation
        if (allLocations == null || allLocations.size() == 0) return null;
        if (numDestinations != allLocations.size()) return null;
        if (numDeliveries > numDestinations) return null;

        // calculation
        Map<Integer, String> locationDistances = new HashMap<>(numDestinations);
        Integer[] distances = new Integer[numDestinations];
        for (int i = 0 ; i < allLocations.size(); i++) {
            List<Integer> location = allLocations.get(i);
            int distance = location.get(0) * location.get(0) + location.get(1) * location.get(1);
            if (locationDistances.containsKey(distance)) {
                // incase same distance
                locationDistances.put(distance, locationDistances.get(distance) + ";" + i);
            } else  {
                locationDistances.put(distance, String.valueOf(i));
            }
            distances[i] = distance;
        }
        Arrays.sort(distances);
        List<List<Integer>> result = new ArrayList<>(numDeliveries);
        for (int i = 0; i < numDeliveries; i++) {
            int distance = distances[i];
            String index = locationDistances.get(distance);
            if (index.contains(";")) {
                int in = Integer.valueOf(index.substring(0, index.indexOf(";")));
                locationDistances.put(distance, index.substring(index.indexOf(";")+1));
            } else {
                result.add(allLocations.get(Integer.valueOf(index)));
            }
        }
        return result;
    }
}
