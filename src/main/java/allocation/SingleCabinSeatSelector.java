package allocation;

import Models.*;
import exceptions.SeatNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SingleCabinSeatSelector implements SeatSelector {
    @Override
    public List<Seat> selectSeats(BookingRequest bookingRequest) {
        List<Seat> answerSeats = new ArrayList<>();
        boolean bookingPossible = false;
        for(Coach coach: bookingRequest.getTrain().getCoachList()) {
            for(Cabin cabin: coach.getCabinList()) {
                List<Seat> emptySeats = cabin.getEmptySeats();
                if(emptySeats.size() >= bookingRequest.getNumberOfSeats()) {
                    while(answerSeats.size() != bookingRequest.getNumberOfSeats()) {
                        Seat seat = emptySeats.remove(0);
                        answerSeats.add(seat);
                    }
                    bookingPossible = true;
                }
            }
        }

        if(bookingPossible) {
            return answerSeats;
        }

        throw new SeatNotFoundException("Seats not found in single cabin");
    }

}
