import java.util.ArrayList;

public class ROT {

    private ArrayList<Process> processes;
    private int quantum;

    public ROT(ArrayList<Process> processes, int quantum) {
        this.processes = processes;
        this.quantum = quantum;
    }

    public double getAverageWaitTime(){
        ArrayList<Process> queue = new ArrayList<>(processes);
        int currentTime = 0;
        int totalWaitTime = 0;

        queue.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        while(!queue.isEmpty()){
            Process p = queue.get(0);
            queue.remove(0);
            if(p.getArrivalTime() <= currentTime){
                if(p.isQuantum()){
                    p.setQuantum(false);
                } else
                if(p.getBurstTime() > quantum && !p.isQuantum()){
                    currentTime += quantum;
                    totalWaitTime += currentTime - p.getArrivalTime();
                    p.setBurstTime(p.getBurstTime()-quantum);
                    p.setQuantum(true);
                    queue.add(p);
                } else {
                    currentTime += p.getBurstTime();
                    totalWaitTime += currentTime - p.getArrivalTime();
                }
            }
        }

        return (double)totalWaitTime / processes.size();
    }

}
