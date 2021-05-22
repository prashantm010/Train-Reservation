package Models;

import lombok.Data;
import misc.SeatType;

@Data
public class Seat {
    private boolean occupied;
    private User user;
    private SeatType seatType;
    private int coachNumber;
    private int cabinNumber;
    private int trainNumber;

    public Seat(SeatType seatType, int cabinNumber, int coachNumber, int trainNumber) {
        this.seatType = seatType;
        this.cabinNumber = cabinNumber;
        this.coachNumber = coachNumber;
        this.trainNumber = trainNumber;
    }
}
