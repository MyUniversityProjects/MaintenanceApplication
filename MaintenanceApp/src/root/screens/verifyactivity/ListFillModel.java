package root.screens.verifyactivity;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class ListFillModel {
    private static final String PREFIX = "\t• ";
    
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();

    public ListFillModel(String[] listItems, String[] comboItems) {
        for (String listItem: listItems)
            listModel.addElement(PREFIX + listItem);
        for (String comboItem: comboItems)
            comboModel.addElement(comboItem);
    }

    public ListModel<String> getListModel() {
        return listModel;
    }

    public ComboBoxModel<String> getComboModel() {
        return comboModel;
    }
    
    /**
     * Extract and return all the elements in the list model
     * @return an array of elements
     */
    public String[] getElements() {
        String[] elements = new String[listModel.size()];
        listModel.copyInto(elements);
        for (int i=0; i < elements.length; i++)
            elements[i] = elements[i].substring(PREFIX.length());
        return elements;
    }
    
    /**
     * Add to the list model the current selected item in the combo box model.
     * @return true if the element is added successfully; otherwise false
     */
    public boolean addSelected() {
        String item = getSelected();
        if (item == null || listModel.contains(item)) return false;
        listModel.addElement(item);
        return true;
    }
    
    /**
     * Remove from the list model the current selected item in the combo box 
     * model.
     * @return true if the element is removed successfully; otherwise false
     */
    public boolean removeSelected() {
        String item = getSelected();
        if (item == null || !listModel.contains(item)) return false;
        listModel.removeElement(item);
        return true;
    }
    
    private String getSelected() {
        String item = (String) comboModel.getSelectedItem();
        return item != null ? PREFIX + item : null;
    }
}
