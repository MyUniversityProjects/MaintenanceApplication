import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import root.Navigable;
import root.Screen;
import root.screenbuilders.ScreenBuilder;
import root.screenbuilders.ScreenDirector;


public class ScreenDirectorTest {
    
    private class BuilderStub extends ScreenBuilder {
        private final List<String> opList = new LinkedList<>();

        @Override
        public void buildView(Navigable nav) {
            opList.add("view");
        }

        @Override
        public void buildController() {
            opList.add("controller");
        }

        @Override
        public void buildModel() {
            opList.add("model");
        }
        
        public String[] getOpArray() {
            String[] operations = new String[opList.size()];
            opList.toArray(operations);
            return operations;
        }

        @Override
        public Screen getScreen() {
            return null;
        }
    }
    
    private class SimpleBuilderStub extends ScreenBuilder {
        private Screen view;
        private boolean buildViewCalled = false;

        @Override
        public void buildView(Navigable nav) {
            buildViewCalled = true;
            view = new ScreenStub(nav);
        }

        public boolean isBuildViewCalled() {
            return buildViewCalled;
        }

        public Screen getBuildedView() {
            return view;
        }

        @Override
        public Screen getScreen() {
            return view;
        }
    }
    
    private class ScreenStub extends Screen {
        public ScreenStub(Navigable nav) {
            super(nav);
        }
    }
    
    /**
     * Test the build order that the director uses
     */
    @Test
    public void testBuildOrder() {
        BuilderStub stub = new BuilderStub();
        ScreenDirector.build(stub, null);
        String[] expected = {"model", "view", "controller"};
        assertArrayEquals(expected, stub.getOpArray());
    }
    
    /**
     * Test if we pass a builder with only buildView still works
     */
    @Test
    public void testSimpleBuild() {
        SimpleBuilderStub stub = new SimpleBuilderStub();
        ScreenDirector.build(stub, null);
        assertTrue(stub.isBuildViewCalled());
    }
    
    /**
     * Test if the director result is the builded view
     */
    @Test
    public void testBuildResult() {
        SimpleBuilderStub stub = new SimpleBuilderStub();
        Screen scr = ScreenDirector.build(stub, null);
        assertEquals(ScreenStub.class, scr.getClass());
        assertSame(stub.getBuildedView(), scr);
    }
}
