package daily2019;

import java.util.HashMap;
import java.util.Map;

/*
The “active time” of a courier is the time between the pickup and dropoff of a delivery. Given a set of data formatted like the following:

(delivery id, timestamp, pickup/dropoff)
Calculate the total active time in seconds. A courier can pick up multiple orders before dropping them off. The timestamp is in unix epoch seconds.

For example, if the input is the following:

(1, 1573280047, 'pickup')
(1, 1570320725, 'dropoff')
(2, 1570321092, 'pickup')
(3, 1570321212, 'pickup')
(3, 1570322352, 'dropoff')
(2, 1570323012, 'dropoff')
The total active time would be 1260 seconds.

@easy
@Postmates
@solved

 */
public class D20191125 {

	public static void main(String[] args) {
		Object[][] couriers = new Object[][] {
			{1, 1573280047L, "pickup"},
			{1, 1570320725L, "dropoff"},
			{2, 1570321092L, "pickup"},
			{3, 1570321212L, "pickup"},
			{3, 1570322352L, "dropoff"},
			{2, 1570323012L, "dropoff"},

		};

		System.out.println(calActive(couriers));
	}

	private static long calActive(Object[][] couriers) {
		Map<Integer, Long> pickups = new HashMap<>();
		int active = 0;
		for (Object[] courier : couriers) {
			if (courier[2].equals("pickup")) {
				pickups.put((int)(courier[0]), (long)(courier[1]));
			} else {
				active +=  pickups.get((int)courier[0]) - (long)(courier[1]);
			}
		}
		return active;
	}


}
