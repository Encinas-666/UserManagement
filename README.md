# Proyecto de Arquitectura de 3 Capas con Principios SOLID y Patrones de Diseño

## Descripción del Proyecto

Este proyecto implementa una arquitectura de 3 capas (Presentación, Negocio y Datos) utilizando principios SOLID y varios patrones de diseño (Builder, Decorator y Strategy). La aplicación permite registrar, obtener, eliminar y listar usuarios a través de una interfaz de usuario en consola.

## Requisitos Previos

- Java Development Kit (JDK) 8 o superior
- Git

## Pasos para Ejecutar el Proyecto

1. **Clonar el Repositorio**

   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repositorio.git
   cd nombre-del-repositorio
2. **Abrir el Proyecto en IntelliJ IDEA**
     - Abre IntelliJ IDEA.
     - Selecciona File -> Open y navega hasta el directorio del proyecto clonado.
     - IntelliJ IDEA detectará el proyecto y sugerirá importar las dependencias de Maven. Acepta y permite que IntelliJ descargue todas las dependencias necesarias.
3. **Ejecutar la Aplicación**
     - En IntelliJ IDEA, abre la clase Main ubicada en src/main/java/presentation/Main.java.
     - Haz clic derecho en la clase Main y selecciona Run 'Main.main()'.

## Documentación del Proyecto

### Principios SOLID

1. **Single Responsibility Principle (SRP)**

     - Clase: User: Representar un usuario con sus atributos.
     - Clase: UserService: Contener la lógica de negocio relacionada con los usuarios.
     - Clase: UserRepositoryImpl: Manejar las operaciones de almacenamiento de datos de usuarios.
     - Clase: UserUI: Interactuar con el usuario y capturar los datos.
       
2. **Open/Closed Principle (OCP)**

     - Clase: RoRuDecorator: Extendido sin modificar: Añade registro de operaciones a las funciones del repositorio de usuarios.

3. **Liskov Substitution Principle (LSP)**

     - Interfaz: UserRepository
       - Implementaciones: UserRepositoryImpl, RoRuDecorator
         Las implementaciones pueden ser utilizadas indistintamente donde se espere la interfaz UserRepository.

4. **Interface Segregation Principle (ISP)**

Aplicable a futuras expansiones donde se dividan interfaces más grandes en interfaces específicas y pequeñas.

5. **Dependency Inversion Principle (DIP)**

     - Clase: UserService
       - Dependencia: UserRepository (interfaz)
         Depende de una abstracción (UserRepository), no de una implementación concreta.
### Patrones de Diseño
1. **Builder (Patrón Creacional)**

     - Clases: UserBuilder, UserRepositoryBuilder
     - Propósito: Construcción de objetos User y UserRepositoryImpl de manera flexible.
     - Ejemplo:
     ```java
     Copy code
     User usuario1 = new UserBuilder()
        .name("Jhonatan Encinas")
        .email("encinas.jhonatan.dev@gmail.com")
        .build();
     ```
2. **Decorator (Patrón Estructural)**

Clase: RoRuDecorator
Propósito: Añadir funcionalidades adicionales (registro de operaciones) a los objetos UserRepository.
Ejemplo:
java
Copy code
RoRuDecorator repoDecorado = new RoRuDecorator(repo);
Strategy (Patrón de Comportamiento)

Uso Implícito: Uso de interfaces y la inyección de dependencias sigue el mismo principio.
Propósito: Permitir que UserService interactúe con cualquier implementación de UserRepository sin conocer los detalles de la implementación.
Arquitectura de 3 Capas
Capa de Presentación (UI)

Clase: UserUI
Responsabilidad: Manejar la interacción con el usuario y captura de datos.
Código:
java
Copy code
public class UserUI {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        UserRepositoryBuilder repoBuilder = new UserRepositoryBuilder();
        UserRepositoryImpl repo = repoBuilder.build();
        RoRuDecorator repoDecorado = new RoRuDecorator(repo);
        UserService service = new UserService(repoDecorado);
        
        while (true) {
            // Lógica de menú y opciones
        }
    }
}
Capa de Negocio (Service)

Clase: UserService
Responsabilidad: Contiene la lógica de negocio y actúa como intermediario entre la capa de presentación y la capa de datos.
Código:
java
Copy code
public class UserService {
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Métodos para registrar, obtener, eliminar usuarios
}
Capa de Datos (Repository)

Clases: UserRepository, UserRepositoryImpl, RoRuDecorator
Responsabilidad: Manejar las operaciones de almacenamiento y recuperación de datos.
Código:
java
Copy code
public interface UserRepository {
    void saveUser(User user);
    User getUser(String email);
    void deleteUser(String email);
    List<User> getAllUsers();
}

public class UserRepositoryImpl implements UserRepository {
    private Map<String, User> users;
    
    public UserRepositoryImpl(Map<String, User> users) {
        this.users = users;
    }
    
    // Implementación de métodos
}

public class RoRuDecorator extends UserRepositoryDecorator {
    // Implementación de métodos con funcionalidades adicionales
}
Código Fuente
Estructura de Archivos
plaintext
Copy code
src/
│
├── data/
│   ├── RoRuDecorator.java
│   ├── UserRepository.java
│   ├── UserRepositoryBuilder.java
│   └── UserRepositoryImpl.java
│
├── domain/
│   ├── User.java
│   └── UserBuilder.java
│
├── presentation/
│   ├── Main.java
│   └── UserUI.java
│
├── service/
│   └── UserService.java
│
└── utils/
    └── UtilsUser.java
Clases y Rutas
data/RoRuDecorator.java:

java
Copy code
public class RoRuDecorator extends UserRepositoryDecorator {
    // Implementación de métodos con registro de operaciones
}
data/UserRepository.java:

java
Copy code
public interface UserRepository {
    void saveUser(User user);
    User getUser(String email);
    void deleteUser(String email);
    List<User> getAllUsers();
}
data/UserRepositoryBuilder.java:

java
Copy code
public class UserRepositoryBuilder {
    private Map<String, User> users = new HashMap<>();
    
    public UserRepositoryBuilder addUser(User user) {
        users.put(user.getEmail(), user);
        return this;
    }
    
    public UserRepositoryImpl build() {
        return new UserRepositoryImpl(users);
    }
}
data/UserRepositoryImpl.java:

java
Copy code
public class UserRepositoryImpl implements UserRepository {
    private Map<String, User> users;
    
    public UserRepositoryImpl(Map<String, User> users) {
        this.users = users;
    }
    
    // Implementación de métodos
}
domain/User.java:

java
Copy code
public class User {
    private String name;
    private String email;
    
    // Getters y Setters
}
domain/UserBuilder.java:

java
Copy code
public class UserBuilder {
    private String name;
    private String email;
    
    // Métodos de construcción
}
presentation/Main.java:

java
Copy code
public class Main {
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        userUI.run();
    }
}
presentation/UserUI.java:

java
Copy code
public class UserUI {
    public void run() {
        // Lógica de menú y opciones
    }
}
service/UserService.java:

java
Copy code
public class UserService {
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // Métodos para registrar, obtener, eliminar usuarios
}
