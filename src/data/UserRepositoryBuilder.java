package data;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryBuilder {
    private final Map<String, User> users = new HashMap<>();

    public UserRepositoryBuilder addUser(User user) {
        users.put(user.getEmail(), user);
        return this;
    }

    public UserRepositoryImpl build() {
        return new UserRepositoryImpl(users);
    }
}
