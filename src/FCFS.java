import java.util.ArrayList;

public class FCFS {
    private ArrayList<Process> processes;

    public FCFS(ArrayList<Process> processes) {
        this.processes = processes;
    }

    public double getAverageWaitTime(){
        ArrayList<Process> queue = new ArrayList<>(processes);
        int currentTime = 0;
        int totalWaitTime = 0;

        queue.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        for(Process p : queue){
            if(p.getArrivalTime() <= currentTime){
                int waitTime = currentTime - p.getArrivalTime();
                totalWaitTime += waitTime;
                currentTime += p.getBurstTime();
            }
        }

        return (double)totalWaitTime / processes.size();
    }
}
