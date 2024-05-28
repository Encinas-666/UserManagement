package service;

import data.User;
import data.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        userRepository.saveUser(user);
    }

    public User getUser(String email) {
        return userRepository.getUser(email);
    }

    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
}
