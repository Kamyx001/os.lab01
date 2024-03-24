import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SJF {
    private ArrayList<Process> processes;

    public SJF(ArrayList<Process> processes) {
        this.processes = processes;
    }

    public double getAverageWaitTime(){
        ArrayList<Process> queue = new ArrayList<>(processes);
        int currentTime = 0;
        int totalWaitTime = 0;

        queue.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        Map<Integer, ArrayList<Process>> processMap = new HashMap<>();
        for(Process p: queue){
            if(processMap.containsKey(p.getArrivalTime())){
                processMap.get(p.getArrivalTime()).add(p);
                processMap.get(p.getArrivalTime()).sort((p1, p2) -> p1.getBurstTime() - p2.getBurstTime());
            } else {
                processMap.put(p.getArrivalTime(), new ArrayList<>());
                processMap.get(p.getArrivalTime()).add(p);
                processMap.get(p.getArrivalTime()).sort((p1, p2) -> p1.getBurstTime() - p2.getBurstTime());
            }
        }

        for(int i : processMap.keySet()){
            ArrayList<Process> p = processMap.get(i);
            for(Process p1: p){
                if(p1.getArrivalTime() <= currentTime){
                    int waitTime = currentTime - p1.getArrivalTime();
                    totalWaitTime += waitTime;
                    currentTime += p1.getBurstTime();
                } else {

                    currentTime += p1.getArrivalTime();
                }
            }
        }

        return (double)totalWaitTime / processes.size();
    }
}
