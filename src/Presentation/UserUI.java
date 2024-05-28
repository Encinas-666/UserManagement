package Presentation;

import service.UserService;

import java.util.Scanner;

public class UserUI {
    private final Scanner scanner;
    private final UserService service;

    public UserUI(Scanner scanner, UserService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void run() {
        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Obtener usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Obtener todos los Usuarios");
            System.out.println("5. Salir");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    UtilsUser.registerUser(scanner, service);
                    break;
                case 2:
                    UtilsUser.getUser(scanner, service);
                    break;
                case 3:
                    UtilsUser.deleteUser(scanner, service);
                    break;
                case 4:
                    UtilsUser.allUsers(service);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elija nuevamente.");
            }
        }
    }
}
