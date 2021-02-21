import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import com.skillbox.airport.Flight.Type;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    Airport airport = Airport.getInstance();
    List<Flight> flights = findPlanesLeavingInTheNextTwoHours(airport);

    for (Flight flight : flights) {
        System.out.println(flight);
    }

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        return airport.getTerminals().stream().flatMap(t -> t.getFlights().stream()).filter(f -> {
            LocalDateTime flightDate = f.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return f.getType() == Type.DEPARTURE && flightDate.isAfter(LocalDateTime.now()) && flightDate.isBefore(LocalDateTime.now().plusHours(2));
        }).collect(Collectors.toList());
    }

}