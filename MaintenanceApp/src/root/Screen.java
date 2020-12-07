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
    
    public void showMsg(String title, String msg) {
        JOptionPane.showMessageDialog(this, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean confirmDialog(String title, String msg) {
        int res = JOptionPane.showConfirmDialog(this, msg, title, JOptionPane.YES_NO_OPTION);
        return res == JOptionPane.YES_OPTION;
    }
}
