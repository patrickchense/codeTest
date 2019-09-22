package codenomadz;


import java.util.*;

public class Flight {

	private final String flightNo;

	private final String origin;

	private final String destination;

	private Map<Grade, Section> sectionMap = new HashMap<>();

	public Flight(String flightNo, String origin, String destination, Map<Grade, Set<Seat>> seats) {
		this.flightNo = flightNo;
		this.origin = origin;
		this.destination = destination;
		seats.entrySet().forEach(entry -> sectionMap.put(entry.getKey(), new Section(entry.getValue())));
	}

	public String getFlightNo() {
		return flightNo;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public Seat reserveSeat(Grade grade) throws NoSeatAvailableException {
		Section section = sectionMap.get(grade);
		return section.reserveSeat();
	}

	public long countAvailableSeats(Grade grade) {
		return sectionMap.get(grade).countAvailableSeats();
	}

}

enum  Grade {
	FIRST, BUSINESS, ECONOMY
}

class Section {

	private final Set<Seat> seats;

	Section(Set<Seat> seats) {
		this.seats = seats;
	}

	public Seat reserveSeat() throws NoSeatAvailableException {
		Seat seat = seats.stream().filter(Seat::isAvailable).findFirst().orElseThrow(NoSeatAvailableException::new);
		seat.reserve();
		return seat;
	}

	public long countAvailableSeats() {
		return seats.stream().filter(Seat::isAvailable).count();
	}
}

class Seat {

	private final String number;

	private Status status = Status.AVAILABLE;

	public Seat(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public Status getStatus() {
		return status;
	}

	public boolean isAvailable() {
		return status == Status.AVAILABLE;
	}

	public void reserve() {
		status = Status.RESERVED;
	}

	public enum Status {
		AVAILABLE, RESERVED
	}
}

class SeatsGenerator {

	public Set<Seat> createSeats(int rows, int seatsInRow, int firstRowNumber) {
		return new HashSet<>(); // TODO: Implement
	}
}

class NoSeatAvailableException extends Exception {

}

class FlightManager {

	private Set<Flight> flights = new HashSet<>();

	public boolean addNewFlight(Flight flight) {
		return flights.add(flight);
	}

	public Optional<Flight> findFlight(String flightNo) {
		return flights.stream().filter(f -> f.getFlightNo().equals(flightNo)).findAny();
	}

}
