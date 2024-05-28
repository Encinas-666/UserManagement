package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository{
    private final Map<String, User> users;

    public UserRepositoryImpl(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public void saveUser(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public User getUser(String email) {
        return users.get(email);
    }

    @Override
    public void deleteUser(String email) {
        users.remove(email);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
