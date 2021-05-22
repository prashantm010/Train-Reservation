package exceptions;

import lombok.Data;

@Data
public class InvalidBookingException extends RuntimeException {
    private final String reason = "Invalid booking";
}
