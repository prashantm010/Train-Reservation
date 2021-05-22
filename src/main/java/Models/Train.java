package Models;

import lombok.Data;

import java.util.List;

@Data
public class Train {

    private int trainNumber;
    private List<Coach> coachList;

    public Train(int trainNumber, List<Coach> coachList) {
        this.trainNumber = trainNumber;
        this.coachList = coachList;
    }
}
