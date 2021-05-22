package Models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Coach {
    private int coachNumber;
    private int trainNumber;
    private List<Cabin> cabinList;

    public Coach(int coachNumber, int numberOfCabins, int trainNumber) {
        this.trainNumber = trainNumber;
        this.coachNumber = coachNumber;
        cabinList = new ArrayList<>();
        for(int x=0; x<numberOfCabins; x++) {
            cabinList.add(new Cabin(x+1, coachNumber, trainNumber));
        }
    }
}
