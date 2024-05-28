package data;

import java.util.List;
public interface UserRepository {
    void saveUser(User user);
    User getUser(String email);
    void deleteUser(String email);
    List<User> getAllUsers();
}
