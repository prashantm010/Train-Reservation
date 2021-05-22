package allocation;

import Models.*;
import exceptions.SeatNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DefaultSeatSelector implements SeatSelector {
    @Override
    public List<Seat> selectSeats(BookingRequest bookingRequest) {
        List answerSeats = new ArrayList();
        boolean bookingPossible = false;
        outer:for(Coach coach: bookingRequest.getTrain().getCoachList()) {
            for(Cabin cabin: coach.getCabinList()) {
                for(Seat seat: cabin.getSeatList()) {
                    if(!seat.isOccupied()) {
                        answerSeats.add(seat);
                        if(answerSeats.size() == bookingRequest.getNumberOfSeats()) {
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
        throw new SeatNotFoundException("Empty seats not available in train");
    }

}
