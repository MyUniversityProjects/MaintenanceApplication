package root.screens.listscheduledactivitiesbyweek;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import root.screenbuilders.VerifyActivityBuilder;
import ui.ButtonColumnActionListener;

public class ListScheduledActivitiesByWeekController {
    // Need a reference to both the model and the view
    private ListScheduledActivitiesByWeekView view;
    private ListScheduledActivitiesByWeekModel model;

    /**
     * Create the controller and register buttons listeners of the view
     * @param model the model of the view
     * @param view the view to control
     */
    public ListScheduledActivitiesByWeekController(ListScheduledActivitiesByWeekView view, ListScheduledActivitiesByWeekModel model) {
        this.view = view;
        this.model = model;
        // The controller needs to listen to the view
        this.view.addBackButtonListener(new BackButtonListener());
        this.view.addNumWeeKBoxListener(new NumWeekComboBoxListener());
        this.view.setSelectButtonListener(new SelectButtonListener());
    }
    
    // Inner classess which server as view listeners
    private class BackButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            view.toThePreviousScreen();
        }
    }
    
    private class SelectButtonListener implements ButtonColumnActionListener {
        @Override
        public void actionPerformed(int rowIndex) {
            int id =  model.getSelectedActivity(rowIndex);
            view.getNav().push(new VerifyActivityBuilder(id));        
        }
    }
    
    private class NumWeekComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            model.setNumWeek(view.getSelectedComboBoxInteger());
        }
    }
    
    
    
}
