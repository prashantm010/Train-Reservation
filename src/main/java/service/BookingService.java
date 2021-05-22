package service;

import Models.Booking;
import Models.BookingRequest;
import Models.Seat;
import Models.Train;
import allocation.SeatFactory;
import allocation.SeatSelector;

import java.util.List;

public class BookingService {

    public static Booking createBooking(BookingRequest bookingRequest) {

        SeatSelector seatSelector = SeatFactory.getInstance().getSeatSelector(bookingRequest);
        List<Seat> seats = seatSelector.selectSeats(bookingRequest);
        for(Seat seat: seats) {
            seat.setOccupied(true);
            seat.setUser(bookingRequest.getUser());
        }
        Booking booking = new Booking(bookingRequest.getUser(), bookingRequest.getTrain().getTrainNumber(), seats);
        UserBookings.getInstance().addBooking(booking);
        return booking;

    }
}
