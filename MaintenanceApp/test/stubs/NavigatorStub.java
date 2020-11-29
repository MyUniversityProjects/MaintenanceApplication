package stubs;

import root.Navigable;
import root.Screen;
import root.screenbuilders.ScreenBuilder;

public class NavigatorStub implements Navigable {
    private int pushCallCount = 0;
    private int replaceCallCount = 0;
    private int popCallCount = 0;
    private int homeCallCount = 0;

    @Override
    public Screen push(ScreenBuilder sb) {
        pushCallCount++;
        return null;
    }

    @Override
    public Screen replace(ScreenBuilder sb) {
        replaceCallCount++;
        return null;
    }

    @Override
    public Screen pop() {
        popCallCount++;
        return null;
    }

    @Override
    public Screen goHome() {
        homeCallCount++;
        return null;
    }

    public int getPushCallCount() {
        return pushCallCount;
    }

    public int getReplaceCallCount() {
        return replaceCallCount;
    }

    public int getPopCallCount() {
        return popCallCount;
    }

    public int getHomeCallCount() {
        return homeCallCount;
    }
    
    
}
