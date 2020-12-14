package ui;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 * Rappresents the model of a fill operation with a selection.
 * To do this, there is a listModel to save the elements selected and a combo
 * box model used to select the element to add in the list.
 * It is not possibile to add duplicate elements
 */
public class ListFillModel {
    public static final String PREFIX = "\t• ";
    
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
    
    /**
     * Create an instance of ListFillModel and fill the list and combo model
     * @param listItems items to add to the list
     * @param comboItems items to add to the combo box
     */
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
     * Return all the elements in the list model
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
