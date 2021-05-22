package exceptions;

import lombok.Data;

@Data
public class NoBookingFoundException extends RuntimeException {
    private final String reason = "No bookings found";
}
