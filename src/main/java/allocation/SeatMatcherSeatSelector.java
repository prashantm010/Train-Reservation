package allocation;

import Models.*;
import exceptions.SeatNotFoundException;
import misc.SeatType;

import java.util.ArrayList;
import java.util.List;

public class SeatMatcherSeatSelector implements SeatSelector {
    @Override
    public List<Seat> selectSeats(BookingRequest bookingRequest) {
        List<Seat> answerSeats = new ArrayList<>();
        boolean bookingPossible = false;
        int seatIndex = 0;
        outer:for(Coach coach: bookingRequest.getTrain().getCoachList()) {
            for(Cabin cabin: coach.getCabinList()) {
                for(Seat seat: cabin.getSeatList()) {
                    SeatType desiredSeatType = bookingRequest.getSeatPreference().get(seatIndex);
                    if(!seat.isOccupied() && seat.getSeatType() == desiredSeatType) {
                        answerSeats.add(seat);
                        seatIndex++;
                        if(seatIndex == bookingRequest.getNumberOfSeats()) {
                            bookingPossible = true;
                            break outer;
                        }
                    }
                }
            }
        }

        if(bookingPossible) {
            return answerSeats;
        }
        throw new SeatNotFoundException("Preferred seats not available in train");
    }
}
