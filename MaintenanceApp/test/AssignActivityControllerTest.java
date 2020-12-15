import org.junit.Test;
import static org.junit.Assert.*;
import static root.screens.assignactivity.AssignActivityControllerMokeUp2.stringDay;
import static root.screens.assignactivity.AssignActivityControllerMokeUp1.sumIntVector;

public class AssignActivityControllerTest {
    
    @Test
    public void testStringDayMonday() {
        assertEquals("Monday", stringDay(1));
    }
    
    @Test
    public void testStringDayTuesday() {
        assertEquals("Tuesday", stringDay(2));
    }
    
    @Test
    public void testStringDayWednesday() {
        assertEquals("Wednesday", stringDay(3));
    }
    
    @Test
    public void testStringDayThursday() {
        assertEquals("Thursday", stringDay(4));
    }
    
    @Test
    public void testStringDayFriday() {
        assertEquals("Friday", stringDay(5));
    }
    
    @Test
    public void testStringDaySaturday() {
        assertEquals("Saturday", stringDay(6));
    }
    
    @Test
    public void testStringDaySun() {
        assertEquals("Sunday", stringDay(7));
    }

    @Test
    public void testStringDayBoundaries() {
        // test lower bounds
        assertNull(stringDay(0));
        assertEquals("Monday", stringDay(1));
        // test upper bounds
        assertEquals("Sunday", stringDay(7));
        assertNull(stringDay(8));
    }
    
    @Test
    public void testStringDayNegative() {
        assertNull(stringDay(-12));
    }
    
    @Test
    public void testStringDayBigNum() {
        assertNull(stringDay(50));
    }
    
    // null: 0
    @Test
    public void testSumIntVectorNull() {
        assertEquals(0, sumIntVector(null));
    }
    
    // []: 0
    @Test
    public void testSumIntVectorEmpty() {
        assertEquals(0, sumIntVector(new int[] {}));
    }
    
    // [0]: 0
    @Test
    public void testSumIntVectorOneZero() {
        assertEquals(0, sumIntVector(new int[] {0}));
    }
    
    // [2]: 2
    @Test
    public void testSumIntVectorOneValue() {
        assertEquals(2, sumIntVector(new int[] {2}));
    }
    
    // [2, 5]: 7
    @Test
    public void testSumIntVectorPositive() {
        assertEquals(7, sumIntVector(new int[] {2, 5}));
    }
    
    // [312, -2, 53]: 363
    @Test
    public void testSumIntVectorPositiveNegative() {
        assertEquals(363, sumIntVector(new int[] {312, -2, 53}));
    }
    
    // [-10, -10, -324]: -344
    @Test
    public void testSumIntVectorNegative() {
        assertEquals(-344, sumIntVector(new int[] {-10, -10, -324}));
    }
}
