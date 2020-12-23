import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Aircraft> aircraftList = airport.getAllAircrafts();
        System.out.println(aircraftList);
        int aircraftAmmount = aircraftList.size();
        System.out.println(aircraftAmmount);
    }
}