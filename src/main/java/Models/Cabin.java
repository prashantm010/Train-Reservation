package Models;

import lombok.Data;
import misc.SeatType;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cabin {

    private int cabinNumber;
    private int coachNumber;
    private int trainNumber;
    private List<Seat> seatList;

    public Cabin(int cabinNumber, int coachNumber, int trainNumber) {
        this.cabinNumber = cabinNumber;
        seatList = new ArrayList<>();
        for(SeatType seatType: SeatType.values()) {
            seatList.add(new Seat(seatType, cabinNumber, coachNumber, trainNumber));
        }
    }

    public List<Seat> getEmptySeats() {
        ArrayList seats = new ArrayList();
        for(Seat seat: seatList) {
            if(!seat.isOccupied()) {
                seats.add(seat);
            }
        }
        return seats;
    }
}
