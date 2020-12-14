import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import root.Navigable;
import root.screens.verifyactivity.VerifyActivityController;
import root.screens.verifyactivity.VerifyActivityModel;
import root.screens.verifyactivity.VerifyActivityView;
import stubs.ActivityQueriesStub;
import stubs.NavigatorStub;


public class VerifyActivityControllerTest {
    
    private class ViewStub extends VerifyActivityView {
        String timeValue = "10";
        JButton smp = new JButton();
        JButton forward = new JButton();
        JButton back = new JButton();
        JButton home = new JButton();
        JButton addMaterial = new JButton();
        JButton addSkill = new JButton();
        JButton removeMaterial = new JButton();
        JButton removeSkill = new JButton();
        // counters of register calls
        int forwardListenerCount = 0;
        int smpListenerCount = 0;
        int backListenerCount = 0;
        int homeListenerCount = 0;
        int addMaterialListenerCount = 0;
        int addSkillListenerCount = 0;
        int removeMaterialListenerCount = 0;
        int removeSkillListenerCount = 0;
        
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

        @Override
        public void addMaterialRemoveBtnListener(ActionListener al) {
            removeMaterial.addActionListener(al);
            removeMaterialListenerCount++;
        }

        @Override
        public void addMaterialAddBtnListener(ActionListener al) {
            addMaterial.addActionListener(al);
            addMaterialListenerCount++;
        }

        @Override
        public void addSkillAddBtnListener(ActionListener al) {
            addSkill.addActionListener(al);
            addSkillListenerCount++;
        }
        
        @Override
        public void addSkillRemoveBtnListener(ActionListener al) {
            removeSkill.addActionListener(al);
            removeSkillListenerCount++;
        }
        
        @Override
        public String getTimeValue() {
            return timeValue;
        }
    }
    
    private class ModelStub extends VerifyActivityModel {
        int forwardCallCount = 0;
        int removeMaterialCallCount = 0;
        int addMaterialCallCount = 0;
        int addSkillCallCount = 0;
        int removeSkillCallCount = 0;

        public ModelStub() {
            super(new ActivityQueriesStub().fetch(1), new ActivityQueriesStub());
        }
        
        @Override
        public void removeSelectedMaterial() {
            removeMaterialCallCount++;
        }

        @Override
        public void addSelectedMaterial() {
            addMaterialCallCount++;
        }
        
        @Override
        public void addSelectedSkill() {
            addSkillCallCount++;
        }
        
        @Override
        public void removeSelectedSkill() {
            removeSkillCallCount++;
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
        assertEquals(1, view.addSkillListenerCount);
        assertEquals(1, view.addMaterialListenerCount);
        assertEquals(1, view.removeMaterialListenerCount);
        assertEquals(1, view.removeSkillListenerCount);
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
    
    @Test
    public void testAddMaterialListenerAction() {
        view.addMaterial.doClick();
        assertEquals(1, model.addMaterialCallCount);
    }
    
    @Test
    public void testRemoveMaterialListenerAction() {
        view.removeMaterial.doClick();
        assertEquals(1, model.removeMaterialCallCount);
    }
    
    @Test
    public void testAddSkillListenerAction() {
        view.addSkill.doClick();
        assertEquals(1, model.addSkillCallCount);
    }
    
    @Test
    public void testRemoveSkillListenerAction() {
        view.removeSkill.doClick();
        assertEquals(1, model.removeSkillCallCount);
    }
    
    @Test
    public void testIsValidTimeInputNegative() {
        view.timeValue = "-10";
        assertFalse(controller.isTimeInputValid());
    }
    
    @Test
    public void testIsValidTimeInputPositive() {
        view.timeValue = "10";
        assertTrue(controller.isTimeInputValid());
    }
    
    @Test
    public void testIsValidTimeInputBoundaries() {
        view.timeValue = "0";
        assertFalse(controller.isTimeInputValid());
        view.timeValue = "1";
        assertTrue(controller.isTimeInputValid());
    }
    
    @Test
    public void testIsValidTimeInputNaN() {
        view.timeValue = "paro";
        assertFalse(controller.isTimeInputValid());
    }
    
    @Test
    public void testIsValidTimeInputNaNBoundaries() {
        view.timeValue = "10a";
        assertFalse(controller.isTimeInputValid());
        view.timeValue = "t140";
        assertFalse(controller.isTimeInputValid());
    }
}
