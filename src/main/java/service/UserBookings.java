package service;

import Models.Booking;
import Models.User;
import exceptions.NoBookingFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserBookings {
    private HashMap<Integer, List<Booking>> userBookingMap;
    private static UserBookings userBookings;

    private UserBookings() {
        userBookingMap = new HashMap<>();
    }

    public static UserBookings getInstance() {
        if(userBookings == null) {
            userBookings = new UserBookings();
        }
        return userBookings;
    }

    public void addBooking(Booking booking) {
        List<Booking> userBookingList = userBookingMap.get(booking.getUser().getId());
        if(userBookingList == null) {
            userBookingList = new ArrayList<>();
            userBookingMap.put(booking.getUser().getId(), userBookingList);
        }
        userBookingList.add(booking);
    }

    public List<Booking> getBookings(User user) {
        List<Booking> userBookingList = userBookingMap.get(user.getId());
        if(userBookingList == null) {
            throw new NoBookingFoundException();
        }
        return userBookingList;
    }
}
