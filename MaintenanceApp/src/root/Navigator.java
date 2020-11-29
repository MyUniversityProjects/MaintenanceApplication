package root;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import root.exceptions.EmptyNavigatorException;
import root.screenbuilders.ScreenBuilder;
import root.screenbuilders.ScreenDirector;


final public class Navigator extends JFrame implements Navigable {
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
        setResizable(false);
        setContentPane(cards);
        push(homeBuilder);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
    
    /**
     * Create and show a new screen.
     * @param sb builder used to create and show the new screen
     * @return the new screen
     */
    @Override
    public Screen push(ScreenBuilder sb) {
        Screen screen = ScreenDirector.build(sb, this);
        cards.add(screen);
        cl.next(cards);
        index++;
        
        updateFrameSize(screen);
        
        return screen;
    }
    
    /**
     * Replace the current screen with a new one.
     * @param sb builder used to create and show the new screen
     * @return the replaced screen
     * @throws EmptyNavigatorException
     */
    @Override
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
        
        updateFrameSize(screen);
        
        return removed; // return the saved (deleted) screen
    }
    
    /**
     * Remove the current screen and show the previous one.
     * @return the removed screen
     * @throws EmptyNavigatorException
     */
    @Override
    public Screen pop() {
        if (index < 0)
            throw new EmptyNavigatorException();
        cl.previous(cards);
        Screen removed = (Screen)cards.getComponent(index);
        cards.remove(index);
        index--;
        
        if (index >= 0)
            updateFrameSize((Screen)cards.getComponent(index));
        
        return removed;
    }
    
    /**
     * removes all screens except the first one (home) to show it.
     * @return the home screen (first screen)
     * @throws EmptyNavigatorException
     */
    @Override
    public Screen goHome() {
        if (index < 0)
            throw new EmptyNavigatorException();
        cl.first(cards);
        for (int i=index; i > 0; i--)
            cards.remove(i);
        index = 0;
        
        Screen homeScreen = (Screen)cards.getComponent(0);
        updateFrameSize(homeScreen);
        return homeScreen;
    }
    
    /**
     * Set the frame size equal to the screen preferred size
     * @param scr used the get the new size
     */
    private void updateFrameSize(Screen scr) {
        EventQueue.invokeLater(() -> {
            setSize(scr.getPreferredSize());
            setLocationRelativeTo(null);
        });
    }
}
