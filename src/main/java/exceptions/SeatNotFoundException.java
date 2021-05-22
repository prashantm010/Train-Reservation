package exceptions;

import lombok.Data;

@Data
public class SeatNotFoundException extends RuntimeException {
    private String reason;
    public SeatNotFoundException(String reason) {
        super();
        this.reason = reason;
    }
}
