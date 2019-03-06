import java.util.List;

public class RoundRobin {

    private List<Process> processList;
    private int timeQuantum;

    public RoundRobin(List<Process> processList, int timeQuantum) {
        this.processList = processList;
        this.timeQuantum = timeQuantum;
    }


}
