package test;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import elevator_system.Lift;
import elevator_system.LiftService;
import elevator_system.Person;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class Test {
    @org.junit.Test
    @UseDataProvider("dataProvider")
    public void testResults(Lift lift1, Lift lift2, Person person) {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(lift1);
        lifts.add(lift2);

        assertEquals(lift2, LiftService.betterLift(lifts, person));

    }

    @DataProvider
    public static Object[] dataProvider(){
       return new Object[][]{
               {new Lift(6,7,3), new Lift(4,5,2), new Person(6,9)},
               {new Lift(10,12,2),new Lift(3,1,4),new Person(2,6)},
               {new Lift(6,6,0),new Lift(1,4,4),new Person(4,6)}
       };
    }
}
