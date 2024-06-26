import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 1, 0, 5));
        processes.add(new Process("P2", 2, 1, 3));
        processes.add(new Process("P3", 3, 2, 8));
        processes.add(new Process("P4", 4, 2, 6));
        processes.add(new Process("P5", 5, 4, 9));
        processes.add(new Process("P6", 6, 4, 3));
        processes.add(new Process("P7", 7, 4, 5));

        FCFS fcfs = new FCFS(processes);
        System.out.println("Average wait time of fcfs: " + fcfs.getAverageWaitTime());
        SJF sjf = new SJF(processes);
        System.out.println("Average wait time of sjf: " + sjf.getAverageWaitTime());
        PreemtiveSJF preemptiveSJF = new PreemtiveSJF(processes);
        System.out.println("Average wait time of preemptiveSJF: " + preemptiveSJF.getAverageWaitTime());
        ROT rot = new ROT(processes, 4);
        System.out.println("Average wait time of roundRobin: " + rot.getAverageWaitTime());

    }
}
