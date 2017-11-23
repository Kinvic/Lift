package elevator;

public class Person {
    private int currentFloor;
    private int destinationFloor;
    private MOVE_STATUS userStatus;
    public Person(int currentFloor, int destinationFloor){
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        this.userStatus = getUserStatus();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public MOVE_STATUS getUserStatus(){
        if(currentFloor > destinationFloor){
            userStatus = MOVE_STATUS.DOWN;
        }
        else if(currentFloor < destinationFloor){
            userStatus = MOVE_STATUS.UP;
        }

        return userStatus;
    }

    public void setUserStatus(MOVE_STATUS userStatus) {
        this.userStatus = userStatus;
    }
}
