public class Process {

    private int id;
    private int arrivalTime;
    private int burstTime;
    private int waitTime;
    public boolean preempted;
    private boolean isQuantum;

    public Process(String name, int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitTime = 0;
        this.preempted = false;
        this.isQuantum = false;
    }

    public int getId() {
        return id;
    }

    public boolean isQuantum() {
        return isQuantum;
    }

    public void setQuantum(boolean isQuantum) {
        this.isQuantum = isQuantum;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
}
