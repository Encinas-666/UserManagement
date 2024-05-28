package Presentation;
import data.User;
import data.UserBuilder;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class UtilsUser {
    public static void registerUser(Scanner scanner, UserService service) {
        System.out.println("Ingrese el nombre del usuario:");
        String nombre = scanner.next();
        System.out.println("Ingrese el email del usuario:");
        String email = scanner.next();
        User user = new UserBuilder()
                .name(nombre)
                .email(email)
                .build();
        service.registerUser(user);
        System.out.println("Usuario registrado exitosamente.");
    }

    public static void getUser(Scanner scanner, UserService service) {
        System.out.println("Ingrese el email del usuario:");
        String email = scanner.next();
        User user = service.getUser(email);
        if (user != null) {
            System.out.println("Usuario encontrado: " + user);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void deleteUser(Scanner scanner, UserService service) {
        System.out.println("Ingrese el email del usuario a eliminar:");
        String email = scanner.next();
        service.deleteUser(email);
        System.out.println("Usuario eliminado exitosamente.");
    }

    public static void allUsers(UserService service) {
        List<User> users = service.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}
