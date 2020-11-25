package root;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import root.screenbuilders.ScreenBuilder;


final public class Navigator extends JFrame {
    private final CardLayout cl = new CardLayout();
    private final JPanel cards = new JPanel(cl);
    private int index = 0;
    
    public Navigator(String title, ScreenBuilder homeBuilder) {
        setTitle(title);
        setContentPane(cards);
        goHome();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
    
    public Screen push(ScreenBuilder sb) {
        return null;
    }
    
    public Screen replace(ScreenBuilder sb) {
        return null;
    }
    
    public Screen pop() {
        return null;
    }
    
    public Screen goHome() {
        return null;
    }
}
