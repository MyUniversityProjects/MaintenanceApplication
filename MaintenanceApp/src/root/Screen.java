package root;

import javax.swing.JPanel;

abstract public class Screen extends JPanel {
    final Navigable nav;
    
    public Screen(Navigable nav) {
        this.nav = nav;
    }

    public Navigable getNav() {
        return nav;
    }
}
