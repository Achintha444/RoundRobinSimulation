package roundrobinsimulation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class RoundRobin {

    private ArrayList<Process> processList;
    private ArrayList<String[]> timingDetails;
    private int timeQuantum;
    private Queue<Process> init;

    public RoundRobin(ArrayList<Process> processList) {
        this.processList = processList;
        this.init = new LinkedList<>();
        this.timingDetails = new ArrayList<>();
    }
       
    private ArrayList<Process> calculate(){
        
        ArrayList<Process> completedProcessList = new ArrayList<>();
        this.timeQuantum = this.calculateTimeQuantum();
        
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
        System.out.println(this.timeQuantum);
        
        while(true){
            String tempInit;
            String tempEndT;
            String tempProcessName;
            
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
                    tempProcessName = tempProcess.getName();
                    tempInit=Integer.toString(totalTime);
                    totalTime+=tempProcess.getBurstTimeTemp();
                    tempEndT=Integer.toString(totalTime);
                    tempProcess.setCompletedTime(totalTime);
                    int tempTAT = totalTime-tempProcess.getArrivalTime();
                    tempProcess.setTurnAroundTime(tempTAT);
                    tempProcess.setWaitingTime(tempTAT-tempProcess.getBurstTime());
                    completedProcessList.add(tempProcess);
                    
                    String[] tempArray = {tempInit, tempEndT, tempProcessName};
                    this.timingDetails.add(tempArray);
                    
                }
                else{
                    tempProcessName = tempProcess.getName();
                    tempInit=Integer.toString(totalTime);
                    
                    tempProcess.setBurstTimeTemp(tempProcess.getBurstTimeTemp()-this.timeQuantum);
                    totalTime+=this.timeQuantum;
                     tempEndT=Integer.toString(totalTime);
                    init.add(tempProcess);
                    
                    String[] tempArray = {tempInit, tempEndT, tempProcessName};
                    this.timingDetails.add(tempArray);
                }
            }
            //System.out.println(completedProcessList.size());
        }
        return completedProcessList;    
    }
    
    private int calculateTimeQuantum(){
        System.out.println(this.processList.size());
        int max = this.processList.get(0).getBurstTime();
        int min = this.processList.get(0).getBurstTime();
        int totalBT = this.processList.get(0).getBurstTime();
        for(int i=1; i<5; i++){
            totalBT += this.processList.get(i).getBurstTime();
            if(max<this.processList.get(i).getBurstTime()){
                max = this.processList.get(i).getBurstTime();
            }
            else if(min>this.processList.get(i).getBurstTime()){
                min = this.processList.get(i).getBurstTime();
            }
        }
        double c = (max-min)/2;
        double z = (totalBT)/5;
        int C = (int)(Math.ceil(c));
        int Z = (int)(Math.ceil(z));        
        
        if (C<=Z && C!=0){
            return C;
        }
        else{
            return Z;
        }
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

    public int getTimeQuantum() {
        return timeQuantum;
    }
    
    public ArrayList<String[]> getTiminigDetails(){
        return this.timingDetails;
    }
    
    

}


