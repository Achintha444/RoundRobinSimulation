package roundrobinsimulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RoundRobin {

    private ArrayList<Process> processList;
    private int timeQuantum;
    private Queue<Process> init;

    public RoundRobin(ArrayList<Process> processList, int timeQuantum) {
        this.processList = processList;
        this.timeQuantum = timeQuantum;
        this.init = new LinkedList<>();
    }
    
    
    
    private ArrayList<Process> calculate(){
        
        ArrayList<Process> completedProcessList = new ArrayList<>();
        
        //Adding the process to the queue
        int temp ;
        System.out.println(processList.size());
        for (int i = 0; i<5 ; i++){
            temp = this.calculateMin();
            Process temp1 = this.processList.get(temp);
            init.add(temp1);
            this.processList.remove(this.processList.get(temp));
        }
        
        //Round Robin Process
        int totalTime = 0; //total competion time
        while(true){
            
            
            if (init.isEmpty()){
                break;
            }
            
            else{
                Process tempProcess = init.poll();
                System.out.println(tempProcess.getName());
                while(totalTime<tempProcess.getArrivalTime()){
                    totalTime+=1;
                }
                if(tempProcess.getBurstTimeTemp()<=this.timeQuantum){
                    totalTime+=tempProcess.getBurstTimeTemp();
                    tempProcess.setCompletedTime(totalTime);
                    int tempTAT = totalTime-tempProcess.getArrivalTime();
                    tempProcess.setTurnAroundTime(tempTAT);
                    tempProcess.setWaitingTime(tempTAT-tempProcess.getBurstTime());
                    completedProcessList.add(tempProcess);
                    
                }
                else{
                    tempProcess.setBurstTimeTemp(tempProcess.getBurstTimeTemp()-this.timeQuantum);
                    totalTime+=this.timeQuantum;
                    init.add(tempProcess);
                }
            }
            System.out.println(completedProcessList.size());
        }
        return completedProcessList;    
    }
    
    private int calculateMin(){
        int min = this.processList.get(0).getArrivalTime();
        int n = 0;
        int len = this.processList.size();
        for(int i=1; i<len; i++){
            if (min>this.processList.get(i).getArrivalTime()){
                min = this.processList.get(i).getArrivalTime();
                n = i;
            }
        }
        return n;
    }
    
    public ArrayList<Process> getCalculate(){
        
        ArrayList<Process> completedProcessList = this.calculate();
        return completedProcessList;
        
    }

}


