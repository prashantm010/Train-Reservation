package allocation;

import Models.BookingRequest;

public class SeatFactory {
    
    private static SeatFactory seatFactory;
    
    public static SeatFactory getInstance() {
        if(seatFactory == null) {
            seatFactory = new SeatFactory();
        }
        return seatFactory;
    }
    
    private SingleCabinSeatSelector singleCabinBookingCreator = new SingleCabinSeatSelector();
    private SeatMatcherSeatSelector seatMatcherBookingCreator = new SeatMatcherSeatSelector();
    private DefaultSeatSelector defaultSeatBookingCreator = new DefaultSeatSelector();

    public SeatSelector getSeatSelector(BookingRequest bookingRequest) {
        if(bookingRequest.isSingleCabin()) {
            return singleCabinBookingCreator;
        } else if(bookingRequest.getSeatPreference() != null){
            return seatMatcherBookingCreator;
        } else {
            return defaultSeatBookingCreator;
        }
    }
}
