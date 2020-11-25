package root;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import root.screenbuilders.ScreenBuilder;


final public class Navigator extends JFrame {
    private final CardLayout cl = new CardLayout();
    private final JPanel cards = new JPanel(cl);
    private int index = 0;
    
    public Navigator() {
        setTitle("Smart Maintenance App");
        setContentPane(cards);
        reset();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
    
    public void push(ScreenBuilder sb) {}
    
    public void replace() {}
    
    public void pop() {}
    
    public void reset() {}
}
