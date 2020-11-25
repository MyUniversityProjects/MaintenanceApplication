package root;

import javax.swing.JPanel;

abstract public class Screen extends JPanel {
    final Navigator nav;
    
    public Screen(Navigator nav) {
        this.nav = nav;
    }

    public Navigator getNav() {
        return nav;
    }
}
