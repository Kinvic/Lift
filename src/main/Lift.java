package main;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lift{
    private int currentFloor;
    private int finishFloor;
    private MOVE_STATUS status;
    public int priority;

    public Lift(int currentFloor, int finishFloor){
        this.currentFloor = currentFloor;
        this.finishFloor = finishFloor;
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

    public void setPriority(int priority) {
        this.priority = priority;
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

    private int distance(int userFloor){
        return Math.abs(currentFloor - userFloor);
    }

    public static Lift betterLift(List<Lift> list,int userFloor, MOVE_STATUS userStatus){
        for(Lift lift : list){
            lift.getPriority(userFloor, userStatus);
        }
        Collections.sort(list, new Comparator<Lift>() {
            @Override
            public int compare(Lift o1, Lift o2) {
                if(o1.priority == o2.priority){
                    return o1.distance(userFloor) - o2.distance(userFloor);
                }
                else {
                    return o2.priority - o1.priority;
                }
            }
        });
        return list.get(0);
    }

    private int getPriority(int userFloor, MOVE_STATUS userStatus){
        if(getStatus().equals(MOVE_STATUS.IDLE) && userFloor==currentFloor){
            priority=2;
        }
        else if(getStatus().equals(userStatus)){
            if(getStatus().equals(MOVE_STATUS.UP) && currentFloor < userFloor) {
                priority=1;
            }
            else if(getStatus().equals(MOVE_STATUS.DOWN) && currentFloor > userFloor){
                priority=1;
            }
            else{
                priority=-1;
            }
        }
        else if(getStatus().equals(MOVE_STATUS.IDLE)){
            priority=0;
        }
        else{
            priority=-1;
        }
        return priority;
    }
}