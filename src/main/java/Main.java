import Models.*;
import misc.SeatType;
import service.BookingService;
import service.UserBookings;

import java.util.ArrayList;
import java.util.List;
import static misc.SeatType.*;

public class Main {
    public static void main(String args[]) {
        User user1 = new User(1, "Siddharth");
        User user2 = new User(2, "Saloni");

        List<Train> trains = new ArrayList<>();
        int numberOfTrains = 2;
        for(int x=0; x<numberOfTrains; x++) {
            Train train = new Train(x, getCoaches(x,2 * (x+1)));
            trains.add(train);
        }

        BookingRequest bookingRequest = new BookingRequest(user1, trains.get(0), 2, true);
        BookingRequest bookingRequest1 = new BookingRequest(user1, trains.get(0), 1, false);
        List<SeatType> preferenceList1 = new ArrayList<>();
        preferenceList1.add(ONE);
        preferenceList1.add(SIX);
        preferenceList1.add(FIVE);
        BookingRequest bookingRequest2 = new BookingRequest(user2, trains.get(1), preferenceList1);

        BookingService.createBooking(bookingRequest);
        BookingService.createBooking(bookingRequest1);
        BookingService.createBooking(bookingRequest2);

        List<Booking> userOneBookings = UserBookings.getInstance().getBookings(user1);

        System.out.println("DONE");

    }

    private static List<Coach> getCoaches(int trainNumber, int numberOfCoaches) {
        List<Coach> coachList = new ArrayList<>();
        for(int x=0; x<numberOfCoaches; x++) {
            Coach coach = new Coach(x,2 * numberOfCoaches, trainNumber);
            coachList.add(coach);
        }
        return coachList;
    }
}
