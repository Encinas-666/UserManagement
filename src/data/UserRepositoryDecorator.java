package data;

import java.util.List;

public class UserRepositoryDecorator implements UserRepository{
    protected UserRepository userRepository;

    public UserRepositoryDecorator (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    @Override
    public User getUser(String email) {
        return userRepository.getUser(email);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

}
