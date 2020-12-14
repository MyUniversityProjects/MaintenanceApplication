import javax.swing.ComboBoxModel;
import javax.swing.ListModel;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import ui.ListFillModel;

public class ListFillModelTest {
    
    ListFillModel model;
    ListModel<String> listModel;
    ComboBoxModel<String> comboModel;
    String[] listElements = {"Item2", "Item5"};
    String[] comboElements = {"Item1", "Item2", "Item3", "Item4", "Item5"};
    
    @Before
    public void setUp() {
        model = new ListFillModel(listElements, comboElements);
        listModel = model.getListModel();
        comboModel = model.getComboModel();
    }

    @Test
    public void testInitialElements() {
        assertArrayEquals(listElements, model.getElements());
    }
    
    @Test
    public void testInitialListElements() {
        assertEquals(listModel.getSize(), listElements.length);
        for (int i=0; i<listElements.length; i++) {
            assertEquals(ListFillModel.PREFIX + listElements[i], listModel.getElementAt(i));
        }
    }
    
    @Test
    public void testInitialComboElements() {
        assertEquals(comboModel.getSize(), comboElements.length);
        for (int i=0; i<comboElements.length; i++) {
            assertEquals(comboElements[i], comboModel.getElementAt(i));
        }
    }
    
    @Test
    public void testAddAlreadyPresent() {
        comboModel.setSelectedItem("Item5");
        model.addSelected();
        assertArrayEquals(listElements, model.getElements());
    }
    
    @Test
    public void testAddNotPresent() {
        comboModel.setSelectedItem("Item1");
        model.addSelected();
        String[] expected = {"Item2", "Item5", "Item1"};
        assertArrayEquals(expected, model.getElements());
    }
    
    @Test
    public void testRemoveAlreadyPresent() {
        comboModel.setSelectedItem("Item2");
        model.removeSelected();
        String[] expected = {"Item5"};
        assertArrayEquals(expected, model.getElements());
    }
    
    @Test
    public void testRemoveNotPresent() {
        comboModel.setSelectedItem("Item3");
        model.removeSelected();
        assertArrayEquals(listElements, model.getElements());
    }
}
