package test;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import main.Lift;
import main.MOVE_STATUS;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class Test {
    @org.junit.Test
    @UseDataProvider("dataProvider")
    public void testResults(Lift lift1, Lift lift2, int userFloor, MOVE_STATUS status) {
        List<Lift> lifts = new ArrayList<>();
        lifts.add(lift1);
        lifts.add(lift2);

        assertTrue(Lift.betterLift(lifts,userFloor,status).equals(lift2));
    }

    @DataProvider
    public static Object[] dataProvider(){
       return new Object[][]{
               {new Lift(6,7), new Lift(4,5), 7, MOVE_STATUS.DOWN},
               {new Lift(10,12),new Lift(3,1),4,MOVE_STATUS.UP},
               {new Lift(6,6),new Lift(1,4),6,MOVE_STATUS.UP}
       };
    }
}
