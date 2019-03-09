package roundrobinsimulation;

public class Process /*implements Comparable*/{

    private int arrivalTime;
    private int burstTime;
    private int burstTimeTemp;
    private String name;
    private int completedTime;
    private int waitingTime;
    private int turnAroundTime;

    public Process(String name,int arrivalTime, int burstTime) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.burstTimeTemp = burstTime;
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

    public int getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(int completedTime) {
        this.completedTime = completedTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getBurstTimeTemp() {
        return burstTimeTemp;
    }

    public void setBurstTimeTemp(int burstTimeTemp) {
        this.burstTimeTemp = burstTimeTemp;
    }

//    @Override
//    public int compareTo(Object o) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
    
}
