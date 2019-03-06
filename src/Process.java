public class Process {

    private int arrivalTime;
    private int burstTime;
    private String name;

    public Process(int arrivalTime, int burstTime, String name) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.name = name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public String getName() {
        return name;
    }
}
