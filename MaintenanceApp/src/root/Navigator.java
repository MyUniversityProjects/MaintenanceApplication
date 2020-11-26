package root;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import root.exceptions.EmptyNavigatorException;
import root.screenbuilders.ScreenBuilder;
import root.screenbuilders.ScreenDirector;


final public class Navigator extends JFrame {
    private final CardLayout cl = new CardLayout();
    private final JPanel cards = new JPanel(cl);
    private int index = -1;
    
    /**
     * Create a new Navigator
     * @param title used to show the title of the frame
     * @param homeBuilder used to build the home screen
     */
    public Navigator(String title, ScreenBuilder homeBuilder) {
        setTitle(title);
        setContentPane(cards);
        push(homeBuilder);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
    
    /**
     * Create and show a new screen.
     * @param sb builder used to create and show the new screen
     * @return the new screen
     */
    public Screen push(ScreenBuilder sb) {
        Screen screen = ScreenDirector.build(sb, this);
        cards.add(screen);
        cl.next(cards);
        index++;
        return screen;
    }
    
    /**
     * Replace the current screen with a new one.
     * @param sb builder used to create and show the new screen
     * @return the replaced screen
     * @throws EmptyNavigatorException
     */
    public Screen replace(ScreenBuilder sb) {
        if (index < 0)
            throw new EmptyNavigatorException();
        // Save and remove the screen on top
        Screen removed = (Screen)cards.getComponent(index);
        cards.remove(index);
        // Add the new screen and show it
        Screen screen = ScreenDirector.build(sb, this);
        cards.add(screen);
        cl.last(cards);
        
        return removed; // return the saved (deleted) screen
    }
    
    /**
     * Remove the current screen and show the previous one.
     * @return the removed screen
     * @throws EmptyNavigatorException
     */
    public Screen pop() {
        if (index < 0)
            throw new EmptyNavigatorException();
        cl.previous(cards);
        Screen removed = (Screen)cards.getComponent(index);
        cards.remove(index);
        index--;
        return removed;
    }
    
    /**
     * removes all screens except the first one (home) to show it.
     * @return the home screen (first screen)
     * @throws EmptyNavigatorException
     */
    public Screen goHome() {
        if (index < 0)
            throw new EmptyNavigatorException();
        cl.first(cards);
        for (int i=index; i > 0; i--)
            cards.remove(i);
        index = 0;
        return (Screen)cards.getComponent(0);
    }
}
