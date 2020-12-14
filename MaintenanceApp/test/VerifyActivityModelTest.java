import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import root.entities.Activity;
import root.exceptions.NotFoundException;
import root.screens.verifyactivity.VerifyActivityModel;
import stubs.ActivityQueriesStub;

public class VerifyActivityModelTest {
    
    private class ListModelListener implements ListDataListener {
        int addedCount = 0;
        int removedCount = 0;
        
        @Override
        public void intervalAdded(ListDataEvent e) {
            addedCount += e.getIndex1() - e.getIndex0() + 1;
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            removedCount += e.getIndex1() - e.getIndex0() + 1;
        }

        @Override
        public void contentsChanged(ListDataEvent e) {}
    }
    
    VerifyActivityModel model;
    ActivityQueriesStub queryTool;
    
    @Before
    public void setUp() {
        queryTool = new ActivityQueriesStub();
        model = new VerifyActivityModel(queryTool.fetch(1), queryTool);
    }
    
    @Test
    public void testCreate() {
        Activity activity = queryTool.fetch(0);
        model = new VerifyActivityModel(activity, queryTool);
        
        // check activity fields
        assertEquals(activity.getId(), model.getId());
        assertEquals(activity.getArea(), model.getArea());
        assertEquals(activity.getBranchOffice(), model.getBranchOffice());
        assertEquals(activity.getDescription(), model.getDescription());
        assertEquals(activity.getNotes(), model.getNotes());
        assertEquals(activity.getTime(), model.getTime());
        assertEquals(activity.getType(), model.getType());
        assertEquals(activity.getTypology(), model.getTypology());
        assertEquals(activity.getWeek(), model.getWeek());
        assertEquals(activity.isInterruptible(), model.isInterruptible());
        // TODO: check inner models when materials, skills are implemented
    }
    
    @Test
    public void testForwardScheduled() {
        Activity activity = queryTool.fetch(0);
        activity.setType(Activity.ActivityType.PLANNED);
        model = new VerifyActivityModel(activity, queryTool);
        
        try {
            model.forward();
        } catch (NotFoundException ex) {
            fail("Foreward should not raise an exception");
        }
        
        assertEquals(1, queryTool.getForwardScheduledCounter());
        assertEquals(0, queryTool.getForwardEwoCounter());
    }
    
    @Test
    public void testForwardEwo() {
        Activity activity = queryTool.fetch(0);
        activity.setType(Activity.ActivityType.UNPLANNED);
        model = new VerifyActivityModel(activity, queryTool);
        
        try {
            model.forward();
        } catch (NotFoundException ex) {
            fail("Foreward should not raise an exception");
        }
        
        assertEquals(1, queryTool.getForwardEwoCounter());
        assertEquals(0, queryTool.getForwardScheduledCounter());
    }
    
    @Test
    public void testAddOneSkill() {
        ListModelListener skillListener = new ListModelListener();
        model.getSkillFillModel().getListModel().addListDataListener(skillListener);
        
        model.addSelectedSkill();
        assertEquals(1, skillListener.addedCount);
    }
    
    @Test
    public void testAddThreeSkills() {
        ListModelListener skillListener = new ListModelListener();
        model.getSkillFillModel().getListModel().addListDataListener(skillListener);
        
        ComboBoxModel comboBoxModel = model.getSkillFillModel().getComboModel();
        
        model.addSelectedSkill();
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(3));
        model.addSelectedSkill();
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(4));
        model.addSelectedSkill();
        assertEquals(3, skillListener.addedCount);
    }
    
    @Test
    public void testAddOneMaterial() {
        ListModelListener materialListener = new ListModelListener();
        model.getMaterialFillModel().getListModel().addListDataListener(materialListener);
        
        model.addSelectedMaterial();
        assertEquals(1, materialListener.addedCount);
    }
    
    @Test
    public void testAddThreeMaterial() {
        ListModelListener materialListener = new ListModelListener();
        model.getMaterialFillModel().getListModel().addListDataListener(materialListener);
        
        ComboBoxModel comboBoxModel = model.getMaterialFillModel().getComboModel();
        
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(0));
        model.addSelectedMaterial();
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(1));
        model.addSelectedMaterial();
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(2));
        model.addSelectedMaterial();
        assertEquals(3, materialListener.addedCount);
    }
    
    @Test
    public void testRemoveOneMaterial() {
        ListModelListener materialListener = new ListModelListener();
        model.getMaterialFillModel().getListModel().addListDataListener(materialListener);
        
        ComboBoxModel comboBoxModel = model.getMaterialFillModel().getComboModel();
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(4));
        
        model.addSelectedMaterial();
        model.removeSelectedMaterial();
        
        assertEquals(1, materialListener.removedCount);
    }
    
    @Test
    public void testRemoveThreeMaterial() {
        ListModelListener materialListener = new ListModelListener();
        model.getMaterialFillModel().getListModel().addListDataListener(materialListener);
        
        ComboBoxModel comboBoxModel = model.getMaterialFillModel().getComboModel();
        
        // Add materials
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(0));
        model.addSelectedMaterial();
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(1));
        model.addSelectedMaterial();
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(2));
        model.addSelectedMaterial();
        
        // Remove materials
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(1));
        model.removeSelectedMaterial();
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(0));
        model.removeSelectedMaterial();
        comboBoxModel.setSelectedItem(comboBoxModel.getElementAt(2));
        model.removeSelectedMaterial();
        
        assertEquals(3, materialListener.removedCount);
    }
}
