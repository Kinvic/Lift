package elevator;

public class Lift{
    private int currentFloor;
    private int finishFloor;
    private MOVE_STATUS status;
    private int priority;
    public static final int MAX_SLOTS = 5;
    private int busySlots;

    public Lift(int currentFloor, int finishFloor, int busySlots){
        this.currentFloor = currentFloor;
        this.finishFloor = finishFloor;
        this.busySlots = busySlots;
        status = getStatus();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getFinishFloor() {
        return finishFloor;
    }

    public void setFinishFloor(int finishFloor) {
        this.finishFloor = finishFloor;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getBusySlots() {
        return busySlots;
    }

    public void setBusySlots(int busySlots) {
        this.busySlots = busySlots;
    }

    public MOVE_STATUS getStatus(){
        if(currentFloor - finishFloor > 0){
            status = MOVE_STATUS.DOWN;
        }
        else if(currentFloor - finishFloor < 0){
            status = MOVE_STATUS.UP;
        }
        else{
            status = MOVE_STATUS.IDLE;
        }
        return status;
    }

    public void setStatus(MOVE_STATUS status){
        this.status = status;
    }

    public int getDistance(int userFloor){
        return Math.abs(getCurrentFloor() - userFloor);
    }
}