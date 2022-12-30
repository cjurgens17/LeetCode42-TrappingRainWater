import static org.junit.Assert.*;

public class LC42Test {

    @org.junit.Test
    public void trappingWater() {

        int actual1 = LC42.trappingWater(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
        int actual2 = LC42.trappingWater(new int[] {4,2,0,3,2,5});

        assertEquals(actual1, 6);
        assertEquals(actual2, 9);
    }
}