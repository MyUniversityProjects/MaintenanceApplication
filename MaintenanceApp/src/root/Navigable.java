package root;

import root.screenbuilders.ScreenBuilder;


public interface Navigable {
    public Screen push(ScreenBuilder sb);
    public Screen replace(ScreenBuilder sb);
    public Screen pop();
    public Screen goHome();
}
