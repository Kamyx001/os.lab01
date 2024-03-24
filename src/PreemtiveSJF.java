import java.util.ArrayList;

public class PreemtiveSJF {

    private ArrayList<Process> processes;

    public PreemtiveSJF(ArrayList<Process> processes) {
        this.processes = processes;
    }

    public double getAverageWaitTime(){
        ArrayList<Process> queue = new ArrayList<>(processes);
        int currentTime = 0;
        int totalWaitTime = 0;

        queue.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        while(!queue.isEmpty()){
            Process p = queue.get(0);
            if(queue.size() == 1){
                int waitTime = currentTime - p.getArrivalTime();
                totalWaitTime += waitTime;
                break;
            }
            Process pNext = queue.get(1);
            queue.sort((p1, p2) -> p1.getBurstTime() - p2.getBurstTime());
            queue.remove(0);
            if(p.getBurstTime()<pNext.getArrivalTime()){
                p.setBurstTime(p.getBurstTime()-currentTime);
                currentTime += pNext.getArrivalTime();
                totalWaitTime += currentTime - p.getArrivalTime();
                queue.add(p);
            }
            else{
                int waitTime = currentTime - p.getArrivalTime();
                totalWaitTime += waitTime;
                currentTime += p.getBurstTime();
            }
        }

        return (double)totalWaitTime / processes.size();
    }
}
