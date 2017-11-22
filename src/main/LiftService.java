package main;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LiftService {
    private Lift lift;

    public LiftService(Lift lift){
        this.lift = lift;
    }

    private static void removeFullSloted(List<Lift> list){
        Iterator<Lift> iterator = list.iterator();

        while(iterator.hasNext()){

            if(iterator.next().getBusySlots() >= Lift.maxSlots){
                iterator.remove();
            }
        }
    }

    public static Lift betterLift(List<Lift> list, Person person){
            LiftService.removeFullSloted(list);
        for(Lift lift : list){
            LiftService liftService = new LiftService(lift);
            liftService.calcPriority(person);
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.getPriority() == o2.getPriority()){
                return o1.getDistance(person.getCurrentFloor()) - o2.getDistance(person.getCurrentFloor());
            }
            else {
                return o2.getPriority() - o1.getPriority();
            }
        });
        return list.get(0);
    }

    private int calcPriority(Person person){
            if(lift.getStatus().equals(MOVE_STATUS.IDLE) && person.getCurrentFloor() == lift.getCurrentFloor()){
                lift.setPriority(2);
            }
            else if(lift.getStatus().equals(person.getUserStatus())){
                if(lift.getStatus().equals(MOVE_STATUS.UP) && lift.getCurrentFloor() < person.getCurrentFloor()) {
                    lift.setPriority(1);
                }
                else if(lift.getStatus().equals(MOVE_STATUS.DOWN) && lift.getCurrentFloor() > person.getCurrentFloor()){
                    lift.setPriority(1);
                }
                else{
                    lift.setPriority(-1);
                }
            }
            else if(lift.getStatus().equals(MOVE_STATUS.IDLE)){
                lift.setPriority(0);
            }
            else{
                lift.setPriority(-1);
            }
        return lift.getPriority();
    }
}
