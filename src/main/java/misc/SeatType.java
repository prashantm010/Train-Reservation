package misc;

public enum SeatType {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX;

    public boolean isLower(SeatType seatType) {
        return seatType == ONE || seatType == THREE || seatType == FIVE;
    }

    public boolean isSideLower(SeatType seatType) {
        return seatType == FIVE;
    }

    public boolean isSideUpper(SeatType seatType) {
        return seatType == SIX;
    }

    public boolean isUpper(SeatType seatType) {
        return !isLower(seatType);
    }
}
