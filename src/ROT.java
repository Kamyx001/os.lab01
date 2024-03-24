import java.util.ArrayList;

public class ROT {

    private ArrayList<Process> processes;
    private int quantum;

    public ROT(ArrayList<Process> processes, int quantum) {
        this.processes = processes;
        this.quantum = quantum;
    }

    public double getAverageWaitTime() {
        ArrayList<Process> queue = new ArrayList<>(processes);
        int currentTime = 0;
        int totalWaitTime = 0;
        queue.sort((p1, p2) -> p1.getArrivalTime() - p2.getArrivalTime());

        while (!queue.isEmpty()) {
            Process p = queue.get(0);
            queue.remove(0);
            if (p.getBurstTime() <= quantum) {
                int waitTime = currentTime - p.getArrivalTime();
                totalWaitTime += waitTime;
                currentTime += p.getBurstTime();
            } else {
                int waitTime = currentTime - p.getArrivalTime();
                totalWaitTime += waitTime;
                currentTime += quantum;
                p.setBurstTime(p.getBurstTime() - quantum);
                p.setArrivalTime(currentTime);
                p.setWaitTime(currentTime);
                queue.add(p);
            }
        }

        return (double) totalWaitTime / processes.size();
    }
}
