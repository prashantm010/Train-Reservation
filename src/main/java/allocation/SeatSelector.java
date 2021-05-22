package allocation;

import Models.Booking;
import Models.BookingRequest;
import Models.Seat;
import Models.Train;

import java.util.List;

public interface SeatSelector {
    public List<Seat> selectSeats(BookingRequest bookingRequest);
}
