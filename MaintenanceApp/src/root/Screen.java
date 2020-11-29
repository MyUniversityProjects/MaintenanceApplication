package root;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

abstract public class Screen extends JPanel {
    final Navigable nav;
    
    public Screen(Navigable nav) {
        this.nav = nav;
    }

    public Navigable getNav() {
        return nav;
    }
    
    public void showErrorMsg(String title, String msg) {
        JOptionPane.showMessageDialog(this, msg, title, JOptionPane.ERROR_MESSAGE);
    }
}
