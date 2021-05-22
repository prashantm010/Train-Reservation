package Models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Booking {
    private User user;
    private int trainNumber;
    private List<Seat> seatList;
    private Date bookingTime;

    public Booking(User user, int trainNumber, List<Seat> seatList) {
        this.user = user;
        this.trainNumber = trainNumber;
        this.seatList = seatList;
        bookingTime = new Date();
    }

}
