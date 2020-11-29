import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import root.Navigable;
import root.screens.verifyactivity.VerifyActivityController;
import root.screens.verifyactivity.VerifyActivityModel;
import root.screens.verifyactivity.VerifyActivityView;
import stubs.NavigatorStub;


public class VerifyActivityControllerTest {
    
    private class ViewStub extends VerifyActivityView {
        JButton smp = new JButton();
        JButton forward = new JButton();
        JButton back = new JButton();
        JButton home = new JButton();
        int forwardListenerCount = 0;
        int smpListenerCount = 0;
        int backListenerCount = 0;
        int homeListenerCount = 0;
        
        public ViewStub(Navigable nav, ModelStub model) {
            super(nav, model);
        }

        @Override
        public void addSmpBtnListener(ActionListener al) {
            smp.addActionListener(al);
            smpListenerCount++;
        }

        @Override
        public void addForwardBtnListener(ActionListener al) {
            forward.addActionListener(al);
            forwardListenerCount++;
        }

        @Override
        public void addHomeBtnListener(ActionListener al) {
            home.addActionListener(al);
            homeListenerCount++;
        }

        @Override
        public void addBackBtnListener(ActionListener al) {
            back.addActionListener(al);
            backListenerCount++;
        }
    }
    
    private class ModelStub extends VerifyActivityModel {
        int forwardCallCount;

        public ModelStub() {
            super(1, null, null, null, null, 1, true, 1, null, null);
        }

        @Override
        public void forward() {
            forwardCallCount++;
        }
    }
    
    VerifyActivityController controller;
    ViewStub view;
    ModelStub model;
    NavigatorStub nav;
    
    @Before
    public void setUp() {
        nav = new NavigatorStub();
        model = new ModelStub();
        view = new ViewStub(nav, model);
        controller = new VerifyActivityController(model, view);
    }
    
    @Test
    public void testRegisterListeners() {
        assertEquals(1, view.forwardListenerCount);
        assertEquals(1, view.smpListenerCount);
        assertEquals(1, view.backListenerCount);
        assertEquals(1, view.homeListenerCount);
    }
    
    @Test
    public void testForwardListenerAction() {
        view.forward.doClick();
        assertEquals(1, model.forwardCallCount);
    }
    
    @Test
    public void testBackListenerAction() {
        view.back.doClick();
        assertEquals(1, nav.getPopCallCount());
    }
    
    @Test
    public void testHomeListenerAction() {
        view.home.doClick();
        assertEquals(1, nav.getHomeCallCount());
    }
}
