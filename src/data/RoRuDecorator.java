package data;

import java.util.List;

public class RoRuDecorator extends UserRepositoryDecorator {
    public RoRuDecorator(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public void saveUser(User user) {
        System.out.println("Guardando usuario: " + user);
        super.saveUser(user);
    }

    @Override
    public User getUser(String email) {
        System.out.println("Obteniendo usuario por email: " + email);
        return super.getUser(email);
    }

    @Override
    public void deleteUser(String email) {
        System.out.println("Eliminando usuario por email: " + email);
        super.deleteUser(email);
    }

    @Override
    public List<User> getAllUsers(){
        System.out.println("Usuarios:");
        return super.getAllUsers();
    }
}
