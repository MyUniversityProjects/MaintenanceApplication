package entitiestest;

import org.junit.Test;
import static org.junit.Assert.*;
import root.entities.Activity;
import root.entities.Activity.ActivityType;


public class ActivityTest {
    
    @Test
    public void testTypeConvertPlanned() {
        assertEquals(ActivityType.PLANNED, Activity.convertRawType("PLANNED"));
    }
    
    @Test
    public void testTypeConvertUnplanned() {
        assertEquals(ActivityType.UNPLANNED, Activity.convertRawType("UNPLANNED"));
    }
    
    @Test
    public void testTypeConvertExtra() {
        assertEquals(ActivityType.EXTRA, Activity.convertRawType("EXTRA"));
    }
    
    @Test
    public void testTypeConvertNull() {
        assertNull(Activity.convertRawType(null));
    }
    
    @Test
    public void testTypeConvertEmpty() {
        assertNull(Activity.convertRawType(""));
    }
    
    @Test
    public void testTypeConvertLowerCasePlanned() {
        assertNull(Activity.convertRawType("planned"));
    }
    
    @Test
    public void testTypeConvertLowerCaseUnplanned() {
        assertNull(Activity.convertRawType("unplanned"));
    }
    
    @Test
    public void testTypeConvertLowerCaseExtra() {
        assertNull(Activity.convertRawType("extra"));
    }
    
    @Test
    public void testTypeConvertPlannedBoundaries() {
        assertNull(Activity.convertRawType(".PLANNED"));
        assertNull(Activity.convertRawType("PLANNED8"));
        assertNull(Activity.convertRawType("PLAN+NED"));
        assertNull(Activity.convertRawType("LANNED"));
        assertNull(Activity.convertRawType("PLANNE"));
    }
    
    @Test
    public void testTypeConvertUnplannedBoundaries() {
        assertNull(Activity.convertRawType("3UNPLANNED"));
        assertNull(Activity.convertRawType("UNPLANNEDà"));
        assertNull(Activity.convertRawType("UN*PLANNED"));
        assertNull(Activity.convertRawType("NPLANNED"));
        assertNull(Activity.convertRawType("UNPLANNE"));
    }
    
    @Test
    public void testTypeConvertExtraBoundaries() {
        assertNull(Activity.convertRawType(",EXTRA"));
        assertNull(Activity.convertRawType("EXTRA-"));
        assertNull(Activity.convertRawType("EXTR*A"));
        assertNull(Activity.convertRawType("XTRA"));
        assertNull(Activity.convertRawType("EXTR"));
    }
}
