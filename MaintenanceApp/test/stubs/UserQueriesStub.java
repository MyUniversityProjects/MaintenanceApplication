package stubs;

import queries.UserQueries;
import root.entities.User;

public class UserQueriesStub extends UserQueries {
    private int deleteCallCount = 0;
    private int fetchAllCallCount = 0;

    public int getDeleteCallCount() {
        return deleteCallCount;
    }

    public int getFetchAllCallCount() {
        return fetchAllCallCount;
    }

    @Override
    public boolean delete(String cf) {
        deleteCallCount++;
        return true;
    }

    @Override
    public User[] fetchPlannersMaintainers() {
        fetchAllCallCount++;
        User[] users = {
            new User("AAAA", "username-1", User.UserRole.SYSTEM_ADMINISTRATOR, "name-1", "surname-1", "email-1", "address-1"),
            new User("BBBB", "username-2", User.UserRole.MAINTAINER, "name-2", "surname-2", "email-2", "address-2"),
            new User("CCCC", "username-3", User.UserRole.PLANNER, "name-3", "surname-3", "email-3", "address-3"),
            new User("DDDD", "username-4", User.UserRole.MAINTAINER, "name-4", "surname-4", "email-4", "address-4"),
        };
        return users;
    }

}
