package Models;

import exceptions.InvalidBookingException;
import lombok.Data;
import misc.SeatType;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookingRequest {
    private User user;
    private Train train;
    private int numberOfSeats;
    private boolean singleCabin;
    private List<SeatType> seatPreference;

    public BookingRequest(User user, Train train, int numberOfSeats, boolean singleCabin) {
        if(numberOfSeats < 0 || numberOfSeats > 4) {
            throw new InvalidBookingException();
        }
        this.user = user;
        this.train = train;
        this.numberOfSeats = numberOfSeats;
        this.singleCabin = singleCabin;
    }

    public BookingRequest(User user, Train train, List<SeatType> seatPreference) {
        if(seatPreference.size() > 4) {
            throw new InvalidBookingException();
        }
        this.user = user;
        this.train = train;
        this.seatPreference = seatPreference;
        this.numberOfSeats = seatPreference.size();
    }
}
