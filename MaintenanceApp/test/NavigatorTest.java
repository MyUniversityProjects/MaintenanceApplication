import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import root.Navigator;
import root.Screen;
import root.exceptions.EmptyNavigatorException;
import root.screenbuilders.ScreenBuilder;


public class NavigatorTest {
    private class ScreenStubBuilder extends ScreenBuilder {
        private final String name;

        public ScreenStubBuilder(String name) {
            this.name = name;
        }
        
        @Override
        public void buildView(Navigator nav) {
            view = new ScreenStub(nav, name);
        }
    }
    
    private class ScreenStub extends Screen {
        public final String name;
        
        public ScreenStub(Navigator nav, String name) {
            super(nav);
            this.name = name;
        }
    }
    
    Navigator nav;
    
    @Before
    public void setUp() {
        nav = new Navigator("test", new ScreenStubBuilder("home-screen"));
    }
    
    @Test
    public void testPushOne() {
        Screen scr = nav.push(new ScreenStubBuilder("pushed-screen"));
        assertScreenStub(scr, "pushed-screen");
    }
    
    @Test
    public void testPushThree() {
        nav.push(new ScreenStubBuilder("first-screen"));
        nav.push(new ScreenStubBuilder("second-screen"));
        Screen scr = nav.push(new ScreenStubBuilder("third-screen"));
        assertScreenStub(scr, "third-screen");
    }
    
    @Test
    public void testPopHomeScreen() {
        assertScreenStub(nav.pop(), "home-screen");
    }
    
    @Test
    public void testPopFirstScreen() {
        nav.push(new ScreenStubBuilder("first-screen"));
        assertScreenStub(nav.pop(), "first-screen");
    }
    
    @Test
    public void testPopThirdScreen() {
        nav.push(new ScreenStubBuilder("first-screen"));
        nav.push(new ScreenStubBuilder("second-screen"));
        nav.push(new ScreenStubBuilder("third-screen"));
        
        assertScreenStub(nav.pop(), "third-screen");
    }
    
    @Test
    public void testNavigatorScreensOrder() {
        nav.push(new ScreenStubBuilder("first-screen"));
        nav.push(new ScreenStubBuilder("second-screen"));
        
        assertScreenStub(nav.pop(), "second-screen");
        assertScreenStub(nav.pop(), "first-screen");
        assertScreenStub(nav.pop(), "home-screen");
    }
    
    @Test(expected=EmptyNavigatorException.class)
    public void testPopEmptyNavigator() {
        nav.pop();
        nav.pop();
    }
    
    @Test
    public void testReplaceHomeScreen() {
        Screen scr = nav.replace(new ScreenStubBuilder("replac-screen"));
        assertScreenStub(scr, "home-screen");
    }
    
    @Test
    public void testReplaceSecondScreen() {
        nav.push(new ScreenStubBuilder("first-screen"));
        nav.push(new ScreenStubBuilder("second-screen"));
        
        Screen scr = nav.replace(new ScreenStubBuilder("third-screen"));
        assertScreenStub(scr, "second-screen");
    }
    
    @Test
    public void testPrevScreenOnReplace() {
        nav.push(new ScreenStubBuilder("first-screen"));
        nav.push(new ScreenStubBuilder("second-screen"));
        
        nav.replace(new ScreenStubBuilder("third-screen"));
        assertScreenStub(nav.pop(), "third-screen");
        assertScreenStub(nav.pop(), "first-screen");
    }
    
    @Test(expected=EmptyNavigatorException.class)
    public void testReplaceEmptyNavigator() {
        nav.pop();
        nav.replace(new ScreenStubBuilder("invalid-operation"));
    }
    
    @Test
    public void testGoHomeFromHomeScreen() {
        assertScreenStub(nav.goHome(), "home-screen");
    }
    
    @Test
    public void testGoHomeFromThirdScreen() {
        nav.push(new ScreenStubBuilder("first-screen"));
        nav.push(new ScreenStubBuilder("second-screen"));
        nav.push(new ScreenStubBuilder("third-screen"));
        
        assertScreenStub(nav.goHome(), "home-screen");
    }
    
    @Test(expected=EmptyNavigatorException.class)
    public void testGoHomeEmptyNavigator() {
        nav.pop();
        nav.goHome();
    }
    
    private void assertScreenStub(Screen scr, String name) {
        assertNotNull(scr);
        assertEquals(ScreenStub.class, scr.getClass());
        ScreenStub s = (ScreenStub)scr;
        assertEquals(name, s.name);
        assertSame(nav, s.getNav());
    }
}
